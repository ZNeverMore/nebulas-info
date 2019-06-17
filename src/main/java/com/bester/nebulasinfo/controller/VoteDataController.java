package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.VoteDataEntity;
import com.bester.nebulasinfo.service.VoteDataService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@RestController
public class VoteDataController {

    @Resource
    private VoteDataService voteDataService;

    @PostMapping("/vote/insert/hash")
    public CommonResult insertHashAndTimestamp(List<VoteDataEntity> list) {
        if (CollectionUtils.isEmpty(list)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            list.forEach(item -> {
                VoteDataEntity data = voteDataService.getDataByHash(item.getHash());
                if (data == null) {
                    voteDataService.insertHashAndTimestamp(item);
                }
            });
        } catch (Exception e) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

    @PostMapping("/vote/insert/reward")
    public CommonResult insertRewardAndAddrAndNat(List<VoteDataEntity> list) {
        if (CollectionUtils.isEmpty(list)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            list.forEach(item -> {
                VoteDataEntity data = voteDataService.getDataByHash(item.getHash());
                if (data != null) {
                    voteDataService.updateRewardAndAddrAndNatByHash(item);
                }
            });
        } catch (Exception e) {
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

}
