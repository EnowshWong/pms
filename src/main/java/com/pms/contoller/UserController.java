package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserStu;
import com.pms.pojo.PmsUserTea;
import com.pms.pojo.StuInfo;
import com.pms.pojo.StuPlan;
import com.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author:wong
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/stu/register",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult stuRegister(PmsUserStu pmsUserStu,HttpServletRequest request,HttpServletResponse response){
        PmsResult pmsResult = userService.stuRegister(pmsUserStu,request,response);
        return pmsResult;
    }

    @RequestMapping(value = "/user/tea/register",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult teaRegister(PmsUserTea pmsUserTea){
        PmsResult pmsResult = userService.teaRegister(pmsUserTea);
        return pmsResult;
    }

    @RequestMapping("/user/login/{identity}")
    public String login(Model model, String username, String password, @PathVariable int identity, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //登陆前清除用户cookie
//        Cookie[] cookies = request.getCookies();
//        if (cookies.length>0){
//            CookieUtils.deleteCookie(request,response,"COOKIE_ID");
//            CookieUtils.deleteCookie(request,response,"COOKIE_IDENTITY");
//            CookieUtils.deleteCookie(request,response,"COOKIE_NICKNAME");
//        }
        //将用户信息存入cookie
        PmsResult pmsResult = userService.login(username, password, identity, request, response);
        if (pmsResult.getStatus() == 200) {
            if (identity == 1) {
                return "stu_task4(1)";
            } else if (identity == 2) {
                return "tea_home";
            }
        }else if (pmsResult.getStatus()==500){
            return "stu_home";
        }
        model.addAttribute("error","用户名或者密码错误");
        return "index";
    }

    @RequestMapping("/user/sucJoin")
    @ResponseBody
    public PmsResult sucJoin(long stuId,long expId,long tutorId,HttpServletRequest request,HttpServletResponse response){
        PmsResult pmsResult = userService.sucJoin(stuId, expId, tutorId,request,response);
        return pmsResult;
    }

    @RequestMapping("/user/stulist/{expId}")
    @ResponseBody
    public List<PmsUserStu> getStuListByExpId(@PathVariable long expId){
        List<PmsUserStu> list = userService.getStulistByExpId(expId);
        return list;
    }

    @RequestMapping("/user/stuPlan/{expId}")
    @ResponseBody
    public List<StuPlan> getStuPlanByExpId(@PathVariable long expId){
        List<StuPlan> list = userService.getStuPlanListByExpId(expId);
        return list;

    }
    @RequestMapping("/user/stu/update")
    @ResponseBody
    public PmsResult updateStu(PmsUserStu pmsUserStu){
        PmsResult pmsResult = userService.stuUpdate(pmsUserStu);
        return pmsResult;
    }

    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        userService.logout(request, response);
        //返回首页
        return "redirect:/";
    }

    @RequestMapping("/user/getStuById/{id}")
    @ResponseBody
    public PmsUserStu getStuById(@PathVariable long id){
        PmsUserStu pmsUserStu = userService.getStuById(id);
        return pmsUserStu;
    }

    @RequestMapping("/user/getTeaList")
    @ResponseBody
    public List<PmsUserTea> getTeaList(){
        List<PmsUserTea> list = userService.getTeaList();
        return list;
    }

    @RequestMapping("/user/getTeaById/{id}")
    @ResponseBody
    public PmsUserTea getTeaById(@PathVariable long id){
        PmsUserTea tea = userService.getTeaById(id);
        return tea;
    }

    @RequestMapping("/user/getStuInfoById/{id}")
    @ResponseBody
    public StuInfo getStuInfoById(@PathVariable long id){
        StuInfo stu = userService.getStuInfoById(id);
        return stu;
    }

    @RequestMapping("/user/getStuListWithoutExp")
    @ResponseBody
    public List<PmsUserStu> getStuListWithoutExp(){
        List<PmsUserStu> list = userService.getStuListWithoutExp();
        return list;
    }
}
