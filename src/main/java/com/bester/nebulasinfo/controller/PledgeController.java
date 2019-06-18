package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.PledgeNatService;
import com.bester.nebulasinfo.service.PledgeTransactionService;
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
public class PledgeController {

    @Resource
    private PledgeTransactionService pledgeTransactionService;

    @Resource
    private PledgeNatService pledgeNatService;

    @PostMapping("/pledge/insert")
    public CommonResult insertPledgeTx(@RequestBody Map<String, List<PledgeOrNrTxEntity>> map) {
        List<PledgeOrNrTxEntity> pledgeList = map.get("pledgeTxList");
        if (CollectionUtils.isEmpty(pledgeList)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            pledgeList.forEach(item -> {
                PledgeOrNrTxEntity tx = pledgeTransactionService.getTxByHash(item.getHash());
                if (tx == null) {
                    pledgeTransactionService.insertPledgeTx(item);
                }
            });
        } catch (Exception e) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("insert success");
    }

    @PostMapping("/pledge/insert/single")
    public CommonResult insertPledgeTxSingle(@RequestBody PledgeOrNrTxEntity entity) {
        if (StringUtils.isEmpty(entity.getHash()) || entity.getTimestamp() < 0) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            PledgeOrNrTxEntity tx = pledgeTransactionService.getTxByHash(entity.getHash());
            if (tx == null) {
                pledgeTransactionService.insertPledgeTx(entity);
            } else {
                return CommonResult.fail("pledge tx already exits");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

    @PostMapping("/pledge/insert/nat")
    public CommonResult insertPledgeNat(@RequestBody PledgeOrNrNatEntity entity) {
        if (StringUtils.isEmpty(entity.getAddr()) || StringUtils.isEmpty(entity.getValue()) || StringUtils.isEmpty(entity.getHash())) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            List<PledgeOrNrNatEntity> pledgeNatListByTxHash = pledgeNatService.getPledgeNatListByTxHash(entity.getHash());
            if (CollectionUtils.isEmpty(pledgeNatListByTxHash)) {
                pledgeNatService.insertPledgeNat(entity);
            } else {
                return CommonResult.fail("pledge nat by hash already exits");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("insert pledge nat by hash success");
    }

}
