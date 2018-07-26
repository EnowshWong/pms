package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTutAssess1;

/**
 * @author:wong
 */
public interface TutAssess1Service {
    PmsResult createTutAssess1(PmsTutAssess1 pmsTutAssess1);
    PmsTutAssess1 getAssess1ByPlanId(long planId);
}
