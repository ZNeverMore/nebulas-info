package com.bester.nebulasinfo.service;

import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface NrTransactionService {

    PledgeOrNrTxEntity getTxByHash(String hash);

    int insertNrTx(PledgeOrNrTxEntity pledgeOrNrTxEntity);

}
