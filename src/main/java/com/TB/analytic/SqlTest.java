package com.TB.analytic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlTest {

	/**
	 * jdbc参数
	 * url：数据库地址
	 * driver：驱动类完整类名
	 * user：数据库用户名
	 * password：数据库密码
	 * jdbc步骤
	 * 1.驱动类加载
	 * Class.forName(driver);
	 * 2.获取连接
	 * Connection conn = 
	 * DriverManager.getConnection(url,user,password);
	 * 3.创建pstmt（预处理sql）对象
	 * pstmt = conn.prepareStatement(sql);
	 * 4.执行查询或更新操作
	 * ResultSet rs = pstmt.executeQuery();//查询
	 * int num = pstmt.executeUpdate//增删改
	 * 5.如果是执行查询操作，处理结果集
	 * while（rs.next）{
	 *
	 * }
	 * 6.释放资源
	 * 
	 */
	private static String driver ;
	private static String url;
	private static String user;
	private static String password;
	static{
		driver = "com.mysql.jdbc.Driver";
		url="jdbc:mysql://127.0.0.1:3306/mood?useUnicode=true&characterEncoding=UTF8";
		user="root";
		password="wzdasnl6";
		//wzdasnl6
	}
	public static Connection getConn() throws Exception{
		//1.加载驱动
		Class.forName(driver);
		//2.获取链接
		Connection conn =DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**
	 * 释放资源
	 */
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn)
	throws Exception{
		//释放资源
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}if(conn!=null){
			conn.close();
		}
	}
}
