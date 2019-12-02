package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.media.sound.RealTimeSequencerProvider;

import model.bean.Contacts;
import model.dao.ContactsDao;
import util.AuthUtil;

/**
 * Servlet implementation class AddminDeleteContactsController
 */

public class AdminDeleteContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteContactsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Contacts> alContacts = new ArrayList<>();
		ContactsDao contactsDao = new ContactsDao();
		AuthUtil authUtil = new AuthUtil();
		if(authUtil.checkLogin(request, response)) {
			int id = Integer.parseInt(request.getParameter("idContacts"));
			contactsDao.deleteContacts(id);
			request.setAttribute("alContacts", alContacts);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contacts");
			rd.forward(request, response);
			doPost(request,response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/auth/index.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
