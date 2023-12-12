package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProductDB;
import model.Product;

/**
 * Servlet implementation class ManageProduct
 */
@WebServlet(urlPatterns = {"/admin_views/ManageProduct"})
public class ManageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = "/admin_views/product_table.jsp";
		// Khởi tạo các biến
		List<Product> list = ProductDB.getAllProducts();

		// Store the list in the request attribute
		req.setAttribute("allproductList", list);

		// Forward the request to the JSP page
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
