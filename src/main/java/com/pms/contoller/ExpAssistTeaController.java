package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsExpAssistTea;
import com.pms.service.ExpAssistTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:wong
 */
@Controller
public class ExpAssistTeaController {

    @Autowired
    private ExpAssistTeaService expAssistTeaService;

    @RequestMapping("/expTea/create")
    @ResponseBody
    public PmsResult createExpTea(PmsExpAssistTea pmsExpAssistTea){
        PmsResult pmsResult = expAssistTeaService.createExpTea(pmsExpAssistTea);
        return pmsResult;
    }

    @RequestMapping("/expTea/deleteByTeaId/{teaId}")
    @ResponseBody
    public PmsResult deleteByTeaId(@PathVariable long teaId){
        PmsResult pmsResult = expAssistTeaService.deleteExpTeaByTeaId(teaId);
        return pmsResult;
    }
}
