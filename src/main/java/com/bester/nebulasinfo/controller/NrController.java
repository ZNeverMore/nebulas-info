package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.NrNatService;
import com.bester.nebulasinfo.service.NrTransactionService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@RestController
public class NrController {

    @Resource
    private NrTransactionService nrTransactionService;

    @Resource
    private NrNatService nrNatService;

    @PostMapping("/nr/insert")
    public CommonResult insertNrTx(@RequestBody Map<String, List<PledgeOrNrTxEntity>> map) {
        List<PledgeOrNrTxEntity> nrTxList = map.get("nrTxList");
        if (CollectionUtils.isEmpty(nrTxList)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            nrTxList.forEach(item -> {
                PledgeOrNrTxEntity tx = nrTransactionService.getTxByHash(item.getHash());
                if (tx == null) {
                    nrTransactionService.insertNrTx(item);
                }
            });
        } catch (Exception e) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("nr insert success");
    }

    @PostMapping("/nr/insert/single")
    public CommonResult insertNtTxSingle(@RequestBody PledgeOrNrTxEntity entity) {
        if (StringUtils.isEmpty(entity.getHash()) || entity.getTimestamp() < 0) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        try {
            PledgeOrNrTxEntity tx = nrTransactionService.getTxByHash(entity.getHash());
            if (tx == null) {
                nrTransactionService.insertNrTx(entity);
            } else {
                return CommonResult.fail("nr tx already exits");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("nr insert single success");
    }

    @PostMapping("/nr/insert/nat")
    public CommonResult insertNrNat(@RequestBody PledgeOrNrNatEntity entity) {
        if (StringUtils.isEmpty(entity.getAddr()) || StringUtils.isEmpty(entity.getValue()) || StringUtils.isEmpty(entity.getHash())) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            List<PledgeOrNrNatEntity> nrNatListByTxHash = nrNatService.getNrNatListByTxHash(entity.getHash());
            if (CollectionUtils.isEmpty(nrNatListByTxHash)) {
                nrNatService.insertNrNat(entity);
            } else {
                return CommonResult.fail("nr nat by hash already exits");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("nr nat insert success");
    }

}
