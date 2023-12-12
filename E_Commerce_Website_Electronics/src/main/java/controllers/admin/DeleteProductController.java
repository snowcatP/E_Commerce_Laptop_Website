package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ProductDB;
import model.Product;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet(urlPatterns = {"/admin_views/delete"})
public class DeleteProductController extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String message = "";
		String idString = req.getParameter("pid");
		Long id = Long.parseLong(idString);
		ProductDB daoproduct = new ProductDB();
		daoproduct.deleteProductById(id);
		req.setAttribute("message", "Đã xoá thành công");
		getServletContext().getRequestDispatcher("/admin_views/ManageProduct").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
