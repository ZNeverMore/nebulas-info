package com.bester.nebulasinfo.service;

import com.bester.nebulasinfo.entity.VoteDataEntity;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface VoteDataService {

    VoteDataEntity getDataByHash(String hash);

    int insertHashAndTimestamp(VoteDataEntity entity);

    int updateRewardAndAddrAndNatByHash(VoteDataEntity entity);

}
