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
 * Servlet implementation class SeachProductByInputName
 */
@WebServlet("/search_by_name")
public class SeachProductByInputName extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<Product> listTopPriceProduct = ProductDB.get3HighPricedProducts();
		String name = req.getParameter("namesearch");
		String index = req.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);
        
        List<Product> listProductByIndexPage = ProductDB.getProductsByName(name,indexPage);
        
        int allProduct = ProductDB.countProducts();
        int endPage = allProduct/9;
        if(allProduct % 9 != 0) {
        	endPage++;
        }
        
        req.setAttribute("tag", indexPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("allProduct", listProductByIndexPage);
        req.setAttribute("topProduct", listTopPriceProduct);

        req.getRequestDispatcher("/category.jsp").forward(req, resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
