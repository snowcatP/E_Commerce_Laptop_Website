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
import model.Cart;
import model.LineProduct;
import model.User;

/**
 * Servlet implementation class UpdateProductQuantity
 */
@WebServlet("/update_product_quantity")
public class UpdateProductQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductQuantity() {
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
		int productQuantity = Integer.parseInt(request.getParameter("quantity"));
		
		if(products.size() > 0) {
			for(int i = 0; i < products.size(); i++) {
				LineProduct tempProduct = products.get(i);
				if(tempProduct.getProduct().getProductId().equals(productId)) {
					if(productQuantity == 0) {
						products.remove(i);
						break;
					} else if(productQuantity < 0) {
						products.get(i).setQuantity(1);
						break;
					} else {
						products.get(i).setQuantity(productQuantity);
						break;
					}
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
