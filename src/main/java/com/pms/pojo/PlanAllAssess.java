package com.pms.pojo;

import java.util.Date;

/**
 * @author:wong
 */
public class PlanAllAssess extends PmsPlan {
    private String assess1;
    private Date created1;
    private String assess2;
    private Date created2;
    private Byte grade;
    private String selfJudge;
    private Date created3;

    public String getSelfJudge() {
        return selfJudge;
    }

    public void setSelfJudge(String selfJudge) {
        this.selfJudge = selfJudge;
    }

    public Date getCreated3() {
        return created3;
    }

    public void setCreated3(Date created3) {
        this.created3 = created3;
    }

    public String getAssess1() {
        return assess1;
    }

    public void setAssess1(String assess1) {
        this.assess1 = assess1;
    }

    public Date getCreated1() {
        return created1;
    }

    public void setCreated1(Date created1) {
        this.created1 = created1;
    }

    public String getAssess2() {
        return assess2;
    }

    public void setAssess2(String assess2) {
        this.assess2 = assess2;
    }

    public Date getCreated2() {
        return created2;
    }

    public void setCreated2(Date created2) {
        this.created2 = created2;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }
}
