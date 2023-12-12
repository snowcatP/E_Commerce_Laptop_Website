package controllers.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.AdminAccountDB;
import database.AdminDB;
import database.ConfigurationDB;
import database.ProductDB;
import model.Admin;
import model.AdminAccount;
import model.Configuration;
import model.Product;

/**
 * Servlet implementation class HomeTopProductController
 */
@WebServlet(urlPatterns = {"/home"})
public class HomeTopProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url="/index.jsp";
		//Khởi tạo các biến
		ProductDB daoproduct = new ProductDB();
	    List<Product> list = daoproduct.get16HighPricedProducts();
	    List<Product> listnewProduct = daoproduct.getTop6HighQuantityProducts();
	    Product detailProduct = ProductDB.getProductById(null);
	 // Print a message to check if information is retrieved

	    // Store the list in the request attribute
	    req.setAttribute("productList", list);
	    req.setAttribute("top6new", listnewProduct);

	    // Forward the request to the JSP page
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
	}
	

}
