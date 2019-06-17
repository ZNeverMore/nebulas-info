package com.bester.nebulasinfo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Data
public class PledgeOrNrTxEntity {

    private Integer id;

    private String hash;

    private Long timestamp;

    private Date createTime;

    private Date updateTime;

}
