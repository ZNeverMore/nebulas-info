package com.bester.nebulasinfo.controller;

import com.bester.nebulasinfo.common.CommonResult;
import com.bester.nebulasinfo.common.HttpStatus;
import com.bester.nebulasinfo.entity.VoteDataEntity;
import com.bester.nebulasinfo.service.VoteDataService;
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
public class VoteDataController {

    @Resource
    private VoteDataService voteDataService;

    @PostMapping("/vote/insert/hash")
    public CommonResult insertHashAndTimestamp(@RequestBody Map<String, List<VoteDataEntity>> map) {
        List<VoteDataEntity> voteTxList = map.get("voteTxList");
        if (CollectionUtils.isEmpty(voteTxList)) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            voteTxList.forEach(item -> {
                VoteDataEntity data = voteDataService.getDataByHash(item.getHash());
                if (data == null) {
                    voteDataService.insertHashAndTimestamp(item);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success("vote insert hash success");
    }

    @PostMapping("/vote/insert/single")
    public CommonResult insertHashAndTimestampSingle(@RequestBody VoteDataEntity entity) {
        if (StringUtils.isEmpty(entity.getHash()) || entity.getTimestamp() < 0 || StringUtils.isEmpty(entity.getUsedNat())) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            VoteDataEntity dataByHash = voteDataService.getDataByHash(entity.getHash());
            if (dataByHash == null) {
                voteDataService.insertHashAndTimestamp(entity);
            } else {
                return CommonResult.fail("vote tx already exits");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

    @PostMapping("/vote/insert/reward")
    public CommonResult insertRewardAndAddrAndNat(@RequestBody VoteDataEntity entity) {
        if (StringUtils.isEmpty(entity.getHash()) || StringUtils.isEmpty(entity.getReward()) || StringUtils.isEmpty(entity.getAddr()) || StringUtils.isEmpty(entity.getBurnNat())) {
            return CommonResult.fail(HttpStatus.PARAMETER_ERROR);
        }
        try {
            VoteDataEntity dataByHash = voteDataService.getDataByHash(entity.getHash());
            if (dataByHash.getTimestamp() > 0 && StringUtils.isEmpty(dataByHash.getUsedNat())) {
                voteDataService.updateRewardAndAddrAndNatByHash(entity);
            } else {
                return CommonResult.fail("no vote tx");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(HttpStatus.ERROR);
        }
        return CommonResult.success();
    }

}
