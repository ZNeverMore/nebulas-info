package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface PledgeTransactionDao {

    PledgeOrNrTxEntity getTxByHash(@Param("hash") String hash);

    List<PledgeOrNrTxEntity> filterTxByPeriod(@Param("startTimestamp") Long start,
                                              @Param("endTimestamp") Long end);

    int insertPledgeTx(@Param("entity") PledgeOrNrTxEntity pledgeOrNrTxEntity);

}
