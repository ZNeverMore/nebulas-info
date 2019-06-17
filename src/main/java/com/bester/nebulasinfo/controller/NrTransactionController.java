package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.NrTransactionService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@RestController
public class NrTransactionController {

    @Resource
    private NrTransactionService nrTransactionService;

    @PostMapping("/nr/insert")
    public CommonResult insertNrTx(List<PledgeOrNrTxEntity> list) {
        if (CollectionUtils.isEmpty(list)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            list.forEach(item -> {
                PledgeOrNrTxEntity tx = nrTransactionService.getTxByHash(item.getHash());
                if (tx == null) {
                    nrTransactionService.insertNrTx(item);
                }
            });
        } catch (Exception e) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

}
