package com.bester.nebulasinfo.service;

import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface PledgeNatService {

    List<PledgeOrNrNatEntity> getPledgeNatListByTxHash(String hash);

    int insertPledgeNat(PledgeOrNrNatEntity entity);

}
