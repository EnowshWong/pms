package com.pms.pojo;

import java.util.Date;

public class PmsAssess {
    private Long id;

    private Long planId;

    private Byte ispassed;

    private Byte grade;

    private Date created;

    private Date updated;

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

    public Byte getIspassed() {
        return ispassed;
    }

    public void setIspassed(Byte ispassed) {
        this.ispassed = ispassed;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}