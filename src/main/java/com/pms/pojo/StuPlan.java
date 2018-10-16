package com.pms.pojo;

import java.util.List;

/**
 * @author:wong
 * 某一学生正在进行计划定义
 */
public class StuPlan{
    private long id;
    private String nickname;
    private List<PmsPlan> plans;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<PmsPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<PmsPlan> plans) {
        this.plans = plans;
    }
}
