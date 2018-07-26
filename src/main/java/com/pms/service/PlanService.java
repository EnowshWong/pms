package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PlanAllAssess;
import com.pms.pojo.PlanAssess1;
import com.pms.pojo.PmsPlan;

import java.util.List;

/**
 * @author:wong
 */
public interface PlanService {
    PmsResult createPlan(PmsPlan pmsPlan);
    List<PmsPlan> getPlanListByStuId(long stuId);
    List<PlanAssess1> findPlanAssess1ByStuId(long stuId);
    List<PlanAllAssess> getPlanAllAssessByStuId(long stuId);
    PlanAssess1 findPlanAssess1ById(long id);
    List<PmsPlan> getExpiredPlanListByStuId(long stuId);
}
