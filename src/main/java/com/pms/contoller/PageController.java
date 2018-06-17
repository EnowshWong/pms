package com.pms.contoller;

import org.springframework.stereotype.Controller;
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
}
