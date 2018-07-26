package com.pms.mapper;

import com.pms.pojo.PmsStuAssess;
import com.pms.pojo.PmsStuAssessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsStuAssessMapper {
    int countByExample(PmsStuAssessExample example);

    int deleteByExample(PmsStuAssessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsStuAssess record);

    int insertSelective(PmsStuAssess record);

    List<PmsStuAssess> selectByExampleWithBLOBs(PmsStuAssessExample example);

    List<PmsStuAssess> selectByExample(PmsStuAssessExample example);

    PmsStuAssess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsStuAssess record, @Param("example") PmsStuAssessExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsStuAssess record, @Param("example") PmsStuAssessExample example);

    int updateByExample(@Param("record") PmsStuAssess record, @Param("example") PmsStuAssessExample example);

    int updateByPrimaryKeySelective(PmsStuAssess record);

    int updateByPrimaryKeyWithBLOBs(PmsStuAssess record);

    int updateByPrimaryKey(PmsStuAssess record);
}