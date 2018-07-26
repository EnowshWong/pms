package com.pms.mapper;

import com.pms.pojo.PmsTutAssess1;
import com.pms.pojo.PmsTutAssess1Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsTutAssess1Mapper {
    int countByExample(PmsTutAssess1Example example);

    int deleteByExample(PmsTutAssess1Example example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsTutAssess1 record);

    int insertSelective(PmsTutAssess1 record);

    List<PmsTutAssess1> selectByExampleWithBLOBs(PmsTutAssess1Example example);

    List<PmsTutAssess1> selectByExample(PmsTutAssess1Example example);

    PmsTutAssess1 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsTutAssess1 record, @Param("example") PmsTutAssess1Example example);

    int updateByExampleWithBLOBs(@Param("record") PmsTutAssess1 record, @Param("example") PmsTutAssess1Example example);

    int updateByExample(@Param("record") PmsTutAssess1 record, @Param("example") PmsTutAssess1Example example);

    int updateByPrimaryKeySelective(PmsTutAssess1 record);

    int updateByPrimaryKeyWithBLOBs(PmsTutAssess1 record);

    int updateByPrimaryKey(PmsTutAssess1 record);
}