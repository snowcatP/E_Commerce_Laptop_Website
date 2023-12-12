package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AdminDB;
import database.UserAccountDB;
import database.UserDB;
import model.*;
/**
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/admin_views/modify_user")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserServlet() {
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
		
		String url = "/admin_views/modify_user.jsp";
		
		User user = UserDB.getUser(email);
		
		if(action.equals("modify")) {
			
			request.setAttribute("user", user);
		} 
		else if(action.equals("delete")) {
			UserAccount user_acc = UserAccountDB.getUserAccount(email);
			UserAccountDB.delete(user_acc);
			UserDB.delete(user);
			
			request.setAttribute("message", "Xoá khách hàng thành công!");
			url = "/admin_views/get_users_data";
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
		String url = "/admin_views/get_users_data";
		
		if(action.equals("modify")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			User user = UserDB.getUser(email);
			
			user.setAddress(address);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhone(phone);
			
			UserDB.update(user);
			request.setAttribute("message", "Đổi thông tin khách hàng thành công!");
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
