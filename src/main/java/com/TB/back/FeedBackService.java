package com.TB.back;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.TB.base.mybatisUtils.SessionFactory;

@Service
public class FeedBackService implements FeedBackMapper {
	SessionFactory sessionFactory = new SessionFactory();

	@Override
	public void addFeedBack(FeedBack back) {
		SqlSession session = sessionFactory.getSession();
		try {
			FeedBackMapper feedbackOperation = session.getMapper(FeedBackMapper.class);
			feedbackOperation.addFeedBack(back);
			session.commit();
		} finally {
			session.close();
		}
		System.out.println("插入成功！");
	}

	
	@org.junit.Test
	public void Test(){
		FeedBack back = new FeedBack();
		int uid = 33;
		String content = "界面有点丑！";
		String time  = "2017-10-7 09:48";
		back.setUid(uid);back.setContent(content);back.setFe_time(time);
		addFeedBack(back);
		}
}
