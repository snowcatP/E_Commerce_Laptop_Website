package controllers.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import database.ConfigurationDB;
import database.ProductDB;
import database.*;

import model.Configuration;
import model.Product;

/**
 * Servlet implementation class EditProductController
 */

@MultipartConfig
@WebServlet("/admin_views/edit_product")
public class EditProductController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String idString = req.getParameter("productId");
		Long id = Long.parseLong(idString);

		String processor = req.getParameter("processor");
		double screen = Double.parseDouble(req.getParameter("screen"));
		
		int memory = Integer.parseInt(req.getParameter("memory"));
		int ram = Integer.parseInt(req.getParameter("ram"));
		String graphicCard = req.getParameter("graphicCard");
		String audioCard = req.getParameter("audioCard");
		
		Configuration config = new Configuration();
		config.setProcessor(processor);
		config.setAudioCard(audioCard);
		config.setGraphicCard(graphicCard);
		config.setMemory(memory);
		config.setRam(ram);
		config.setScreen(screen);
		ConfigurationDB.update(config);
		
		String productName = req.getParameter("nameProd");
		double productPrice = Double.parseDouble(req.getParameter("price"));
		String category = req.getParameter("category");
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String brand = req.getParameter("brand");
		
		Part file_img1 = req.getPart("image1"); 
		Part file_img2 = req.getPart("image2"); 
		Part file_img3 = req.getPart("image3"); 
		Part file_img4 = req.getPart("image4");
		String img1Filename = file_img1.getSubmittedFileName(); 
		String img2Filename =
		file_img2.getSubmittedFileName(); String img3Filename =
		file_img3.getSubmittedFileName(); String img4Filename =
		file_img4.getSubmittedFileName();
		/*
		 * // Xử lý nhập hình ảnh vào database Part file_img1 = req.getPart("image1");
		 * 
		 * String uploadPath1 =
		 * "D:\\Tai lieu cac mon hoc\\Nam 3\\Ky 1\\Web\\eclipse-workspace\\E_Commerce_Website_Electronics\\src\\main\\webapp"
		 * + img1Filename; String uploadPath2 =
		 * "D:\\Tai lieu cac mon hoc\\Nam 3\\Ky 1\\Web\\eclipse-workspace\\E_Commerce_Website_Electronics\\src\\main\\webapp"
		 * + img2Filename; String uploadPath3 =
		 * "D:\\Tai lieu cac mon hoc\\Nam 3\\Ky 1\\Web\\eclipse-workspace\\E_Commerce_Website_Electronics\\src\\main\\webapp"
		 * + img3Filename; String uploadPath4 =
		 * "D:\\Tai lieu cac mon hoc\\Nam 3\\Ky 1\\Web\\eclipse-workspace\\E_Commerce_Website_Electronics\\src\\main\\webapp"
		 * + img4Filename;
		 * 
		 * try {
		 * 
		 * FileOutputStream fos1 = new FileOutputStream(uploadPath1); FileOutputStream
		 * fos2 = new FileOutputStream(uploadPath2); FileOutputStream fos3 = new
		 * FileOutputStream(uploadPath3); FileOutputStream fos4 = new
		 * FileOutputStream(uploadPath4);
		 * 
		 * InputStream is1 = (InputStream) file_img1.getInputStream(); InputStream is2 =
		 * (InputStream) file_img2.getInputStream(); InputStream is3 = (InputStream)
		 * file_img3.getInputStream(); InputStream is4 = (InputStream)
		 * file_img4.getInputStream();
		 * 
		 * byte[] buffer = new byte[4096];
		 * 
		 * // Read data from input stream and write to file int bytesRead1; while
		 * ((bytesRead1 = is1.read(buffer)) != -1) { fos1.write(buffer, 0, bytesRead1);
		 * }
		 * 
		 * int bytesRead2; while ((bytesRead2 = is2.read(buffer)) != -1) {
		 * fos2.write(buffer, 0, bytesRead2); }
		 * 
		 * int bytesRead3; while ((bytesRead3 = is3.read(buffer)) != -1) {
		 * fos3.write(buffer, 0, bytesRead3); }
		 * 
		 * int bytesRead4; while ((bytesRead4 = is4.read(buffer)) != -1) {
		 * fos4.write(buffer, 0, bytesRead4); }
		 * 
		 * fos1.close(); fos2.close(); fos3.close(); fos4.close(); is1.close();
		 * is2.close(); is3.close(); is4.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		

		Product product = ProductDB.getProductById(id);
		product.setBrand(brand);
		product.setCategory(category);
		product.setConfiguration(config);
		product.setDescription(description);
		
		if(img1Filename != "") {
			product.setImage1(img1Filename); product.setImage2(img2Filename);
			product.setImage3(img3Filename); product.setImage4(img4Filename);
		}
		product.setNameProd(productName);
		product.setQuantity(quantity);
		product.setPrice(productPrice);
		ProductDB.update(product);
		
		
		getServletContext().getRequestDispatcher("/admin_views/ManageProduct").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

}
