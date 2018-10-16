package com.pms.pojo;

public class PmsTempPlanWithBLOBs extends PmsTempPlan {
    private String planDesc;

    private String fadeback;

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc == null ? null : planDesc.trim();
    }

    public String getFadeback() {
        return fadeback;
    }

    public void setFadeback(String fadeback) {
        this.fadeback = fadeback == null ? null : fadeback.trim();
    }
}