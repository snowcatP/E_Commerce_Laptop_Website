package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.AdminAccountDB;
import model.*;
/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(urlPatterns = {"/admin_views/admin_login"})
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String url = "/admin-login.jsp";
		String action = request.getParameter("action");
		
		if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			AdminAccount admin_acc = AdminAccountDB.checkLogin(username, password); 
			if (admin_acc != null) {
				HttpSession session = request.getSession();
				session.setAttribute("admin_acc", admin_acc);
				url = "/admin_views/index.jsp";
			}
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
}
