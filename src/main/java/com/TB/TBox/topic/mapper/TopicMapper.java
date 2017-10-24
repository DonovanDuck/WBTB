package com.TB.TBox.topic.mapper;

import java.util.List;

import com.TB.TBox.topic.bean.Topic;

public interface TopicMapper {
	/**
	 * 添加主题讨论
	 */
	public void addTopic(Topic topic);
	/**
	 * 按题目查找讨论
	 */
	public List<Topic> findTopicbyT(String title);
	
	public int finduid(int tid);
}
