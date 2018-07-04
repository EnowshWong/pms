package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserStu;
import com.pms.pojo.PmsUserTea;
import com.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/stu/register",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult stuRegister(PmsUserStu pmsUserStu){
        PmsResult pmsResult = userService.stuRegister(pmsUserStu);
        return pmsResult;
    }

    @RequestMapping(value = "/tea/register",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult teaRegister(PmsUserTea pmsUserTea){
        PmsResult pmsResult = userService.teaRegister(pmsUserTea);
        return pmsResult;
    }

    @RequestMapping("/login/{identity}")
    @ResponseBody
    public PmsResult login(String username, String password, @PathVariable int identity, HttpServletRequest request, HttpServletResponse response){
        PmsResult pmsResult = userService.login(username, password, identity, request, response);
        return pmsResult;
    }

    @RequestMapping("/sucJoin")
    @ResponseBody
    public PmsResult sucJoin(long stuId,long expId,long tutorId){
        PmsResult pmsResult = userService.sucJoin(stuId, expId, tutorId);
        return pmsResult;
    }

    @RequestMapping("/stulist/{expId}")
    @ResponseBody
    public List<PmsUserStu> getStuListByExpId(@PathVariable long expId){
        List<PmsUserStu> list = userService.getStulistByExpId(expId);
        return list;
    }
}
