package controllers.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import database.ConfigurationDB;
import database.ProductDB;
import model.Configuration;
import model.*;

@MultipartConfig
@WebServlet("/admin_views/productManage")
public class ProductController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = "/admin_views/product_manage.jsp";
		String message = "";
		
		
		
		// get current action
		String action = req.getParameter("action");
		if (action == null) {
			
		}
		if (action.equals("add")){
			String processor = req.getParameter("processor");
			double screen = Double.valueOf(req.getParameter("screen"));
			int memory = Integer.valueOf(req.getParameter("memory"));
			int ram = Integer.valueOf(req.getParameter("ram"));
			String graphicCard = req.getParameter("graphicCard");
			String audioCard = req.getParameter("audioCard");
			
			Configuration config = new Configuration();
			config.setProcessor(processor);
			config.setAudioCard(audioCard);
			config.setGraphicCard(graphicCard);
			config.setMemory(memory);
			config.setRam(ram);
			config.setScreen(screen);
			
			String productName = req.getParameter("productName");
			int productPrice = Integer.valueOf(req.getParameter("productPrice"));
			String category = req.getParameter("category");
			String description = req.getParameter("productDescription");
			int quantity = Integer.valueOf(req.getParameter("quantity"));
			
			
			String realPath = req.getServletContext().getRealPath("/images");
			
			
	        // Ensure the 'images' directory exists
	        if (!Files.exists(Paths.get(realPath))) {
	            Files.createDirectories(Paths.get(realPath));
	        }
			
			//Xử lý nhập hình ảnh vào database
			Part file_img1 = req.getPart("pic1");
			Part file_img2 = req.getPart("pic2");
			Part file_img3 = req.getPart("pic3");
			Part file_img4 = req.getPart("pic4");
			
			String img1Filename = file_img1.getSubmittedFileName();
	        String img2Filename = file_img2.getSubmittedFileName();
	        String img3Filename = file_img3.getSubmittedFileName();
	        String img4Filename = file_img4.getSubmittedFileName();
			
			
			String uploadPath1 = "D:/Tai lieu cac mon hoc/Nam 3/Ky 1/Web/eclipse-workspace/E_Commerce_Website_Electronics/src/main/webapp/images" + "/" + img1Filename;
	        String uploadPath2 = "D:/Tai lieu cac mon hoc/Nam 3/Ky 1/Web/eclipse-workspace/E_Commerce_Website_Electronics/src/main/webapp/images" + "/" + img2Filename;
	        String uploadPath3 = "D:/Tai lieu cac mon hoc/Nam 3/Ky 1/Web/eclipse-workspace/E_Commerce_Website_Electronics/src/main/webapp/images" + "/" + img3Filename;
	        String uploadPath4 = "D:/Tai lieu cac mon hoc/Nam 3/Ky 1/Web/eclipse-workspace/E_Commerce_Website_Electronics/src/main/webapp/images" + "/" + img4Filename;
			
			file_img1.write(uploadPath1);
			file_img2.write(uploadPath2);
			file_img3.write(uploadPath3);
			file_img4.write(uploadPath4);
			
			try {
				
				FileOutputStream fos1 = new FileOutputStream(uploadPath1);
				FileOutputStream fos2 = new FileOutputStream(uploadPath2);
				FileOutputStream fos3 = new FileOutputStream(uploadPath3);
				FileOutputStream fos4 = new FileOutputStream(uploadPath4);
				
				InputStream is1 = (InputStream) file_img1.getInputStream();
				InputStream is2 = (InputStream) file_img2.getInputStream();
				InputStream is3 = (InputStream) file_img3.getInputStream();
				InputStream is4 = (InputStream) file_img4.getInputStream();
				
				byte[] buffer = new byte[4096];

			    // Read data from input stream and write to file
			    int bytesRead1;
			    while ((bytesRead1 = is1.read(buffer)) != -1) {
			        fos1.write(buffer, 0, bytesRead1);
			    }

			    int bytesRead2;
			    while ((bytesRead2 = is2.read(buffer)) != -1) {
			        fos2.write(buffer, 0, bytesRead2);
			    }

			    int bytesRead3;
			    while ((bytesRead3 = is3.read(buffer)) != -1) {
			        fos3.write(buffer, 0, bytesRead3);
			    }

			    int bytesRead4;
			    while ((bytesRead4 = is4.read(buffer)) != -1) {
			        fos4.write(buffer, 0, bytesRead4);
			    }

			    fos1.close();
			    fos2.close();
			    fos3.close();
			    fos4.close();
			    is1.close();
			    is2.close();
			    is3.close();
			    is4.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			String brand = req.getParameter("productBrand");
			
			Product product = new Product();
			product.setBrand(brand);
			product.setCategory(category);
			product.setConfiguration(config);
			product.setDescription(description);
			product.setImage1(img1Filename);
			product.setImage2(img2Filename);
			product.setImage3(img3Filename);
			product.setImage4(img4Filename);
			product.setNameProd(productName);
			product.setQuantity(quantity);
			product.setPrice(productPrice);
			
			message = "";
			ConfigurationDB.insert(config);
			ProductDB.insert(product);
			req.setAttribute("config", config);
			req.setAttribute("product", product);
			req.setAttribute("message", "Đã thêm thành công");
		}   
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
}
