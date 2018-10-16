package com.pms.pojo;

import java.util.Date;

/**
 * @author:wong
 */
public class PlanLatest extends PmsPlan {
    private String nickname;
    private Date enrollDate;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }
}
