package com.bester.nebulasinfo.service.impl;

import com.bester.nebulasinfo.dao.PledgeTransactionDao;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.service.PledgeTransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Service
public class PledgeTransactionServiceImpl implements PledgeTransactionService {

    @Resource
    private PledgeTransactionDao pledgeTransactionDao;

    @Override
    public PledgeOrNrTxEntity getTxByHash(String hash) {
        return pledgeTransactionDao.getTxByHash(hash);
    }

    @Override
    public List<PledgeOrNrTxEntity> filterTxByPeriod(Long start, Long end) {
        return pledgeTransactionDao.filterTxByPeriod(start, end);
    }

    @Override
    public int insertPledgeTx(PledgeOrNrTxEntity pledgeOrNrTxEntity) {
        return pledgeTransactionDao.insertPledgeTx(pledgeOrNrTxEntity);
    }
}
