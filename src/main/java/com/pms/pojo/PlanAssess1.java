package com.pms.pojo;

import java.util.Date;

/**
 * @author:wong
 */
public class PlanAssess1 extends PmsPlan {
    private String assess;
    private Date assessDate;

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public Date getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }
}
