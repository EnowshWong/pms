package com.pms.pojo;

import java.util.Date;

public class PmsTutAssess1 {
    private Long id;

    private Long planId;

    private Long tutorId;

    private Date created;

    private String assess;

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

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess == null ? null : assess.trim();
    }
}