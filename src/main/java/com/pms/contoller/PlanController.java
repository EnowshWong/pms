package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsPlan;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/create")
    @ResponseBody
    public PmsResult createPlan(PmsPlan pmsPlan, String created,String expired){
        PmsResult pmsResult = planService.createPlan(pmsPlan,created,expired);
        return pmsResult;
    }
}
