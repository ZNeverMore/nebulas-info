package com.bester.nebulasinfo.service.impl;

import com.bester.nebulasinfo.dao.PledgeNatDao;
import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.service.PledgeNatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Service
public class PledgeNatServiceImpl implements PledgeNatService {

    @Resource
    private PledgeNatDao pledgeNatDao;

    @Override
    public List<PledgeOrNrNatEntity> getPledgeNatListByTxHash(String hash) {
        return pledgeNatDao.getPledgeNatListByTxHash(hash);
    }

    @Override
    public int insertPledgeNat(PledgeOrNrNatEntity entity) {
        return pledgeNatDao.insertPledgeNat(entity);
    }
}
