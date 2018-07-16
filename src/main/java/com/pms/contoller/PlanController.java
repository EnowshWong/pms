package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsPlan;
import com.pms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

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
    public PmsResult createPlan(PmsPlan pmsPlan){
        System.out.println(pmsPlan.getCreated().toLocaleString());
        PmsResult pmsResult = planService.createPlan(pmsPlan);
        return pmsResult;
    }

    @RequestMapping("/list/{stuId}")
    @ResponseBody
    public List<PmsPlan> getPlanListByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getPlanListByStuId(stuId);
        return list;
    }
}
