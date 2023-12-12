package controllers.cart;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDB;
import database.InvoiceDB;
import database.UserDB;
import model.*;
/**
 * Servlet implementation class CompleteInvoice
 */
@WebServlet("/complete_invoice")
public class CompleteInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteInvoice() {
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
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		
		List<LineProduct> products = cart.getProducts();
		LocalDate localDate = LocalDate.now();
		Date currentDate = java.sql.Date.valueOf(localDate);
		
		Invoice invoice = new Invoice();
		invoice.setInvoiceDate(currentDate);
		invoice.setLineProducts(products);
		invoice.setTotalPrice(totalPrice);
		invoice.setUser(user);
		
		InvoiceDB.insert(invoice);
		
		products.clear();
		
		cart.setProducts(products);
		user.setCart(cart);
		CartDB.update(cart);
		UserDB.update(user);
		
		session.setAttribute("cart", cart);
		session.setAttribute("user", user);
		
		getServletContext().getRequestDispatcher("/thanks.jsp").forward(request, response);
	}

}
