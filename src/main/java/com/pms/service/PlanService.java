package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsPlan;

/**
 * @author:wong
 */
public interface PlanService {
    PmsResult createPlan(PmsPlan pmsPlan,String created,String expired);
}
