package com.pms.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:wong
 */
@Controller
public class PageController {

    @RequestMapping("/test/page")
    public String testPage(){
        return "tea_task";
    }

    @RequestMapping("/tea_page")
    public String showTeaPage(Model model,long expId, String expName){
        model.addAttribute("expId",expId);
        model.addAttribute("expName",expName);
        return "tea_task";
    }
}
