package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTempPlan;

import java.util.List;

/**
 * @author:wong
 */
public interface TemplanService {
    PmsResult createTemplan(PmsTempPlan pmsTempPlan);
    List<PmsTempPlan> getTempPlanListByStuId(long stuId);
    PmsResult delTemplanById(long id);
    PmsResult updateTemplan(PmsTempPlan pmsTempPlan);
}
