package model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Invoice implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoiceId;
    private User user;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<LineProduct> lineProducts;
    
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    private double totalPrice = 0;
    
    private boolean status = false;
    
    private boolean shipped = false;
    
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the shipped
	 */
	public boolean isShipped() {
		return shipped;
	}

	/**
	 * @param shipped the shipped to set
	 */
	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}
    
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<LineProduct> getLineProducts() {
		return lineProducts;
	}

	public void setLineProducts(List<LineProduct> lineProducts) {
		this.lineProducts = lineProducts;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Invoice() {
    	
    }
    
}
