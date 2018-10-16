package com.pms.mapper;

import com.pms.pojo.PmsTempPlan;
import com.pms.pojo.PmsTempPlanExample;
import com.pms.pojo.PmsTempPlanWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsTempPlanMapper {
    int countByExample(PmsTempPlanExample example);

    int deleteByExample(PmsTempPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsTempPlanWithBLOBs record);

    int insertSelective(PmsTempPlanWithBLOBs record);

    List<PmsTempPlanWithBLOBs> selectByExampleWithBLOBs(PmsTempPlanExample example);

    List<PmsTempPlan> selectByExample(PmsTempPlanExample example);

    PmsTempPlanWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsTempPlanWithBLOBs record, @Param("example") PmsTempPlanExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsTempPlanWithBLOBs record, @Param("example") PmsTempPlanExample example);

    int updateByExample(@Param("record") PmsTempPlan record, @Param("example") PmsTempPlanExample example);

    int updateByPrimaryKeySelective(PmsTempPlanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsTempPlanWithBLOBs record);

    int updateByPrimaryKey(PmsTempPlan record);
}