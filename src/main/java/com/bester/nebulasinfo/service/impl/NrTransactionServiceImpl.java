package com.bester.nebulasinfo.service.impl;

import com.bester.nebulasinfo.dao.NrTransactionDao;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.NrTransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Service
public class NrTransactionServiceImpl implements NrTransactionService {

    @Resource
    private NrTransactionDao nrTransactionDao;

    @Override
    public PledgeOrNrTxEntity getTxByHash(String hash) {
        return nrTransactionDao.getTxByHash(hash);
    }

    @Override
    public int insertNrTx(PledgeOrNrTxEntity pledgeOrNrTxEntity) {
        return nrTransactionDao.insertNrTx(pledgeOrNrTxEntity);
    }
}
