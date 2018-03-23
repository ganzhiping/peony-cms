package com.peony.peonydata.agent.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.agent.dao.AgentMapper;
import com.peony.peonydata.agent.model.Agent;

/**
 * 代理商管理
 *
 * @author zhaoyunzhao
 * @version 1
 */
@Service
public class AgentServiceImpl implements AgentService {

    @Resource
    private AgentMapper agentMapper;

    @Override
    public Pagination<Agent> selectByPage(Agent record) {
        List<Agent> list = this.agentMapper.selectByPage(record);
        return new Pagination<Agent>(list, record.getPageParameter());
    }

    @Override
    public Agent selectByAgentId(Integer agentId) {

        return this.agentMapper.selectByPrimaryKey(agentId);
    }

    @Override
    public int updateAgent(Agent agent) {

        return this.agentMapper.updateByPrimaryKeySelective(agent);
    }

    @Override
    public int delAgent(Integer agentId) {

        return this.agentMapper.deleteByPrimaryKey(agentId);
    }

    @Override
    public int insertSelective(Agent agent) {
        return this.agentMapper.insertSelective(agent);
    }

    @Override
    public List<Agent> selectByUserId(Integer userId) {
        return this.agentMapper.selectByUserId(userId);
    }

    @Override
    public List<Agent> selectAgents(Agent agent) {
        return this.agentMapper.selectAgents(agent);
    }

    public AgentMapper getAgentMapper() {
        return this.agentMapper;
    }

    public void setAgentMapper(AgentMapper agentMapper) {
        this.agentMapper = agentMapper;
    }

    @Override
    public List<Agent> selectMobileAgents(Agent agent) {
        return this.agentMapper.selectMobileAgents(agent);
    }

    @Override
    public Pagination<Agent> selectMobileByPage(Agent record) {
        List<Agent> list = this.agentMapper.selectMobileAgents(record);
        return new Pagination<Agent>(list, record.getPageParameter());
    }

}
