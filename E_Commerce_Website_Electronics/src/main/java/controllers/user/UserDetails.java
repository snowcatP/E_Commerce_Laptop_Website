package controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.InvoiceDB;
import model.*
;/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/user_detail")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
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
		String url="/user_detail.jsp";
		
		String action = request.getParameter("action");
		
		if(action.equals("user_detail")) {
			url="/user_detail.jsp";
		} else if(action.equals("change_password")) {
			url="/user_changepassword.jsp";
		} else if(action.equals("cart")) {
			url="/cart.jsp";
		} else if(action.equals("order_status")) {
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			List<Invoice> invoices = InvoiceDB.getUserInvoices(user);
			request.setAttribute("invoices", invoices);
			
			url="/order_status.jsp";
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
