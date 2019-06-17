package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface NrNatDao {

    List<PledgeOrNrNatEntity> getNrNatListByTxhash(@Param("hash") String hash);

    int insertNrNat(@Param("entity") PledgeOrNrNatEntity entity);

}
