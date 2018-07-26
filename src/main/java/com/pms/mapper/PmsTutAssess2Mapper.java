package com.pms.mapper;

import com.pms.pojo.PmsTutAssess2;
import com.pms.pojo.PmsTutAssess2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsTutAssess2Mapper {
    int countByExample(PmsTutAssess2Example example);

    int deleteByExample(PmsTutAssess2Example example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsTutAssess2 record);

    int insertSelective(PmsTutAssess2 record);

    List<PmsTutAssess2> selectByExampleWithBLOBs(PmsTutAssess2Example example);

    List<PmsTutAssess2> selectByExample(PmsTutAssess2Example example);

    PmsTutAssess2 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsTutAssess2 record, @Param("example") PmsTutAssess2Example example);

    int updateByExampleWithBLOBs(@Param("record") PmsTutAssess2 record, @Param("example") PmsTutAssess2Example example);

    int updateByExample(@Param("record") PmsTutAssess2 record, @Param("example") PmsTutAssess2Example example);

    int updateByPrimaryKeySelective(PmsTutAssess2 record);

    int updateByPrimaryKeyWithBLOBs(PmsTutAssess2 record);

    int updateByPrimaryKey(PmsTutAssess2 record);
}