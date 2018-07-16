package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsPlan;

import java.util.List;

/**
 * @author:wong
 */
public interface PlanService {
    PmsResult createPlan(PmsPlan pmsPlan);
    List<PmsPlan> getPlanListByStuId(long stuId);
}
