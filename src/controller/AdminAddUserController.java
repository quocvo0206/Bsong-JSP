package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Users;
import model.dao.UserDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminAddUserController
 */

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getServletContext().getRealPath(""));
		AuthUtil authUtil = new AuthUtil();
		if (authUtil.checkLogin(request, response)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/add.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AuthUtil authUtil = new AuthUtil();
		UserDao userDao = new UserDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		if (authUtil.checkLogin(request, response)) {
			userDao.addUser(username, password, fullname);
			ArrayList<Users> alUsers = new ArrayList<>();
			alUsers = userDao.getUsers();
			request.setAttribute("alUsers", alUsers);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/index.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
	}
}
