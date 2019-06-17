package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.PledgeTransactionService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@RestController
public class PledgeTransactionController {

    @Resource
    private PledgeTransactionService pledgeTransactionService;

    @PostMapping("/pledge/insert")
    public CommonResult insertPledgeTx(@RequestBody Map<String, List<PledgeOrNrTxEntity>> map) {
        List<PledgeOrNrTxEntity> pledgeList = map.get("pledgeList");
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

}
