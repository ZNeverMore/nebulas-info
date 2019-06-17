package com.bester.nebulasinfo.dao;

import com.bester.nebulasinfo.entity.PledgeOrNrNatEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */

public interface PledgeNatDao {

    List<PledgeOrNrNatEntity> getPledgeNatListByTxHash(@Param("hash") String hash);

    int insertPledgeNat(@Param("entity") PledgeOrNrNatEntity entity);

}
