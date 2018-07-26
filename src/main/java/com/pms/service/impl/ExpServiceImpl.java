package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsExpMapper;
import com.pms.mapper.PmsJoinMapper;
import com.pms.pojo.*;
import com.pms.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:wong
 */
@Service
@Transactional
public class ExpServiceImpl implements ExpService {
    @Autowired
    private PmsExpMapper pmsExpMapper;

    @Autowired
    private PmsJoinMapper pmsJoinMapper;

    @Override
    public PmsResult create(PmsExp pmsExp) {
        Date date=new Date();
        pmsExp.setCreated(date);
        pmsExpMapper.insertSelective(pmsExp);
        return PmsResult.ok();
    }

    @Override
    public PmsResult delete(long id) {
        pmsExpMapper.deleteByPrimaryKey(id);
        return PmsResult.ok();
    }

    @Override
    public List<PmsExp> getPmsList() {
        PmsExpExample expExample=new PmsExpExample();
        List<PmsExp> list = pmsExpMapper.selectByExampleWithBLOBs(expExample);
        return list;
    }

    @Override
    public List<PmsExp> getExpByTeaId(long id) {
        PmsExpExample expExample=new PmsExpExample();
        PmsExpExample.Criteria criteria=expExample.createCriteria();
        criteria.andTutorIdEqualTo(id);
        List<PmsExp> list = pmsExpMapper.selectByExample(expExample);
        return list;
    }

    @Override
    public List<PmsJoin> getJoin(long expId) {
        PmsJoinExample example=new PmsJoinExample();
        PmsJoinExample.Criteria criteria=example.createCriteria();
        Date date=new Date();
        criteria.andExpiredGreaterThan(date);
        criteria.andExpIdEqualTo(expId);
        List<PmsJoin> list = pmsJoinMapper.selectByExample(example);
        return list;
    }
}
