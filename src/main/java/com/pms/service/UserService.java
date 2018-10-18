package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author:wong
 */
public interface UserService {
    PmsResult stuRegister(PmsUserStu pmsUserStu,HttpServletRequest request,HttpServletResponse response);
    PmsResult teaRegister(PmsUserTea pmsUserTea);
    PmsResult login(String username, String password, int identity, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
    PmsResult sucJoin(long stuId,long expId,long tutorId,HttpServletRequest request,HttpServletResponse response);
    List<PmsUserStu> getStulistByExpId(long expId);
    List<StuPlan> getStuPlanListByExpId(long expId);
    PmsResult stuUpdate(PmsUserStu pmsUserStu);
    PmsResult logout(HttpServletRequest request,HttpServletResponse response);
    PmsUserStu getStuById(long stuId);
    List<PmsUserTea> getTeaList();
    PmsUserTea getTeaById(long id);
    StuInfo getStuInfoById(long id);
    List<PmsUserStu> getStuListWithoutExp();
}
