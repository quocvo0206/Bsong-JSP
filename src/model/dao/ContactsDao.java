package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Contacts;
import util.DBConnectionUtil;

public class ContactsDao {
	private Connection conm;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pmt;
	
	public ArrayList<Contacts> getContacts(){
		String sql = "select id,name,email,website,message from contacts";
		ArrayList<Contacts> alContacts = new ArrayList<>();
		conm = DBConnectionUtil.getConnection();
		try {
			st = conm.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Contacts contacts = new Contacts(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("website"), rs.getString("message"));
				alContacts.add(contacts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alContacts;
		
	}
	
	public void deleteContacts(int id) {
		conm = DBConnectionUtil.getConnection();
		String sql = "delete from contacts where id = ?";
		try {
			pmt = conm.prepareStatement(sql);
			pmt.setInt(1, id);
			pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
