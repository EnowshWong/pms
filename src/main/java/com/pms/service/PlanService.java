package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.*;

import java.util.List;

/**
 * @author:wong
 */
public interface PlanService {
    PmsResult createPlan(PmsPlan pmsPlan);
    PmsResult delPlanById(long id);
    List<PmsPlan> getPlanListByStuId(long stuId);
    List<PlanAssess1> findPlanAssess1ByStuId(long stuId);
    List<PlanAllAssess> getRecentPlanByStuId(long stuId);
    List<PlanAllAssess> getAllPlanByStuId(long stuId);
    PlanAllAssess getPlanAllAssessById(long id);
    PlanAssess1 findPlanAssess1ById(long id);
    List<PmsPlan> getExpiredPlanListByStuId(long stuId);
    PlanAllAssess getPlanAssess2ById(long id);
    PmsResult updatePlan(PmsPlan pmsPlan);
    List<PlanAssess2> getPlanAssess2ByStuId(long stuId);
    PmsPlan getPlanById(long id);
    List<PmsPlan> getDoingListByStuId(long stuId);
    List<PmsPlan> getDoneListByStuId(long stuId);
    List<PmsPlan> getHistoryListByStuId(long stuId);
    List<PmsPlan> getDoingList(long stuId);
    List<TeaTaskData> getTeaTaskData(Long expId);
    PlanFJAndSelfJ getFJAndSelfJById(Long id);
    List<PmsPlan> getNoneSelfJudgeByStuId(long stuId);
    List<PmsPlan> getUnfinishedPlanListByStuId(long stuId);
}
