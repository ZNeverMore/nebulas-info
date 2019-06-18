package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import com.bester.nebulasinfo.entity.VoteDataEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {

    @Resource
    private PledgeTransactionDao pledgeTransactionDao;

    @Resource
    private VoteDataDao voteDataDao;

    @Resource
    private PledgeNatDao pledgeNatDao;

    @Test
    public void get() {
        PledgeOrNrTxEntity tx = pledgeTransactionDao.getTxByHash(null);
        System.out.println(tx);
    }

    @Test
    public void createVote() {
        VoteDataEntity voteDataEntity = new VoteDataEntity();
        voteDataEntity.setHash("abcabcabcabc");
        voteDataEntity.setUsedNat("100");
        voteDataEntity.setTimestamp(123456789123L);
        int i = voteDataDao.insertHashAndTimestamp(voteDataEntity);
        System.out.println(i);
    }

    @Test
    public void findNatByHash() {
        List<PledgeOrNrNatEntity> abc = pledgeNatDao.getPledgeNatListByTxHash("abc");
        System.out.println(abc);
    }

}
