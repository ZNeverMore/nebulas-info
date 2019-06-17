package com.bester.nebulasinfo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Data
public class VoteDataEntity {

    private Integer id;

    private String hash;

    private Long timestamp;

    private String usedNat;

    private String reward;

    private String addr;

    private String burnNat;

    private Date createTime;

    private Date updateTime;

}
