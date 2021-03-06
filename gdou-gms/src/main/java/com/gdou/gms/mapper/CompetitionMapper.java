package com.gdou.gms.mapper;

import com.gdou.gms.pojo.Competition;
import com.gdou.gms.pojo.CompetitionExample;

import java.util.List;

import com.gdou.gms.pojo.Condition;
import org.apache.ibatis.annotations.Param;

public interface CompetitionMapper
{
    long countByExample(CompetitionExample example);

    int deleteByExample(CompetitionExample example);

    int deleteByPrimaryKey(String competid);

    int insert(Competition record);

    int insertSelective(Competition record);

    List<Competition> selectByExample(CompetitionExample example);

    Competition selectByPrimaryKey(String competid);

    List<Competition> selectAllCompetitions();

    Competition selectCompetitionById(String competid);

    List<Competition> selectCompetitionsByCondition(@Param("condition") Condition condition);

    List<Competition> selectCompetitionsByUserId(String userId);

    int updateByExampleSelective(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByExample(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}