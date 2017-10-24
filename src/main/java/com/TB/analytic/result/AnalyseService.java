package com.TB.analytic.result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.TB.analytic.ReturnValue;
import com.TB.analytic.library.Library;


@Service
public class AnalyseService {
	
	/**
	 * 添加分析结果
	 * @param value
	 * @param noteId
	 * @param userNumber
	 * @throws SQLException
	 */
	public void addResult(String str,int noteId,String userNumber) throws SQLException{
		ReturnValue value = com.TB.analytic.Analyse.value(str);
		com.TB.analytic.Sentiments_Test.addResult(value, noteId, userNumber);
	}
	/**
	 * 查询用户最近的纸条分析
	 * @param userNumber
	 * @return
	 */
	public static List<Library> selectValue(String userNumber){
		List<Library>  lib = new ArrayList<>();
		lib= com.TB.analytic.Sentiments_Test.selectResult(userNumber);
		return lib;
	}
	/**
	 *查询随机的一条饮食
	 * @return
	 */
	public static String dietselect(){
		return com.TB.analytic.Sentiments_Test.dietselect();
	}
	/**
	 * 情绪小贴士
	 * @return
	 */
	public static String pointselect(){
		return com.TB.analytic.Sentiments_Test.pointselect();
	}
	
	@Test
	public void moment() throws SQLException{
		String str = "唉～打了十把牌，让我小妹妹全输了，然后她就哭了，哄都哄不好。明天就要走了，唉～心烦……";
		int noteId = 57 ;
		String userNumber = "9429390675";
		addResult(str, noteId, userNumber);
	}
}
