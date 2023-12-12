package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.InvoiceDB;
import model.Invoice;

/**
 * Servlet implementation class UpdateInvoice
 */
@WebServlet("/admin_views/update_invoice")
public class UpdateInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Long invoiceId = Long.parseLong(request.getParameter("invoiceId"));
		String status = request.getParameter("status");
		
		
		Invoice invoice = InvoiceDB.getInvoiceById(invoiceId);
		
		if(status.equals("Đang vận chuyển")) {
			invoice.setStatus(true);
		} else if(status.equals("Hoàn thành")) {
			invoice.setStatus(false);
			invoice.setShipped(true);
		}
		
		InvoiceDB.update(invoice);
		
		getServletContext().getRequestDispatcher("/admin_views/get_invoices_data").forward(request, response);
	}

}
