package controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserAccountDB;
import model.*;
import util.PasswordUtil;
import database.*;
;/**
 * Servlet implementation class ChangeUserProfile
 */
@WebServlet("/change_user_profile")
public class ChangeUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserProfile() {
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
		String action = request.getParameter("action");
		
		String url = "/user_detail.jsp";
		
		if(action.equals("change_password")) {
			String email = request.getParameter("email");
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			
			if(UserAccountDB.checkLogin(email, currentPassword) != null) {
				String hashedPassword = PasswordUtil.hashPassword(newPassword);
				
				UserAccount user_acc = UserAccountDB.getUserAccount(email);
				
				user_acc.setPassWord(hashedPassword);
				UserAccountDB.update(user_acc);
				
				String message = "Đổi mật khẩu thành công!";
				
				url = "/user_changepassword.jsp";
				request.setAttribute("message", message);
			}else {
				String message = "Đổi mật khẩu không thành công!";
				
				url = "/user_changepassword.jsp";
				request.setAttribute("message", message);
			}
			
			
		} else if(action.equals("update_profile")) {
			String emailString = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
					
			User user = UserDB.getUser(emailString);
			user.setAddress(address);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhone(phone);
			
			UserDB.update(user);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			String message = "Update profile success!";
			url = "/user_detail.jsp";
			request.setAttribute("message", message);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
