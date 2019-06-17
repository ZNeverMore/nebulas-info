package com.bester.nebulasinfo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-06-17
 */
@Data
public class PledgeOrNrNatEntity {

    private Integer id;

    private String addr;

    private String value;

    private String hash;

    private Date createTime;

    private Date updateTime;

}
