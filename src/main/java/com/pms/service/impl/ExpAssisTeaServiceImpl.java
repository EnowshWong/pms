package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.mapper.PmsExpAssistTeaMapper;
import com.pms.pojo.PmsExpAssistTea;
import com.pms.pojo.PmsExpAssistTeaExample;
import com.pms.service.ExpAssistTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:wong
 */
@Service
@Transactional
public class ExpAssisTeaServiceImpl implements ExpAssistTeaService {

    @Autowired
    private PmsExpAssistTeaMapper pmsExpAssistTeaMapper;

    @Override
    public PmsResult createExpTea(PmsExpAssistTea pmsExpAssistTea) {
        pmsExpAssistTeaMapper.insert(pmsExpAssistTea);
        return PmsResult.ok();
    }

    @Override
    public PmsResult deleteExpTeaByTeaId(long teaId) {
        PmsExpAssistTeaExample example=new PmsExpAssistTeaExample();
        PmsExpAssistTeaExample.Criteria criteria=example.createCriteria();
        criteria.andTutorIdEqualTo(teaId);
        pmsExpAssistTeaMapper.deleteByExample(example);
        return PmsResult.ok();
    }
}
