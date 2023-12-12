package controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDB;
import database.UserAccountDB;
import model.Cart;
import model.User;
import util.PasswordUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_account")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String url = "/login.jsp";
		
		// get current action
		String action = request.getParameter("action");
		
		if(action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String remember = request.getParameter("remember");
			
			
			if(UserAccountDB.checkLogin(username, password) != null) {
				HttpSession session = request.getSession();
				String hashedPassword = "";
				hashedPassword = PasswordUtil.hashPassword(password);
				
				User user = UserAccountDB.getUser(username, hashedPassword);
				
				// Synchronized with CART
				Cart cart = CartDB.getCart(user);
				final Object lock = request.getSession().getId().intern();
				synchronized(lock) {
					session.setAttribute("cart", cart);
				}
				
				Cookie cun = new Cookie("userEmailCookie", username);
				Cookie cps = new Cookie("userPwCookie", password);
				if (remember != null) {
					// Set cookie for user account
					cun.setMaxAge(60 * 60 * 24);
					cps.setMaxAge(60 * 60 * 24);
					cun.setPath("/");
					cps.setPath("/");
				}else {
					cun.setMaxAge(0);
					cps.setMaxAge(0);
				}
				session.setAttribute("user", user);
				response.addCookie(cun);
				response.addCookie(cps);
				url = "/home";
			}else {
				request.setAttribute("message", "Sai tài khoản hoặc mật khẩu, vui lòng nhập lại!");
				
			}
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}
}
