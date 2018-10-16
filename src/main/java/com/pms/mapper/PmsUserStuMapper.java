package com.pms.mapper;

import com.pms.pojo.PmsUserStu;
import com.pms.pojo.PmsUserStuExample;
import com.pms.pojo.StuInfo;
import com.pms.pojo.StuPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsUserStuMapper {
    int countByExample(PmsUserStuExample example);

    int deleteByExample(PmsUserStuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsUserStu record);

    int insertSelective(PmsUserStu record);

    List<PmsUserStu> selectByExample(PmsUserStuExample example);

    PmsUserStu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsUserStu record, @Param("example") PmsUserStuExample example);

    int updateByExample(@Param("record") PmsUserStu record, @Param("example") PmsUserStuExample example);

    int updateByPrimaryKeySelective(PmsUserStu record);

    int updateByPrimaryKey(PmsUserStu record);

    List<StuPlan> findStuPlanListByExpId(Long expId);

    Long insertReturnId(PmsUserStu record);

    StuInfo findStuInfoById(Long id);
}