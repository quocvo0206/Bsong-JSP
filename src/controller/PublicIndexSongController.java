package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.Song;
import model.dao.CategoryDao;
import model.dao.SongDao;

/**
 * Servlet implementation class PublicIndexSongController
 */
public class PublicIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublicIndexSongController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int offset;
		int numberPage;
		String pageS;
		
		HttpSession session = request.getSession();
		SongDao songDao = new SongDao();
		CategoryDao categoryDao = new CategoryDao();
		
		ArrayList<Category> alCategory = categoryDao.getItems();
		session.setAttribute("alCategory", alCategory);
		pageS = request.getParameter("page") != null ? request.getParameter("page") : "1";
		int pageCurrent = Integer.parseInt(pageS);
		offset = (pageCurrent - 1) * 7;
		try {
			int sumLs = songDao.getCountSong();
			numberPage = (int) Math.ceil(((sumLs * 1.0) / 7));
			ArrayList<Song> alSong = songDao.getPage(offset);
			request.setAttribute("numberPage", numberPage);
			request.setAttribute("alSong", alSong);
			request.setAttribute("pageCurrent", pageCurrent);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
