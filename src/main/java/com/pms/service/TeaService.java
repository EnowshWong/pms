package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserTea;

import java.util.List;

/**
 * @author:wong
 */
public interface TeaService {
    PmsResult searchByName(String nickname);
    List<PmsUserTea> getList();
}
