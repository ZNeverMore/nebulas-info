package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.VoteDataEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface VoteDataDao {

    VoteDataEntity getDataByHash(@Param("hash") String hash);

    int insertHashAndTimestamp(@Param("data") VoteDataEntity entity);

    int updateRewardAndAddrAndNatByHash(@Param("data") VoteDataEntity entity);

}
