package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminAddCatController
 */

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddCatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AuthUtil authUtil = new AuthUtil();
		if (authUtil.checkLogin(request, response)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/category/add.jsp");
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
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> alCategory = new ArrayList<>();
		String name = request.getParameter("name");
		if (authUtil.checkLogin(request, response)) {
			categoryDao.addCat(name);
			alCategory = categoryDao.getItems();
			request.setAttribute("alCategory", alCategory);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/category/index.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}

	}
}
