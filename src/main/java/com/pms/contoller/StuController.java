package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsJoin;
import com.pms.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:wong
 */
@Controller
public class StuController {
    @Autowired
    private StuService stuService;

    @RequestMapping("/stu/join")
    @ResponseBody
    public PmsResult saveJoin(PmsJoin pmsJoin){
        PmsResult pmsResult = stuService.saveJoin(pmsJoin);
        return pmsResult;
    }

    @RequestMapping("/stu/updateJoinStatus")
    @ResponseBody
    public PmsResult updateJoinStatus(long id,Byte status){
        PmsResult pmsResult = stuService.updateJoinStatus(id, status);
        return pmsResult;
    }

    @RequestMapping("/stu/delJoin/{stuId}")
    @ResponseBody
    public PmsResult delJoin(@PathVariable long stuId){
        PmsResult pmsResult = stuService.delJoin(stuId);
        return pmsResult;
    }
}
