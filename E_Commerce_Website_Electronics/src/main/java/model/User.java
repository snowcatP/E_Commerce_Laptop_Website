package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	
	@OneToOne
	private Cart cart;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	public User(Long userId, String firstName, String lastName, String address, String phone, String email, Cart cart) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.cart = cart;
	}

	public User() {

	}
	
	
}
