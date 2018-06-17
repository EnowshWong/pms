package com.pms.mapper;

import com.pms.pojo.PmsInvited;
import com.pms.pojo.PmsInvitedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsInvitedMapper {
    int countByExample(PmsInvitedExample example);

    int deleteByExample(PmsInvitedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsInvited record);

    int insertSelective(PmsInvited record);

    List<PmsInvited> selectByExample(PmsInvitedExample example);

    PmsInvited selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsInvited record, @Param("example") PmsInvitedExample example);

    int updateByExample(@Param("record") PmsInvited record, @Param("example") PmsInvitedExample example);

    int updateByPrimaryKeySelective(PmsInvited record);

    int updateByPrimaryKey(PmsInvited record);
}