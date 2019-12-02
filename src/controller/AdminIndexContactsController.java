package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contacts;
import model.dao.ContactsDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminIndexContacsController
 */

public class AdminIndexContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexContactsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactsDao contactsDao = new ContactsDao();
		ArrayList<Contacts> alContacts = new ArrayList<>();
		AuthUtil authUtil = new AuthUtil();
		if(authUtil.checkLogin(request, response)) {
			alContacts = contactsDao.getContacts();
			request.setAttribute("alContacts", alContacts);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contacts/index.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
