package com.pms.mapper;

import com.pms.pojo.PmsTempPlan;
import com.pms.pojo.PmsTempPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsTempPlanMapper {
    int countByExample(PmsTempPlanExample example);

    int deleteByExample(PmsTempPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsTempPlan record);

    int insertSelective(PmsTempPlan record);

    List<PmsTempPlan> selectByExampleWithBLOBs(PmsTempPlanExample example);

    List<PmsTempPlan> selectByExample(PmsTempPlanExample example);

    PmsTempPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsTempPlan record, @Param("example") PmsTempPlanExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsTempPlan record, @Param("example") PmsTempPlanExample example);

    int updateByExample(@Param("record") PmsTempPlan record, @Param("example") PmsTempPlanExample example);

    int updateByPrimaryKeySelective(PmsTempPlan record);

    int updateByPrimaryKeyWithBLOBs(PmsTempPlan record);

    int updateByPrimaryKey(PmsTempPlan record);
}