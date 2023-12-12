package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AdminAccountDB;
import database.AdminDB;
import model.*;

/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet("/admin_views/add_employee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
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
		
		String url = "/admin_views/employee_manage.jsp";
		
		// get current action
		String action = request.getParameter("action");
		
		if (action.equals("add_em")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			int salary = Integer.valueOf(request.getParameter("salary"));
			
			Admin admin = new Admin();
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			admin.setEmail(email);
			admin.setAddress(address);
			admin.setPhone(phone);
			admin.setSalary(salary);
			
			AdminDB.insert(admin);
			
			AdminAccount admin_acc = new AdminAccount();
			admin_acc.setUserName(email);
			admin_acc.setAdmin(admin);
			AdminAccountDB.insert(admin_acc);
			
			request.setAttribute("admin", admin);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
