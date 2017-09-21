package com.spring.common.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/9/8.
 */
public class EntityCpu {
    private Double userRatio;//使用率
    private Timestamp addDate;//时间

    public EntityCpu(Double userRatio, Timestamp addDate) {
        this.userRatio = userRatio;
        this.addDate = addDate;
    }

    public EntityCpu() {
    }

    public Double getUserRatio() {
        return userRatio;
    }

    public void setUserRatio(Double userRatio) {
        this.userRatio = userRatio;
    }

    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }
}
