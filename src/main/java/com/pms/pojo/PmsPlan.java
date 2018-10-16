package com.pms.pojo;

import java.util.Date;

public class PmsPlan {
    private Long id;

    private String title;

    private Long stuId;

    private Date created;

    private Date expired;

    private Byte status1;

    private Byte status2;

    private Byte status;

    private Date optime;

    private String planDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Byte getStatus1() {
        return status1;
    }

    public void setStatus1(Byte status1) {
        this.status1 = status1;
    }

    public Byte getStatus2() {
        return status2;
    }

    public void setStatus2(Byte status2) {
        this.status2 = status2;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc == null ? null : planDesc.trim();
    }
}