package controllers.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ProductDB;
import model.Product;

/**
 * Servlet implementation class SearchProductByRangePrice
 */
@WebServlet(urlPatterns = {"/searchProductByRangePrice"})
public class SearchProductByRangePrice extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		double price_min = Double.parseDouble(req.getParameter("PRICE_MIN"));
		System.out.println(price_min);
		double price_max = Double.parseDouble(req.getParameter("PRICE_MAX"));
		System.out.println(price_max);
		String index = req.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);
        List<Product> listProductRangePrice = null;
 
      
		if(req.getParameter("PRICE_MIN") != null && req.getParameter("PRICE_MIN") !=null) {
			listProductRangePrice = ProductDB.getProductsByPriceRange(price_min,price_max, indexPage);
		}
		
		
		List<Product> listTopPriceProduct = ProductDB.get3HighPricedProducts();
		
		
        
        int allProduct = ProductDB.countProducts();
        int endPage = allProduct/9;
        if(allProduct % 9 != 0) {
        	endPage++;
        }
        
        req.setAttribute("tag", indexPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("allProduct", listProductRangePrice);
        req.setAttribute("topProduct", listTopPriceProduct);

        req.getRequestDispatcher("/category.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
