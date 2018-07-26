package com.pms.pojo;

import java.util.Date;

public class PmsStuAssess {
    private Long id;

    private Long planId;

    private Long stuId;

    private Date created;

    private String selfJudge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSelfJudge() {
        return selfJudge;
    }

    public void setSelfJudge(String selfJudge) {
        this.selfJudge = selfJudge == null ? null : selfJudge.trim();
    }
}