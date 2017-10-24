package com.TB.analytic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.TB.analytic.library.Library;


public class Sentiments_Test {
	/**
	 * 情感词
	 * 
	 * @param word
	 * @param i
	 * @return
	 */
	public static Modle selectWord(String word, int i) {
		Modle modle = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = SqlTest.getConn();
				String sql = "select * from mood where adverdword=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String words = rs.getString("adverdword");
					int polarity = rs.getInt("adverdTendenc");
					// System.out.println(rs.getInt("intensity"));
					int intensity = rs.getInt("adverdIntensity");
					int address = i;
					modle = new Modle(words, address, polarity, intensity);
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modle;
	}

	/**
	 * 否定词
	 * 
	 * @param word
	 * @param i
	 * @return
	 */
	public static Modle selectno(String word, int i) {
		Modle modle = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = SqlTest.getConn();
				String sql = "select * from no where noword=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String words = rs.getString("noword");
					int polarity = rs.getInt("noTendenc");
					// System.out.println(rs.getInt("intensity"));
					int intensity = rs.getInt("noIntensity");
					int address = i;

					modle = new Modle(words, address, polarity, intensity);
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modle;
	}

	/**
	 * 程度副词
	 * 
	 * @param word
	 * @param i
	 * @return
	 */
	public static Modle selectadverd(String word, int i) {
		Modle modle = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = SqlTest.getConn();
				String sql = "select * from adverd where words=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String words = rs.getString("words");
					int polarity = rs.getInt("emotionalTendenc");
					// System.out.println(rs.getInt("intensity"));
					double intensity = rs.getDouble("emotionalIntensity");
					int address = i;
					modle = new Modle(words, address, polarity, intensity);
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modle;
	}

	/**
	 * 语气词
	 * 
	 * @param word
	 * @param i
	 * @return
	 */
	public static Modle selectparticle(String word, int i) {
		Modle modle = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = SqlTest.getConn();
				String sql = "select * from particle where particleword=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String words = rs.getString("particleword");
					int polarity = rs.getInt("particleTendenc");
					// System.out.println(rs.getInt("intensity"));
					int intensity = rs.getInt("particleIntensity");
					int address = i;
					modle = new Modle(words, address, polarity, intensity);
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modle;
	}

	/**
	 * 查询兴趣表，用来提取用户兴趣
	 * 
	 * @param word
	 * @return
	 */
	public static String selecthobby(String word) {
		String words = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = SqlTest.getConn();
				String sql = "select * from interst where hobby=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, word);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					words = rs.getString("hobby");
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}

	/**
	 * 添加分析结果
	 * 
	 * @param value
	 * @param noteId
	 * @param userNumber
	 * @throws SQLException
	 */
	public static void addResult(ReturnValue value, int noteId, String userNumber) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DateFormat foror = new SimpleDateFormat("MM.dd");
		Date date = new Date();
		String time = foror.format(date);
		try {
			conn = SqlTest.getConn();
			String sql = "insert into mood_result  values(null,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noteId);
			pstmt.setString(2, userNumber);
			pstmt.setDouble(3, value.getValue());
			pstmt.setString(4, value.getHobby());
			pstmt.setString(5, value.getDocument());
			pstmt.setString(6, time);
			int num = pstmt.executeUpdate();
			System.out.println("成功插入" + num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		System.out.println("添加成功!");
	}

	/**
	 * 查询分析
	 * 
	 * @param userNumber
	 * @return
	 */
	public static List<Library> selectResult(String userNumber) {
		List<Library> values = new ArrayList<Library>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 获取链接
				conn = SqlTest.getConn();
				// 预处理
				String sql = "select * from mood_result where userNumber=? order by vid desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userNumber);
				rs = pstmt.executeQuery();
				// 处理结果集
				while (rs.next()) {
					int vid = rs.getInt("vid");
					int noteId = rs.getInt("noteId");
					double value = rs.getDouble("value");
					String time = rs.getString("time");
					Library lib = new Library();
					lib.setVid(vid);lib.setNoteId(noteId);lib.setValue(value);lib.setTime(time);
					values.add(lib);
				}
			} finally {
				SqlTest.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
	/**
	 * 查询饮食
	 * @return
	 */
		public static String dietselect() {
			String diet = null;
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					// 获取链接
					conn = SqlTest.getConn();
					// 预处理
					String sql = "select  *  from  mood_diet order by rand() limit 1;";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					// 处理结果集
					while (rs.next()) {
					diet = rs.getString("mood_diet");
						
					}
				} finally {
					SqlTest.close(rs, pstmt, conn);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return diet;
		}
		
		/**
		 * 情绪小贴士
		 * @return
		 */
		public static String pointselect() {
			String diet = null;
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					// 获取链接
					conn = SqlTest.getConn();
					// 预处理
					String sql = "select  *  from  mood_point order by rand() limit 1;";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					// 处理结果集
					while (rs.next()) {
					diet = rs.getString("po_content");
						
					}
				} finally {
					SqlTest.close(rs, pstmt, conn);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return diet;
		}
	public static void main(String[] args) {
		List<Library> lib = new ArrayList<>();
		lib = selectResult("9429390675");
		System.out.println(lib.size() + "-------------------");
		for(Library l:lib){
			System.out.println(l.getValue());
		}
		// Sentiments sentiment = test_2.Sentiments_Test.selectWord("脏乱", 1);
		// System.out.println(sentiment.toString());
	}
}
