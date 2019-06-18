package com.bester.nebulasinfo.service.impl;

import com.bester.nebulasinfo.dao.NrNatDao;
import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import com.bester.nebulasinfo.service.NrNatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-18
 */
@Service
public class NrNatServiceImpl implements NrNatService {

    @Resource
    private NrNatDao nrNatDao;

    @Override
    public List<PledgeOrNrNatEntity> getNrNatListByTxHash(String hash) {
        return nrNatDao.getNrNatListByTxHash(hash);
    }

    @Override
    public int insertNrNat(PledgeOrNrNatEntity entity) {
        return nrNatDao.insertNrNat(entity);
    }
}
