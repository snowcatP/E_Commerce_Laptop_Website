package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.oxm.schema.XMLSchemaURLReference;

import database.AdminAccountDB;
import database.AdminDB;
import model.*;
/**
 * Servlet implementation class ModifyEmployeeServlet
 */
@WebServlet("/admin_views/modify_employee")
public class ModifyEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String url = "/admin_views/modify_employee.jsp";
		
		if(action.equals("modify")) {
			Admin employee = AdminDB.getEmployee(email);
				
			request.setAttribute("employee", employee);
		}
		else if(action.equals("delete")) {
			Admin employee = AdminDB.getEmployee(email);
			AdminAccount admin_acc = AdminAccountDB.getAdminAccount(email);
			
			AdminAccountDB.delete(admin_acc);
			AdminDB.delete(employee);
			
			url = "/admin_views/get_employees_data";
			request.setAttribute("message", "Xoá nhân viên thành công");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String url = "/admin_views/get_employees_data";
		
		if(action.equals("modify")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			int salary = Integer.valueOf(request.getParameter("salary"));
			
			Admin employee = AdminDB.getEmployee(email);
			
			employee.setAddress(address);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setPhone(phone);
			employee.setSalary(salary);
			
			AdminDB.update(employee);
			request.setAttribute("message", "Đổi thông tin nhân viên thành công!");
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
