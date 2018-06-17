package com.pms.mapper;

import com.pms.pojo.PmsJoin;
import com.pms.pojo.PmsJoinExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsJoinMapper {
    int countByExample(PmsJoinExample example);

    int deleteByExample(PmsJoinExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsJoin record);

    int insertSelective(PmsJoin record);

    List<PmsJoin> selectByExample(PmsJoinExample example);

    PmsJoin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsJoin record, @Param("example") PmsJoinExample example);

    int updateByExample(@Param("record") PmsJoin record, @Param("example") PmsJoinExample example);

    int updateByPrimaryKeySelective(PmsJoin record);

    int updateByPrimaryKey(PmsJoin record);
}