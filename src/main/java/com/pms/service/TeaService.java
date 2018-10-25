package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserTea;
import com.pms.pojo.TeaExp;

import java.util.List;

/**
 * @author:wong
 */
public interface TeaService {
    PmsResult searchByName(String nickname);
    List<PmsUserTea> getList();
    List<TeaExp> findTeaExpList();
    PmsUserTea findTeaByExpId(long expId);
    List<PmsUserTea> findAssistTeaByExpId(long expId);
}
