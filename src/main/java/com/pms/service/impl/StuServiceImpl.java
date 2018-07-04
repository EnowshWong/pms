package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsJoinMapper;
import com.pms.mapper.PmsUserStuMapper;
import com.pms.pojo.PmsJoin;
import com.pms.pojo.PmsJoinExample;
import com.pms.pojo.PmsUserStu;
import com.pms.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author:wong
 */
@Service
@Transactional
public class StuServiceImpl implements StuService {

    @Autowired
    private PmsJoinMapper pmsJoinMapper;
    @Autowired
    private PmsUserStuMapper pmsUserStuMapper;

    @Override
    public PmsResult saveJoin(PmsJoin pmsJoin) {
        PmsUserStu pmsUserStu = pmsUserStuMapper.selectByPrimaryKey(pmsJoin.getStuId());
        Date date=new Date();
        pmsJoin.setCreated(date);
        //默认设置一星期过期
        pmsJoin.setExpired(new Date(date.getYear(),date.getMonth(),date.getDate()+7));
        pmsJoin.setNickname(pmsUserStu.getNickname());
        pmsJoinMapper.insert(pmsJoin);
        return PmsResult.ok();
    }

    @Override
    public PmsResult delJoin(long stuId) {
        PmsJoinExample example=new PmsJoinExample();
        PmsJoinExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        pmsJoinMapper.deleteByExample(example);
        return PmsResult.ok();
    }
}
