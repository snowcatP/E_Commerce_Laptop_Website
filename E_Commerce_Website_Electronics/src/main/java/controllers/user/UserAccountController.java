package controllers.user;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import database.*;
import model.*;
import util.PasswordUtil;

//WebServlet(urlPatterns = {"/login_account", "/signup_account", "/logout"})
public class UserAccountController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String url = "/index.jsp";
		
		String action = req.getParameter("action");
		if(action == null) {
			
		}
		if(action.equals("logout")) {
			session.removeAttribute("user");
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = "/login.jsp";
		String message = "";
		
		// get current action
		String action = req.getParameter("action");

		if (action.equals("add")){
			String firstname = req.getParameter("firstnameCreate");
	        String lastname = req.getParameter("lastnameCreate");
	        String password = req.getParameter("passwordCreate");
	        String email = req.getParameter("emailCreate");
	        String address = req.getParameter("addressCreate");
	        String phone = req.getParameter("phoneCreate");
	        

	        if(UserAccountDB.emailExists(email)) {
	        	req.setAttribute("message", "Email này đã được sử dụng, hãy dùng email khác!");
	        	req.getRequestDispatcher(url).forward(req, res);
	        }
	        else {
		        Cart newCart = new Cart();
		        newCart.setProducts(null);
		        CartDB.insert(newCart);
		        
		        User newUser = new User();
		        newUser.setFirstName(firstname);
		        newUser.setLastName(lastname);
		        newUser.setAddress(address);
		        newUser.setPhone(phone);
		        newUser.setEmail(email);
		        newUser.setCart(newCart);
		        UserDB.insert(newUser);
		        
		        UserAccount newUserAcc = new UserAccount();
		        newUserAcc.setUser(newUser);
		        newUserAcc.setUserName(email);
		      
		        String hashedPassword = PasswordUtil.hashPassword(password);
				newUserAcc.setPassWord(hashedPassword);
		        
		        UserAccountDB.insert(newUserAcc);

		        req.setAttribute("user", newUser);
	        }
		}
		else if(action.equals("login")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String remember = req.getParameter("remember");
			
			
			if(UserAccountDB.checkLogin(username, password) != null) {
				HttpSession session = req.getSession();
				String hashedPassword = "";
				hashedPassword = PasswordUtil.hashPassword(password);
				
				User user = UserAccountDB.getUser(username, hashedPassword);
				
				// Synchronized with CART
				Cart cart = CartDB.getCart(user);
				final Object lock = req.getSession().getId().intern();
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
					session.setAttribute("user", user);
				}else {
					cun.setMaxAge(0);
					cps.setMaxAge(0);
				}
				res.addCookie(cun);
				res.addCookie(cps);
				url = "/index.jsp";
				
			} else {
				req.setAttribute("loginMessage", "Sai tài khoản hoặc mật khẩu, vui lòng nhập lại!");
			}
		} 
		
        getServletContext().getRequestDispatcher(url).forward(req, res);
        
	}

}
