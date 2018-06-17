package com.pms.pojo;

public class PmsAssessWithBLOBs extends PmsAssess {
    private String tutBeforeJudge;

    private String tutAfterJudge;

    private String selfJudge;

    public String getTutBeforeJudge() {
        return tutBeforeJudge;
    }

    public void setTutBeforeJudge(String tutBeforeJudge) {
        this.tutBeforeJudge = tutBeforeJudge == null ? null : tutBeforeJudge.trim();
    }

    public String getTutAfterJudge() {
        return tutAfterJudge;
    }

    public void setTutAfterJudge(String tutAfterJudge) {
        this.tutAfterJudge = tutAfterJudge == null ? null : tutAfterJudge.trim();
    }

    public String getSelfJudge() {
        return selfJudge;
    }

    public void setSelfJudge(String selfJudge) {
        this.selfJudge = selfJudge == null ? null : selfJudge.trim();
    }
}