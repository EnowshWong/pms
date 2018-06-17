package com.pms.service;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserStu;
import com.pms.pojo.PmsUserTea;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:wong
 */
public interface UserService {
    PmsResult stuRegister(PmsUserStu pmsUserStu);
    PmsResult teaRegister(PmsUserTea pmsUserTea);
    PmsResult login(String username, String password, int identity, HttpServletRequest request, HttpServletResponse response);
}
