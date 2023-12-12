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
import database.ProductDB;
import database.UserDB;
import model.*;
/**
 * Servlet implementation class AddProductToCart
 */
@WebServlet("/add_product_to_cart")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCart() {
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
		List<LineProduct> products = cart.getProducts();
		Long productId = Long.parseLong(request.getParameter("productId"));
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		
		Product product = ProductDB.getProductById(productId);
		
		if(products.size() > 0) {
			boolean checkAdd = false;
			for(int i = 0; i < products.size(); i++) {
				LineProduct tempProduct = products.get(i);
				if(tempProduct.getProduct().getProductId().equals(productId)) {
					int tempQuantity = tempProduct.getQuantity() + productQuantity;
					products.get(i).setQuantity(tempQuantity);
					checkAdd = true;
					break;
				}
			}
			if (!checkAdd) {
				LineProduct lineProduct = new LineProduct();
				lineProduct.setProduct(product);
				lineProduct.setQuantity(productQuantity);
				
				products.add(lineProduct);					
			}
			
		}else {
			LineProduct lineProduct = new LineProduct();
			lineProduct.setProduct(product);
			lineProduct.setQuantity(productQuantity);
			
			products.add(lineProduct);			
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
