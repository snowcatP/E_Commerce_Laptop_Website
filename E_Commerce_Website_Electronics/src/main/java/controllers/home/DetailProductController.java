package controllers.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ProductDB;
import model.Product;

/**
 * Servlet implementation class DetailProductController
 */
@WebServlet(urlPatterns = {"/view_detail"})
public class DetailProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String idString = req.getParameter("pid");
		Long id = Long.parseLong(idString);
		Product p = ProductDB.getProductById(id);
		List<Product> listRelatedProduct = ProductDB.get4RelatedProductsByCategory(id);
		
		req.setAttribute("detailProduct", p);
	    req.setAttribute("listRelatedProduct", listRelatedProduct);
	    getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
