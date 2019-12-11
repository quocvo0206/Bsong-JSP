package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDao;

/**
 * Servlet implementation class AdminUpdateCatController
 */

public class AdminUpdateCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUpdateCatController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean check = request.getParameter("id") != null;
		if (check) {
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryDao categoryDao = new CategoryDao();
			Category category = categoryDao.getCategory(id);
			request.setAttribute("category", category);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/category/update.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean check = request.getParameter("id") != null && request.getParameter("name") != null;
		if (check) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			CategoryDao categoryDao = new CategoryDao();
			categoryDao.updateCat(name, id);
			response.sendRedirect(request.getContextPath()+"/admin/cat");
		} else {
			// sendRedirect to page error
		}
	}
}
