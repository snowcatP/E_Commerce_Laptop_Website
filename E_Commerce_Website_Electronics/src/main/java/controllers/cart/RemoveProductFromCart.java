package controllers.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDB;
import database.UserDB;
import model.*;
/**
 * Servlet implementation class RemoveProductFromCart
 */
@WebServlet("/remove_product")
public class RemoveProductFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductFromCart() {
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
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		Long productId = Long.parseLong(request.getParameter("productId"));
		
		List<LineProduct> products = cart.getProducts();
		
		if(products.size() > 0) {
			for(int i = 0; i < products.size(); i++) {
				Product tempProduct = products.get(i).getProduct();
				if(tempProduct.getProductId().equals(productId)) {
					products.remove(i);
					break;
				}
			}
		}
		cart.setProducts(products);
		user.setCart(cart);
		
		CartDB.update(cart);
		UserDB.update(user);
		
		session.setAttribute("user", user);
		session.setAttribute("cart", cart);
		
		getServletContext().getRequestDispatcher("/user_detail?action=cart").forward(request, response);
		
	}

}
