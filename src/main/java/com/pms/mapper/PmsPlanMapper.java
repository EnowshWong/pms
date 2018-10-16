package com.pms.mapper;

import com.pms.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsPlanMapper {
    int countByExample(PmsPlanExample example);

    int deleteByExample(PmsPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsPlan record);

    int insertSelective(PmsPlan record);

    List<PmsPlan> selectByExampleWithBLOBs(PmsPlanExample example);

    List<PmsPlan> selectByExample(PmsPlanExample example);

    PmsPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsPlan record, @Param("example") PmsPlanExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsPlan record, @Param("example") PmsPlanExample example);

    int updateByExample(@Param("record") PmsPlan record, @Param("example") PmsPlanExample example);

    int updateByPrimaryKeySelective(PmsPlan record);

    int updateByPrimaryKeyWithBLOBs(PmsPlan record);

    int updateByPrimaryKey(PmsPlan record);

    List<PlanAssess1> findPlanAssess1ByStuId(Long stuId);

    PlanAllAssess findPlanAllAssessById(Long id);

    List<PlanAllAssess> findRecentPlanByStuId(Long stuId);

    List<PlanAllAssess> findAllPlanByStuId(Long stuId);

    PlanAssess1 findPlanAssess1ById(Long id);

    PlanAllAssess findPlanAssess2ById(Long id);

    List<PlanAssess2> findPlanAssess2ByStuId(Long stuId);

    List<TeaTaskData> findTeaTaskData(Long expId);

    PlanFJAndSelfJ findFJAndSelfJById(Long id);
}