package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Song;
import model.dao.CategoryDao;
import model.dao.SongDao;
import util.AuthUtil;

/**
 * Servlet implementation class AdminAddSongController
 */
@MultipartConfig
public class AdminAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "uploads";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddSongController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthUtil authUtil = new AuthUtil();
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> al = categoryDao.getItems();
		if (authUtil.checkLogin(request, response)) {
			request.setAttribute("al", al);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/song/add.jsp");
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
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		// proseces uploat file
		Part filePart = (Part) request.getPart("picture");
		System.out.println(filePart + "duong my lynh");
		String fileName = this.getName(filePart);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Song song = new Song(0, name, preview, detail, timestamp, fileName, 0, Integer.parseInt(category), null);
		SongDao songDao = new SongDao();
		if (!"".equals(fileName)) {
			String appPath = request.getServletContext().getRealPath("");
			// create path file contain file
			String dirPath = appPath + DIR_UPLOAD;
			// System.out.println(appPath);
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			// duong dan file
			String filePath = dirPath + File.separator + fileName;
			// nghi files
			filePart.write(filePath);
			System.out.println("Path file:" + filePath);

		}
		try {
			int result = songDao.insert(song);
			if (result >= 1) {
				System.out.println("Insert OK");
				RequestDispatcher rd = request.getRequestDispatcher("/admin/song");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
