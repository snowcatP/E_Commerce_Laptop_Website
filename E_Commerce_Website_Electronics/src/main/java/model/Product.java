package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
    private String nameProd;
    private double price;
    private String description;
    private String category;
    private String brand;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    
    @OneToOne
    private Configuration configuration;
    private int quantity;
    
    
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getImage4() {
		return image4;
	}

	public String getNameProd() {
		return nameProd;
	}

	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
