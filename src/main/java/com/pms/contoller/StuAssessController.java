package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsStuAssess;
import com.pms.service.StuAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/stu_assess")
public class StuAssessController {
    @Autowired
    private StuAssessService stuAssessService;

    @RequestMapping("/create")
    @ResponseBody
    public PmsResult createAssess(PmsStuAssess pmsStuAssess){
        PmsResult pmsResult = stuAssessService.createAssess(pmsStuAssess);
        return pmsResult;
    }

    @RequestMapping("/get/{planId}")
    @ResponseBody
    public PmsStuAssess getAssessByPlanId(@PathVariable long planId){
        PmsStuAssess assess = stuAssessService.getAssessByPlanId(planId);
        return assess;
    }
}
