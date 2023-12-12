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
 * Servlet implementation class SearchProductByBrand
 */
@WebServlet(urlPatterns = {"/searchProductByBrand"})
public class SearchProductByBrand extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String hp = req.getParameter("HP");
		System.out.println(hp);
		String asus = req.getParameter("ASUS");
		String lenovo = req.getParameter("LENOVO");
		String dell = req.getParameter("DELL");
		String msi = req.getParameter("MSI");
		String macbook = req.getParameter("Macbook");
		String gigabyte = req.getParameter("Gigabyte");
		
		String index = req.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);
        List<Product> listProductNamedHP = null;
        List<Product> listProductNamedASUS = null;
        List<Product> listProductNamedLENOVO = null;
        List<Product> listProductNamedDELL = null;
        List<Product> listProductNamedMSI = null;
        List<Product> listProductNamedMACBOOK = null;
        List<Product> listProductNamedGIGABYTE = null;
		if(hp != null) {
			listProductNamedHP = ProductDB.getProductsByBrand(hp, indexPage);
		}
		if(asus !=null) {
			listProductNamedASUS = ProductDB.getProductsByBrand(asus, indexPage);
		}
		if(lenovo !=null) {
			listProductNamedLENOVO = ProductDB.getProductsByBrand(lenovo, indexPage);
		}
		if(dell !=null) {
			listProductNamedDELL = ProductDB.getProductsByBrand(dell, indexPage);
		}
		if(msi !=null) {
			listProductNamedMSI = ProductDB.getProductsByBrand(msi, indexPage);
		}
		if(macbook !=null) {
			listProductNamedMACBOOK = ProductDB.getProductsByBrand(macbook, indexPage);
		}
		if(gigabyte !=null) {
			listProductNamedGIGABYTE = ProductDB.getProductsByBrand(gigabyte, indexPage);
		}
		
		List<Product> combinedList = new ArrayList<>();
		if(listProductNamedHP != null) {
			combinedList.addAll(listProductNamedHP);
		}
		if(listProductNamedASUS !=null) {
			combinedList.addAll(listProductNamedASUS);
		}
		if(listProductNamedLENOVO !=null) {
			combinedList.addAll(listProductNamedLENOVO);
		}
		if(listProductNamedDELL !=null) {
			combinedList.addAll(listProductNamedDELL);
		}
		if(listProductNamedMSI !=null) {
			combinedList.addAll(listProductNamedMSI);
		}
		if(listProductNamedMACBOOK !=null) {
			combinedList.addAll(listProductNamedMACBOOK);
		}
		if(listProductNamedGIGABYTE !=null) {
			combinedList.addAll(listProductNamedGIGABYTE);
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
