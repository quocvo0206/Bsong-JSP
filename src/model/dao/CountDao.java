package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnectionUtil;

public class CountDao {
	private Connection con;
	private Statement stt;
	private ResultSet rs;
	private PreparedStatement pr;
	
	public int countCategories() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM categories";
		con = DBConnectionUtil.getConnection();
		try {
			stt = con.createStatement();
			rs = stt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int countSongs() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM songs";
		con = DBConnectionUtil.getConnection();
		try {
			stt = con.createStatement();
			rs = stt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int countUsers() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM users";
		con = DBConnectionUtil.getConnection();
		try {
			stt = con.createStatement();
			rs = stt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
