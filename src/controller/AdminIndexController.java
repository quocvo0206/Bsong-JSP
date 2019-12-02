package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CountDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminIndexController
 */
public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountDao countDao = new CountDao();
		int countCategories = countDao.countCategories();
		int countSongs = countDao.countSongs();
		int countUsers = countDao.countUsers();
		AuthUtil authUtil = new AuthUtil();
		request.setAttribute("countCategories", countCategories);
		request.setAttribute("countSongs", countSongs);
		request.setAttribute("countUsers", countUsers);
		if(authUtil.checkLogin(request, response)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/index/index.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
