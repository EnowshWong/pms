package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsUserTeaMapper;
import com.pms.pojo.PmsTempPlanExample;
import com.pms.pojo.PmsUserTea;
import com.pms.pojo.PmsUserTeaExample;
import com.pms.pojo.TeaExp;
import com.pms.service.TeaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:wong
 */
@Service
@Transactional
public class TeaServiceImpl implements TeaService {
    @Autowired
    private PmsUserTeaMapper pmsUserTeaMapper;

    @Override
    public PmsResult searchByName(String nickname) {
        PmsUserTeaExample example=new PmsUserTeaExample();
        if (StringUtils.isBlank(nickname)) {
            List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
            return PmsResult.ok(list);
        }
        PmsUserTeaExample.Criteria criteria=example.createCriteria();
        criteria.andNicknameLike("%"+nickname+"%");
        List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
        return PmsResult.ok(list);
    }

    @Override
    public List<PmsUserTea> getList() {
        PmsUserTeaExample example=new PmsUserTeaExample();
        List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<TeaExp> findTeaExpList() {
        List<TeaExp> teaExpList = pmsUserTeaMapper.findTeaExpList();
        return teaExpList;
    }
}
