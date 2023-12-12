package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Admin implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phone;
	private int salary;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Admin(Long adminId, String firstName, String lastName, String address, String phone, String email,
			int salary) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
	}
	public Admin() {
		
	}
}
