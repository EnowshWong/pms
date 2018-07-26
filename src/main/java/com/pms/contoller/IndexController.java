package com.pms.contoller;

import org.springframework.stereotype.Controller;
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
}
