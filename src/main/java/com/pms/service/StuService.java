package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsJoin;

/**
 * @author:wong
 */
public interface StuService {
    PmsResult saveJoin(PmsJoin pmsJoin);
    PmsResult delJoin(long stuId);
}
