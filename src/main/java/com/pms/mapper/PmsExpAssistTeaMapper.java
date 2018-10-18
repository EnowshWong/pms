package com.pms.mapper;

import com.pms.pojo.PmsExpAssistTea;
import com.pms.pojo.PmsExpAssistTeaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsExpAssistTeaMapper {
    int countByExample(PmsExpAssistTeaExample example);

    int deleteByExample(PmsExpAssistTeaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsExpAssistTea record);

    int insertSelective(PmsExpAssistTea record);

    List<PmsExpAssistTea> selectByExample(PmsExpAssistTeaExample example);

    PmsExpAssistTea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsExpAssistTea record, @Param("example") PmsExpAssistTeaExample example);

    int updateByExample(@Param("record") PmsExpAssistTea record, @Param("example") PmsExpAssistTeaExample example);

    int updateByPrimaryKeySelective(PmsExpAssistTea record);

    int updateByPrimaryKey(PmsExpAssistTea record);
}