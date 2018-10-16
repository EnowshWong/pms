package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTempPlan;
import com.pms.pojo.PmsTempPlanWithBLOBs;

import java.util.List;

/**
 * @author:wong
 */
public interface TemplanService {
    PmsResult createTemplan(PmsTempPlanWithBLOBs pmsTempPlan);
    List<PmsTempPlanWithBLOBs> getTempPlanListByStuId(long stuId);
    PmsResult delTemplanById(long id);
    PmsResult updateTemplan(PmsTempPlanWithBLOBs pmsTempPlan);
    PmsTempPlanWithBLOBs getById(long id);
}
