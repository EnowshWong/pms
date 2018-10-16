package com.pms.contoller;

import com.pms.common.utils.CookieUtils;
import com.pms.pojo.PmsExp;
import com.pms.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:wong
 */
@Controller
public class PageController {

    @Autowired
    private ExpService expService;
    @Value("${COOKIE_EXPID}")
    private String COOKIE_EXPID;

    @RequestMapping("/test/page")
    public String testPage(){
        return "tea_task_back";
    }

    @RequestMapping("/tea_page")
    public String showTeaPage(HttpServletRequest request, HttpServletResponse response,Model model, long expId){
        //根据实验室id查询实验室具体信息
        PmsExp pmsExp = expService.getExpById(expId);
        //将实验室id写入Cookie

        CookieUtils.setCookie(request, response,COOKIE_EXPID, expId+"");
        model.addAttribute("expId",expId);
        model.addAttribute("expName",pmsExp.getExpName());
        return "tea_task";
    }
}
