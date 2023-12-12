package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<LineProduct> products;

	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<LineProduct> getProducts() {
		return products;
	}

	public void setProducts(List<LineProduct> products) {
		this.products = products;
	}

	public Cart(Long cartId, List<LineProduct> products) {
		this.cartId = cartId;
		this.products = products;
	}

	public Cart() {

	}
	
}
