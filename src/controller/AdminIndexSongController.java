package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Song;
import model.dao.SongDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminIndexCatController
 */
@WebServlet("/AdminIndexCatController")
public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexSongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SongDao songDao = new SongDao();
		int offset;
		int numberPage;
		String pageS;
		ArrayList<Song> alSong = new ArrayList<>();
		AuthUtil authUtil = new AuthUtil();
		pageS = request.getParameter("page") != null ? request.getParameter("page") : "1";
		int page = Integer.parseInt(pageS);
		offset = (page-1)*7;
		if(authUtil.checkLogin(request, response)) {
			try {
				int sumLs = songDao.getCountSong();
				numberPage = (int) Math.ceil(((sumLs*1.0)/7));
				alSong = songDao.getPage(offset);
				request.setAttribute("numberPage", numberPage);
				request.setAttribute("alSong", alSong);
				request.setAttribute("page", page);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/song/index.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
