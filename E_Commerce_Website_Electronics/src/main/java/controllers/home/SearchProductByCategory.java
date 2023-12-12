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
 * Servlet implementation class SearchProductByCategory
 */
@WebServlet(urlPatterns = {"/searchProductByCategory"})
public class SearchProductByCategory extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String gaming = req.getParameter("GAMING");
		System.out.println(gaming);
		String office = req.getParameter("OFFICE");
		
		String index = req.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);
        List<Product> listProductGaming = null;
        List<Product> listProductOffice = null;
      
		if(gaming != null) {
			listProductGaming = ProductDB.getProductsByCategory(gaming, indexPage);
		}
		if(office !=null) {
			listProductOffice = ProductDB.getProductsByCategory(office, indexPage);
		}
		
		List<Product> combinedList = new ArrayList<>();
		if(listProductGaming != null) {
			combinedList.addAll(listProductGaming);
		}
		if(listProductOffice !=null) {
			combinedList.addAll(listProductOffice);
		}
		
		List<Product> listTopPriceProduct = ProductDB.get3HighPricedProducts();
		
		
        
        int allProduct = ProductDB.countProducts();
        int endPage = allProduct/9;
        if(allProduct % 9 != 0) {
        	endPage++;
        }
        
        req.setAttribute("tag", indexPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("allProduct", combinedList);
        req.setAttribute("topProduct", listTopPriceProduct);

        req.getRequestDispatcher("/category.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
