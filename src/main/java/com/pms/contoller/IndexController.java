package com.pms.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:wong
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/showIndex")
    public String showIndex1(){
        return "index";
    }

    @RequestMapping("/account")
    public String showAccoundPage(){
        return "account";
    }

    //  href=/showRegister，即可跳转到 /templates/register.html页面
    @RequestMapping("/showRegister")
    public String showRegister(){
        //此处只加html文件名，不需要后缀
        return "register";
    }

    @RequestMapping("/showAccountStu")
    public String showAccountStu(){
        return "account_stu";
    }

    @RequestMapping("/showAccountTea")
    public String showAccountTea(){
        return "account_tea";
    }

    @RequestMapping("/showHistory")
    public String showHistory(){
        return "history";
    }

    @RequestMapping("/showTaskStu")
    public String  showTaskStu() {
        return "stu_task4(1)";
    }

    @RequestMapping("/showTeaHome")
    public String showTeaHome(){
        return "tea_home";
    }

    @RequestMapping("/showJoinPage")
    public String showJoinPage(){
        return "stu_home";
    }

    @RequestMapping("/showStuInfPage/{stuId}")
    public String showStuInfPage(@PathVariable long stuId, Model model){
        model.addAttribute("stuId",stuId);
        return "tea_detail";
    }

}
