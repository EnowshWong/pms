package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsExp;
import com.pms.pojo.PmsJoin;

import java.util.List;

/**
 * @author:wong
 */
public interface ExpService {
    PmsResult create(PmsExp pmsExp);
    PmsResult delete(long id);
    List<PmsExp> getPmsList();
    List<PmsExp> getExpByTeaId(long id);
    List<PmsJoin> getJoin(long expId);
}
