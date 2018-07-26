package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTutAssess1;
import com.pms.service.TutAssess1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/tut_assess1")
public class TutAssess1Controller {
    @Autowired
    private TutAssess1Service tutAssess1Service;

    @RequestMapping("/create")
    @ResponseBody
    public PmsResult createAssess(PmsTutAssess1 pmsTutAssess1){
        PmsResult pmsResult= tutAssess1Service.createTutAssess1(pmsTutAssess1);
        return pmsResult;
    }

    @RequestMapping("/get/{planId}")
    @ResponseBody
    public PmsTutAssess1 getAssess1ByPlanId(@PathVariable long planId){
        PmsTutAssess1 pmsTutAssess1 = tutAssess1Service.getAssess1ByPlanId(planId);
        return pmsTutAssess1;
    }
}
