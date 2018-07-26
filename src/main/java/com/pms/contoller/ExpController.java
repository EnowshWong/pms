package com.pms.contoller;

import com.pms.common.pojo.PmsResult;
import com.pms.pojo.PmsExp;
import com.pms.pojo.PmsJoin;
import com.pms.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:wong
 */
@Controller
public class ExpController {
    @Autowired
    private ExpService expService;

    @RequestMapping(value = "/exp/create",method = RequestMethod.POST)
    @ResponseBody
    public PmsResult create(PmsExp pmsExp){
        PmsResult pmsResult = expService.create(pmsExp);
        return pmsResult;
    }

    @RequestMapping("/exp/delete/{id}")
    @ResponseBody
    public PmsResult delete(@PathVariable long id){
        PmsResult pmsResult = expService.delete(id);
        return pmsResult;
    }

    @RequestMapping("/exp/list")
    @ResponseBody
    public List<PmsExp> getExpList(){
        List<PmsExp> pmsList = expService.getPmsList();
        return pmsList;
    }

    @RequestMapping("/exp/getByTeaId/{id}")
    @ResponseBody
    public List<PmsExp> getByTeaId(@PathVariable long id){
        List<PmsExp> list = expService.getExpByTeaId(id);
        return list;
    }

    @RequestMapping("/exp/getJoin/{expId}")
    @ResponseBody
    public List<PmsJoin> getJoin(@PathVariable long expId){
        List<PmsJoin> list = expService.getJoin(expId);
        return list;
    }
}
