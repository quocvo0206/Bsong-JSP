package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.Login;
import model.dao.CategoryDao;
import model.dao.UserDao;

/**
 * Servlet implementation class AdminIndexCatController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDao();
		String username = request.getParameter("email");
		String password     = request.getParameter("pass");
		ArrayList<Category> alCategory = new ArrayList<>();
		UserDao userDao = new UserDao();
		if(userDao.getUsersLogin(username, password)!=null) {
			Login login = new Login(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			alCategory = categoryDao.getItems();
			request.setAttribute("alCategory", alCategory);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/index/index.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
	}

}
