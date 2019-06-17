package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface NrTransactionDao {

    PledgeOrNrTxEntity getTxByHash(@Param("hash") String hash);

    int insertNrTx(@Param("entity") PledgeOrNrTxEntity pledgeOrNrTxEntity);

}
