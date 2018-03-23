package com.peony.peonydata.event.dao;

import java.util.List;

import com.peony.peonydata.event.model.Event;

public interface EventMapper {
    int deleteByPrimaryKey(Integer eventid);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer eventid);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
    
    /**
     * 条件查询
     * @param event
     * @return
     */
    List<Event> selectEvents(Event event);
}