package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminAccount;

/**
 * Servlet implementation class AccessControllerAdminServlet
 */
//@WebServlet(urlPatterns = {"/admin_views", "/admin_views/employee_manage.jsp", "/admin_views/employee_table.jsp", "/admin_views/index.jsp", 
//							"/admin_views/product_manage.jsp", "/admin_views/users_table.jsp", "/admin_views/users_profile.jsp"})
public class AccessControllerAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessControllerAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String url = "/admin-login.jsp";
		AdminAccount admin_acc = (AdminAccount)session.getAttribute("admin_acc");
		
		if(admin_acc == null) {
			request.getRequestDispatcher(request.getContextPath() + url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
