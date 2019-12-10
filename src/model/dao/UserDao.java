package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Login;
import model.bean.Users;
import util.DBConnectionUtil;

public class UserDao {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pmt;
	
	public ArrayList<Users> getUsers(){
		con = DBConnectionUtil.getConnection();
		String sql = "select username, fullname, id from users";
		ArrayList<Users> alUsers = new ArrayList<Users>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Users users = new Users(rs.getString("username"),rs.getString("fullname"), rs.getInt("id"));
				alUsers.add(users);			
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alUsers;
	}
	
	public Login getUsersLogin(String username,String password ){
		con = DBConnectionUtil.getConnection();
		String sql = "select *from users where username=? and password=?";
		Login login = null;
		try {
			pmt = con.prepareStatement(sql);
			pmt.setString(1,username);
			pmt.setString(2,password);
            rs = pmt.executeQuery();
			while(rs.next()) {
				login = new Login(rs.getString("username"), rs.getString("password"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	public void addUser(String usernam, String password, String fullname) {
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO USERS(username,password,fullname) VALUES(?,?,?)";
		try {
			pmt = con.prepareStatement(sql);
			pmt.setString(1, usernam);
			pmt.setString(2, password);
			pmt.setString(3, fullname);
			pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "delete from USERS where id = ?";
		try {
			pmt = con.prepareStatement(sql);
			pmt.setInt(1, id);
			pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUser(int id, String username, String password, String fullname) {
		con = DBConnectionUtil.getConnection();
		String sql = "update users set username=?, password=?,fullname=? where id = ?";
		try {
			pmt = con.prepareStatement(sql);
			pmt.setInt(4, id);
			pmt.setString(2,username);
			pmt.setString(3,password);
			pmt.setString(1,fullname);
			pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
