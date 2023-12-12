package controllers.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import database.ConfigurationDB;
import database.ProductDB;
import model.Configuration;
import model.Product;
import database.*;

@WebServlet(urlPatterns = {"/admin_views/loadProduct"})
public class LoadProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String idString = req.getParameter("pid");
		Long id = Long.valueOf(idString);
		Product p = ProductDB.getProductById(id);

		req.setAttribute("detail", p);
		getServletContext().getRequestDispatcher("/admin_views/EditProduct.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		
//		String id = req.getParameter("id");
//		
//		if(id == null)	System.out.println("de null");
//		
//		String pn = req.getParameter("productPrice");
//		String name = req.getParameter("name");
//		System.out.println(pn);
//		System.out.println(name);
//		if(pn == null) {
//			System.out.println("no");
//		}
//		else {
//			System.out.println("yes");
//		}
//		getServletContext().getRequestDispatcher("/views/admin/product_table.jsp").forward(req, resp);
//		
//	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		
//		
//		String idString = req.getParameter("pid");
//		Long id = Long.parseLong(idString);
//
//		System.out.println(id);
//		String processor = req.getParameter("processor");
//		double screen = Double.parseDouble(req.getParameter("screen"));
//		
//		int memory = Integer.parseInt(req.getParameter("memory"));
//		int ram = Integer.parseInt(req.getParameter("ram"));
//		String graphicCard = req.getParameter("graphicCard");
//		String audioCard = req.getParameter("audioCard");
//		
//		Configuration config = new Configuration();
//		config.setProcessor(processor);
//		config.setAudioCard(audioCard);
//		config.setGraphicCard(graphicCard);
//		config.setMemory(memory);
//		config.setRam(ram);
//		config.setScreen(screen);
//		
//		String productName = req.getParameter("productName");
//		double productPrice = Double.parseDouble(req.getParameter("productPrice"));
//		String category = req.getParameter("category");
//		String description = req.getParameter("productDescription");
//		int quantity = Integer.parseInt(req.getParameter("quantity"));
//		
//		//Xử lý nhập hình ảnh vào database
//				Part file_img1 = req.getPart("pic1");
//				Part file_img2 = req.getPart("pic2");
//				Part file_img3 = req.getPart("pic3");
//				Part file_img4 = req.getPart("pic4");
//				
//				String img1Filename = file_img1.getSubmittedFileName();
//				String img2Filename = file_img2.getSubmittedFileName();
//				String img3Filename = file_img3.getSubmittedFileName();
//				String img4Filename = file_img4.getSubmittedFileName();
//				
//				String uploadPath1 = "C:/Users/Admin/eclipse-workspace/Project/E_Commerce_Website_Electronics/src/main/webapp/images/"+img1Filename;
//				String uploadPath2 = "C:/Users/Admin/eclipse-workspace/Project/E_Commerce_Website_Electronics/src/main/webapp/images/"+img2Filename;
//				String uploadPath3 = "C:/Users/Admin/eclipse-workspace/Project/E_Commerce_Website_Electronics/src/main/webapp/images/"+img3Filename;
//				String uploadPath4 = "C:/Users/Admin/eclipse-workspace/Project/E_Commerce_Website_Electronics/src/main/webapp/images/"+img4Filename;
//				
////				file_img1.write(uploadPath1);
////				file_img2.write(uploadPath2);
////				file_img3.write(uploadPath3);
////				file_img4.write(uploadPath4);
//				try {
//					
//					FileOutputStream fos1 = new FileOutputStream(uploadPath1);
//					FileOutputStream fos2 = new FileOutputStream(uploadPath2);
//					FileOutputStream fos3 = new FileOutputStream(uploadPath3);
//					FileOutputStream fos4 = new FileOutputStream(uploadPath4);
//					
//					InputStream is1 = (InputStream) file_img1.getInputStream();
//					InputStream is2 = (InputStream) file_img2.getInputStream();
//					InputStream is3 = (InputStream) file_img3.getInputStream();
//					InputStream is4 = (InputStream) file_img4.getInputStream();
//					
//					byte[] buffer = new byte[4096];
//
//				    // Read data from input stream and write to file
//				    int bytesRead1;
//				    while ((bytesRead1 = is1.read(buffer)) != -1) {
//				        fos1.write(buffer, 0, bytesRead1);
//				    }
//
//				    int bytesRead2;
//				    while ((bytesRead2 = is2.read(buffer)) != -1) {
//				        fos2.write(buffer, 0, bytesRead2);
//				    }
//
//				    int bytesRead3;
//				    while ((bytesRead3 = is3.read(buffer)) != -1) {
//				        fos3.write(buffer, 0, bytesRead3);
//				    }
//
//				    int bytesRead4;
//				    while ((bytesRead4 = is4.read(buffer)) != -1) {
//				        fos4.write(buffer, 0, bytesRead4);
//				    }
//
//				    fos1.close();
//				    fos2.close();
//				    fos3.close();
//				    fos4.close();
//				    is1.close();
//				    is2.close();
//				    is3.close();
//				    is4.close();
//					
////					byte[] data1 = new byte[is1.available()];
////					byte[] data2 = new byte[is2.available()];
////					byte[] data3 = new byte[is3.available()];
////					byte[] data4 = new byte[is4.available()];
////					
////					is1.read(data1);
////					is2.read(data2);
////					is3.read(data3);
////					is4.read(data4);
////					
////					fos1.write(data1);
////					fos2.write(data2);
////					fos3.write(data3);
////					fos4.write(data4);
////					
////					fos1.close();
////					fos2.close();
////					fos3.close();
////					fos4.close();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				String pic1 = req.getParameter("pic1");
//				String pic2 = req.getParameter("pic2");
//				String pic3 = req.getParameter("pic3");
//				String pic4 = req.getParameter("pic4");
//				String brand = req.getParameter("productBrand");
//				
//				System.out.println("Select img: "+ pic1);
//				System.out.println("Select img: "+ pic2);
//				System.out.println("Select img: "+ pic3);
//				System.out.println("Select img: "+ pic4);
//				
//				Product product = new Product();
//				product.setBrand(brand);
//				product.setCategory(category);
//				product.setConfiguration(config);
//				product.setDescription(description);
//				product.setImage1(img1Filename);
//				product.setImage2(img2Filename);
//				product.setImage3(img3Filename);
//				product.setImage4(img4Filename);
//				product.setNameProd(productName);
//				product.setQuantity(quantity);
//				product.setPrice(productPrice);
//		
//		ProductDB.updateProductById(id, product);
//		req.getRequestDispatcher("/views/admin/ManageProduct").forward(req, resp);
//	}
	
}
