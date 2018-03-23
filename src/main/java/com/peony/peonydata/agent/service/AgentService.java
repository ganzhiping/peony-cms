package com.peony.peonydata.agent.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.agent.model.Agent;

public interface AgentService {
	/**
	 * 查询代理商分页列表
	 * @param record
	 * @return
	 */
	Pagination<Agent> selectByPage(Agent record);
	
	
	
	List<Agent> selectAgents(Agent agent);
	
	/**
     * 通过市场人员查询代理商
     * @param userId
     * @return
     */
	List<Agent> selectByUserId(Integer userId);
	/**
	 * 根据主键查询
	 * @param agentId
	 * @return
	 */
	Agent selectByAgentId(Integer agentId);
	/**
	 * 更新代理商信息
	 * @param agent
	 * @return
	 */
	int updateAgent(Agent agent);
	/**
	 * 删除代理商（id）
	 */
	int delAgent(Integer agentId);
	/**
	 * 添加代理商
	 * @param agent
	 * @return
	 */
	int insertSelective(Agent record);
	/**
	 * 查询代理商列表（免费移动端）
	 * @param agent
	 * @return
	 */
	List<Agent> selectMobileAgents(Agent agent);
	/**
	 * 查询代理商分页列表（免费移动端）
	 * @param record
	 * @return
	 */
	Pagination<Agent> selectMobileByPage(Agent record);
}
