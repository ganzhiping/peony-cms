package com.peony.peonydata.agent.dao;

import java.util.List;

import com.peony.peonydata.agent.model.Agent;

public interface AgentMapper {
    int deleteByPrimaryKey(Integer agentId);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(Integer agentId);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);
    /**
     * 查询列表分页
     */
    List<Agent> selectByPage(Agent record);
    
    /**
     * 通过市场人员查询代理商
     * @param userId
     * @return
     */
    List<Agent> selectByUserId(Integer userId);
    
    
    List<Agent> selectAgents(Agent agent);
    
    List<Agent> selectMobileAgents(Agent agent);
}