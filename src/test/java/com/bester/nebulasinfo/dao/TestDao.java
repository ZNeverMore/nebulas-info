package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrTxEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {

    @Resource
    private PledgeTransactionDao pledgeTransactionDao;

    @Test
    public void get() {
        PledgeOrNrTxEntity tx = pledgeTransactionDao.getTxByHash(null);
        System.out.println(tx);
    }


}
