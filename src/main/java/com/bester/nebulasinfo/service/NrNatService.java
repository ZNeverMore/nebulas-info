package com.bester.nebulasinfo.service;

import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-18
 */

public interface NrNatService {

    List<PledgeOrNrNatEntity> getNrNatListByTxHash(String hash);

    int insertNrNat(PledgeOrNrNatEntity entity);

}
