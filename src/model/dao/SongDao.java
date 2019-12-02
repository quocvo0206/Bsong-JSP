package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Song;
import util.DBConnectionUtil;

public class SongDao {
	private Connection con;
	private Statement st;

	private ResultSet rs;

	public ArrayList<Song> getItems() throws SQLException {
		ArrayList<Song> listItem = new ArrayList<>();
		String sql = "Select s.*,c.name as cname From categories AS c inner join songs AS s on c.id = s.cat_id order by s.id desc";
		con = DBConnectionUtil.getConnection();

		
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Song objtem = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"), new Category(rs.getString("cname")));
				listItem.add(objtem);

			}
	
		return listItem;
	}

	public int insert(Song song) throws SQLException {
		String sql = "INSERT INTO `songs`(`name`, `preview_text`, `detail_text`, `date_create`, `picture`, `counter`, `cat_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		con = DBConnectionUtil.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, song.getName());
		preparedStatement.setString(2, song.getDescription());
		preparedStatement.setString(3, song.getDetail());
		preparedStatement.setTimestamp(4, song.getDateCreate());
		preparedStatement.setString(5, song.getPicture());
		preparedStatement.setInt(6, song.getCounter());
		preparedStatement.setInt(7, song.getCatId());
		int result = preparedStatement.executeUpdate();
		return result;
	}

	public int getCountSong() throws SQLException {
		int result = 0;
		String sql = "Select COUNT(s.id) as total From categories AS c inner join songs AS s on c.id = s.cat_id";
		con = DBConnectionUtil.getConnection();
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			result = rs.getInt("total");
		}

		return result;
	}
	
	public ArrayList<Song> getPage(int offset) throws SQLException {

		ArrayList<Song> ls = new ArrayList<>();
		con = DBConnectionUtil.getConnection();
		String sql = "Select s.*,c.name as cname From categories AS c inner join songs AS s on c.id = s.cat_id order by s.id desc  LIMIT 7 OFFSET " + offset;
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			Song objtem = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
					rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
					rs.getInt("counter"), rs.getInt("cat_id"), new Category(rs.getString("cname")));
			ls.add(objtem);
		}
		return ls;
	}
	
}
