package com.bester.nebulasinfo.service;

import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface PledgeTransactionService {

    PledgeOrNrTxEntity getTxByHash(String hash);

    List<PledgeOrNrTxEntity> filterTxByPeriod(Long start, Long end);

    int insertPledgeTx(PledgeOrNrTxEntity pledgeOrNrTxEntity);

}
