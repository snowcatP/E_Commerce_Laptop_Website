package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.AdminDB;
import model.Admin;
import model.AdminAccount;

/**
 * Servlet implementation class AdminChangeProfileServlet
 */
@WebServlet("/admin_views/change_profile")
public class AdminChangeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeProfileServlet() {
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
		
		if(admin_acc != null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			Admin ad = admin_acc.getAdmin();
			ad.setFirstName(firstName);
			ad.setLastName(lastName);
			ad.setPhone(phone);
			ad.setAddress(address);
			
			AdminDB.update(ad);
			
			String message = "Update profile success!";
			request.setAttribute("message", message);
			session.setAttribute("admin_acc", admin_acc);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
