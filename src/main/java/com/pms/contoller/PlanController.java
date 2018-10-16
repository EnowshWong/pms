package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.*;
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
        PmsResult result = planService.createPlan(pmsPlan);
        return result;
    }


    @RequestMapping("/plan/delById/{id}")
    @ResponseBody
    public PmsResult delPlanById(@PathVariable long id){
        PmsResult pmsResult = planService.delPlanById(id);
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

    @RequestMapping("/plan/allAssess/{id}")
    @ResponseBody
    public PlanAllAssess getPlanAllAssessById(@PathVariable long id){
        PlanAllAssess list = planService.getPlanAllAssessById(id);
        return list;
    }

    @RequestMapping("/plan/recentPlan/{stuId}")
    @ResponseBody
    public List<PlanAllAssess> getRecentPlanByStuId(@PathVariable long stuId){
        List<PlanAllAssess> list = planService.getRecentPlanByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/allPlan/{stuId}")
    @ResponseBody
    public List<PlanAllAssess> getAllPlanByStuId(@PathVariable long stuId){
        List<PlanAllAssess> list = planService.getAllPlanByStuId(stuId);
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

    @RequestMapping("/plan/andAssess2ById/{id}")
    @ResponseBody
    public PlanAllAssess getPlanAssess2ById(@PathVariable long id){
        PlanAllAssess list = planService.getPlanAssess2ById(id);
        return list;
    }

    @RequestMapping("/plan/update")
    @ResponseBody
    public PmsResult updatePlan(PmsPlan pmsPlan){
        PmsResult pmsResult = planService.updatePlan(pmsPlan);
        return pmsResult;
    }

    @RequestMapping("/plan/andAssess2ByStuId/{stuId}")
    @ResponseBody
    public List<PlanAssess2> getPlanAssess2ByStuId(@PathVariable long stuId){
        List<PlanAssess2> list = planService.getPlanAssess2ByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/getById/{id}")
    @ResponseBody
    public PmsPlan getPlanById(@PathVariable long id){
        PmsPlan planById = planService.getPlanById(id);
        return planById;
    }

    @RequestMapping("/plan/getDoingListByStuId/{stuId}")
    @ResponseBody
    public List<PmsPlan> getDoingListByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getDoingListByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/getDoing/{stuId}")
    @ResponseBody
    public List<PmsPlan> getDoingList(@PathVariable long stuId){
        List<PmsPlan> list = planService.getDoingList(stuId);
        return list;
    }

    @RequestMapping("/plan/getDoneListByStuId/{stuId}")
    @ResponseBody
    public List<PmsPlan> getDoneListByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getDoneListByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/getHistoryListByStuId/{stuId}")
    @ResponseBody
    public List<PmsPlan> getHistoryListByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getHistoryListByStuId(stuId);
        return list;
    }

    @RequestMapping("/plan/getTeaTaskData/{expId}")
    @ResponseBody
    public List<TeaTaskData> getTeaTaskData(@PathVariable long expId){
        List<TeaTaskData> list = planService.getTeaTaskData(expId);
        return list;
    }

    @RequestMapping("/plan/getFJAndSelfJById/{id}")
    @ResponseBody
    public PlanFJAndSelfJ getFJAndSelfJById(@PathVariable long id){
        PlanFJAndSelfJ plan = planService.getFJAndSelfJById(id);
        return plan;
    }

    @RequestMapping("/plan/getNoneSJByStuId/{stuId}")
    @ResponseBody
    public List<PmsPlan> getNoneSJByStuId(@PathVariable long stuId){
        List<PmsPlan> list = planService.getNoneSelfJudgeByStuId(stuId);
        return list;
    }
}
