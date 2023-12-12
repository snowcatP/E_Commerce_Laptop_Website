package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.AdminAccountDB;
import database.AdminDB;
import model.Admin;
import model.AdminAccount;

/**
 * Servlet implementation class AdminChangePasswordServlet
 */
@WebServlet("/admin_views/change_password")
public class AdminChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String url = "/admin_views/users_profile.jsp";
		
		AdminAccount admin_acc = (AdminAccount) session.getAttribute("admin_acc");
		String message = "";
		
		if(admin_acc != null) {
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			
			if(AdminAccountDB.checkPassword(admin_acc, currentPassword) != null) {
				admin_acc.setPassWord(newPassword);
				
				AdminAccountDB.update(admin_acc);
				
				message = "Change password success!";
				session.setAttribute("admin_acc", admin_acc);
				request.setAttribute("message", message);
			}
		}
		else {
			message = "Wrong password, please retype your password!";
			request.setAttribute("message", message);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
