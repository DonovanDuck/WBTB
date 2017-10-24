package com.TB.TBox.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.TB.TBox.topic.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TB.TBox.note.bean.Note;
import com.TB.TBox.note.mapper.NoteMapper;
import com.TB.TBox.note.service.NoteService;
import com.TB.TBox.topic.bean.Topic;
import com.TB.base.mybatisUtils.SessionFactory;

@Service
public class TopicService {
	private SessionFactory sessionFactory;
	private Topic topic = new Topic();
	private Logger log = Logger.getLogger(NoteService.class);
	private TopicMapper topicMapper;
	/*
	 * set方法，依赖注入
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setNote(Topic topic) {
		this.topic = topic;
	}
	
	/**
	 * 添加讨论
	 * @param note
	 */
	public void addTopic(Topic topic){
		 SqlSession sqlSession = sessionFactory.getSession();
		 topicMapper = sqlSession.getMapper(TopicMapper.class);
		try {
			topicMapper.addTopic(topic);
			sqlSession.commit();
			log.debug("成功插入");
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 按题目查找讨论
	 * @param uid
	 * @return
	 */
	public List<Topic> schTopicbytitle(String title){
		List<Topic> topicList = new ArrayList<Topic>();
		SqlSession sqlSession = sessionFactory.getSession();
		topicMapper = sqlSession.getMapper(TopicMapper.class);
		try {
			topicList = topicMapper.findTopicbyT(title);
			for(Topic topic : topicList){
				log.debug(topic);
			}
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		return topicList;
	}
	public int finduid(int tid){
		int uid = 0;
		SqlSession sqlSession = sessionFactory.getSession();
		topicMapper = sqlSession.getMapper(TopicMapper.class);
		try {
			uid = topicMapper.finduid(tid);
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		return uid;
	}
}
