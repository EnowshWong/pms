package com.pms.mapper;

import com.pms.pojo.PmsAssess;
import com.pms.pojo.PmsAssessExample;
import com.pms.pojo.PmsAssessWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAssessMapper {
    int countByExample(PmsAssessExample example);

    int deleteByExample(PmsAssessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAssessWithBLOBs record);

    int insertSelective(PmsAssessWithBLOBs record);

    List<PmsAssessWithBLOBs> selectByExampleWithBLOBs(PmsAssessExample example);

    List<PmsAssess> selectByExample(PmsAssessExample example);

    PmsAssessWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsAssessWithBLOBs record, @Param("example") PmsAssessExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsAssessWithBLOBs record, @Param("example") PmsAssessExample example);

    int updateByExample(@Param("record") PmsAssess record, @Param("example") PmsAssessExample example);

    int updateByPrimaryKeySelective(PmsAssessWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsAssessWithBLOBs record);

    int updateByPrimaryKey(PmsAssess record);
}