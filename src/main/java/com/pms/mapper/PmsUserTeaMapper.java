package com.pms.mapper;

import com.pms.pojo.PmsUserTea;
import com.pms.pojo.PmsUserTeaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsUserTeaMapper {
    int countByExample(PmsUserTeaExample example);

    int deleteByExample(PmsUserTeaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsUserTea record);

    int insertSelective(PmsUserTea record);

    List<PmsUserTea> selectByExample(PmsUserTeaExample example);

    PmsUserTea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsUserTea record, @Param("example") PmsUserTeaExample example);

    int updateByExample(@Param("record") PmsUserTea record, @Param("example") PmsUserTeaExample example);

    int updateByPrimaryKeySelective(PmsUserTea record);

    int updateByPrimaryKey(PmsUserTea record);
}