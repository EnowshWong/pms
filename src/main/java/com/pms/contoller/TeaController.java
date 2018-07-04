package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsUserTea;
import com.pms.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:wong
 */
@Controller
@RequestMapping("/tea")
public class TeaController {

    @Autowired
    private TeaService teaService;

    @RequestMapping("/searchByName")
    @ResponseBody
    public PmsResult searchByName(String nickname){
        PmsResult pmsResult = teaService.searchByName(nickname);
        return pmsResult;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<PmsUserTea> getList(){
        List<PmsUserTea> list = teaService.getList();
        return list;
    }
}
