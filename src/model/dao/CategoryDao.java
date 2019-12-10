package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.bean.Category;
import util.DBConnectionUtil;

public class CategoryDao {
	private Connection con;
	private Statement st;
	private PreparedStatement pt;
	private ResultSet rs;
	
	public ArrayList<Category> getItems(){
		ArrayList<Category> listItem = new ArrayList<>();
		String sql ="Select *from categories order by id DESC";
		con = DBConnectionUtil.getConnection();
		
		try {
			st = con.createStatement();
			rs=st.executeQuery(sql);	
			while(rs.next()) {
				Category objtem = new Category(rs.getInt("id"), rs.getString("name"));
				listItem.add(objtem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listItem;
	}
	
	public Category getCategory(int id){
		String sql ="Select *from categories WHERE id = "+ id;
		con = DBConnectionUtil.getConnection();
		Category objtem;
		try {
			st = con.createStatement();
			rs=st.executeQuery(sql);	
			while(rs.next()) {
				objtem = new Category(rs.getInt("id"), rs.getString("name"));
				return objtem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addCat(String name) {
		con = DBConnectionUtil.getConnection();
		String sql = "insert into categories(name) values(?)";
		try {
			pt = con.prepareStatement(sql);
			pt.setString(1, name);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCat(int idCat) {
		con = DBConnectionUtil.getConnection();
		String sql = "Delete from categories where id = ?";
		try {
			pt = con.prepareStatement(sql);
			pt.setInt(1, idCat);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get categories
	public void getCat(int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "select *from categories where id = ?";
		try {
			pt = con.prepareStatement(sql);
			pt.setInt(1, id);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// update categories
	public void updateCat(String name, int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categories SET name = ? WHERE id = ?";
		try {
			pt = con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setInt(2, id);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
