package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.PledgeNatService;
import com.bester.nebulasinfo.service.PledgeTransactionService;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zhangqiang
 * @date 2019-06-11
 */
@RestController
public class Nebulas {

    @Resource
    private PledgeTransactionService pledgeTransactionService;

    @Resource
    private PledgeNatService pledgeNatService;

    @GetMapping("/index")
    public String Index() {
        return "hello";
    }

    @GetMapping("/pledge/nat")
    public CommonResult getPledgeNat(List<Long> list) {
        if (CollectionUtils.isEmpty(list)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        Long startTimestamp = list.get(0);
        Long endTimestamp = list.get(1);
        List<PledgeOrNrTxEntity> pledgeTxList = pledgeTransactionService.filterTxByPeriod(startTimestamp, endTimestamp);
        if (CollectionUtils.isEmpty(pledgeTxList)) {
            return CommonResult.fail(HttpStatus.NOT_FOUND);
        }
        BigDecimal sumNat = new BigDecimal("0.00");
        for (PledgeOrNrTxEntity txEntity : pledgeTxList) {
            List<PledgeOrNrNatEntity> pledgeNatList = pledgeNatService.getPledgeNatListByTxHash(txEntity.getHash());
            for (PledgeOrNrNatEntity entity : pledgeNatList) {
                BigDecimal nat = new BigDecimal(entity.getValue());
                sumNat = sumNat.add(nat);
            }
        }
        sumNat = sumNat.divide(new BigDecimal("1000000000000000000.00"));
        Map<String, Object> map = Maps.newHashMap();
        map.put("pledgeNat", sumNat.intValue());
        return CommonResult.success(map);
    }

}
