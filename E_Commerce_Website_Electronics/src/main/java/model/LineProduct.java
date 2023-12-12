package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class LineProduct implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lineProductId;
	
	@OneToOne
	private Product product;
	private int quantity = 1;
	
	
	public Long getLineProductId() {
		return lineProductId;
	}

	public void setLineProductId(Long lineProductId) {
		this.lineProductId = lineProductId;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public LineProduct(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public LineProduct(Long lineProductId, Product product, int quantity) {
		this.lineProductId = lineProductId;
		this.product = product;
		this.quantity = quantity;
	}

	public LineProduct() {

	}
}
