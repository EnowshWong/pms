package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTutAssess2;
import com.pms.service.TutAssess2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/tut_assess2")
public class TutAssess2Controller {
    @Autowired
    private TutAssess2Service tutAssess2Service;

    @RequestMapping("/create")
    @ResponseBody
    public PmsResult createAssess(PmsTutAssess2 pmsTutAssess2){
        PmsResult pmsResult = tutAssess2Service.createAssess(pmsTutAssess2);
        return pmsResult;
    }

    @RequestMapping("/get/{planId}")
    @ResponseBody
    public PmsTutAssess2 getAssessByPlanId(@PathVariable long planId){
        PmsTutAssess2 assess = tutAssess2Service.getAssessByPlanId(planId);
        return assess;
    }
}
