package com.bester.nebulasinfo.service.impl;

import com.bester.nebulasinfo.dao.VoteDataDao;
import com.bester.nebulasinfo.entity.VoteDataEntity;
import com.bester.nebulasinfo.service.VoteDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Service
public class VoteDataServiceImpl implements VoteDataService {

    @Resource
    private VoteDataDao voteDataDao;

    @Override
    public VoteDataEntity getDataByHash(String hash) {
        return voteDataDao.getDataByHash(hash);
    }

    @Override
    public int insertHashAndTimestamp(VoteDataEntity entity) {
        return voteDataDao.insertHashAndTimestamp(entity);
    }

    @Override
    public int updateRewardAndAddrAndNatByHash(VoteDataEntity entity) {
        return voteDataDao.updateRewardAndAddrAndNatByHash(entity);
    }
}
