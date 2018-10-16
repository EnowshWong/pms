package com.pms.pojo;

import java.util.Date;

/**
 * @author:wong
 */
public class TeaTaskData{
    private Long planId;

    private String title;

    private Byte status1;

    private Byte status2;

    private Byte status;

    private Date optime;

    private Long stuId;

    private String nickname;

    private Date enrollDate;

    private Date created;

    private Date expired;

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
