package controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CartDB;
import database.UserAccountDB;
import database.UserDB;
import model.Cart;
import model.User;
import model.UserAccount;
import util.PasswordUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/signup_account")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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

		if (action.equals("add")){
			String firstname = request.getParameter("firstnameCreate");
	        String lastname = request.getParameter("lastnameCreate");
	        String password = request.getParameter("passwordCreate");
	        String email = request.getParameter("emailCreate");
	        String address = request.getParameter("addressCreate");
	        String phone = request.getParameter("phoneCreate");
	        

	        if(UserAccountDB.emailExists(email)) {
	        	request.setAttribute("messageRegister", "Email này đã được sử dụng, hãy dùng email khác!");
	        	request.getRequestDispatcher(url).forward(request, response);
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

		        request.setAttribute("user", newUser);
	        }
	        
	        getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}

}
