package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsTempPlan;
import com.pms.service.TemplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/templan")
public class TemplanController {
    @Autowired
    private TemplanService templanService;

    @RequestMapping("/create")
    @ResponseBody
    public PmsResult createTemplan(PmsTempPlan pmsTempPlan){
        PmsResult pmsResult = templanService.createTemplan(pmsTempPlan);
        return pmsResult;
    }

    @RequestMapping("/list/{stuId}")
    @ResponseBody
    public List<PmsTempPlan> getTempPlanByStuId(@PathVariable long stuId){
        List<PmsTempPlan> list = templanService.getTempPlanListByStuId(stuId);
        return list;
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public PmsResult delTempPlanById(@PathVariable long id){
        PmsResult pmsResult = templanService.delTemplanById(id);
        return pmsResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public PmsResult updateTemplanById(PmsTempPlan pmsTempPlan){
        PmsResult pmsResult = templanService.updateTemplan(pmsTempPlan);
        return pmsResult;
    }
}
