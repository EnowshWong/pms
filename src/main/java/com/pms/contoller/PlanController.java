package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PlanAllAssess;
import com.pms.pojo.PlanAssess1;
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
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/plan/create")
    @ResponseBody
    public PmsResult createPlan(PmsPlan pmsPlan){
        System.out.println(pmsPlan.getCreated().toLocaleString());
        PmsResult pmsResult = planService.createPlan(pmsPlan);
        return pmsResult;
    }

    @RequestMapping("/plan/list/{stuId}")
    @ResponseBody
    public List<PmsPlan> getPlanListByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getPlanListByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/andAssess1/{stuId}")
    @ResponseBody
    public List<PlanAssess1> getPlanAssess1ByStuId(@PathVariable long stuId){
        List<PlanAssess1> list = planService.findPlanAssess1ByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/allAssess/{stuId}")
    @ResponseBody
    public List<PlanAllAssess> getPlanAllAssessByStuId(@PathVariable long stuId){
        List<PlanAllAssess> list = planService.getPlanAllAssessByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/andAssess1ById/{id}")
    @ResponseBody
    public PlanAssess1 getPlanAssess1ById(@PathVariable long id){
        PlanAssess1 planAssess1= planService.findPlanAssess1ById(id);
        return planAssess1;
    }

    @RequestMapping("/plan/getExpiredList/{stuId}")
    @ResponseBody
    public List<PmsPlan> getExpiredList(@PathVariable long stuId){
        List<PmsPlan> list = planService.getExpiredPlanListByStuId(stuId);
        return list;
    }
}
