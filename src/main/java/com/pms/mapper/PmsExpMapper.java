package com.pms.mapper;

import com.pms.pojo.PmsExp;
import com.pms.pojo.PmsExpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsExpMapper {
    int countByExample(PmsExpExample example);

    int deleteByExample(PmsExpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsExp record);

    int insertSelective(PmsExp record);

    List<PmsExp> selectByExampleWithBLOBs(PmsExpExample example);

    List<PmsExp> selectByExample(PmsExpExample example);

    PmsExp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsExp record, @Param("example") PmsExpExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsExp record, @Param("example") PmsExpExample example);

    int updateByExample(@Param("record") PmsExp record, @Param("example") PmsExpExample example);

    int updateByPrimaryKeySelective(PmsExp record);

    int updateByPrimaryKeyWithBLOBs(PmsExp record);

    int updateByPrimaryKey(PmsExp record);
}