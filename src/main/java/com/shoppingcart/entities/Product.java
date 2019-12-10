package com.shoppingcart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Entity class of Product table
 * 
 * @author kenarayan
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodId;

	@Column(name = "category")
	private String prodCategory;

	@Column(name = "description")
	private String prodDescription;

	@Column(name = "manufacturer")
	private String prodManufacturer;

	@NotEmpty(message = "Product Name is mandatory")
	@Column(name = "name")
	private String prodName;

	@NotNull(message = "Please provide some price")
	@Min(value = 100, message = "Minimum value should be greater than 100")
	@Column(name = "price")
	private double productPrice;

	@Column(name = "unit")
	private String unitStock;

	@Transient
	private MultipartFile productImage;

	public int getProductId() {
		return prodId;
	}

	public String getProductCategory() {
		return prodCategory;
	}

	public String getProductDescription() {
		return prodDescription;
	}

	public String getProductManufacturer() {
		return prodManufacturer;
	}

	public String getProductName() {
		return prodName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public String getUnitStock() {
		return unitStock;
	}

	public void setProductId(int productId) {
		this.prodId = productId;
	}

	public void setProductCategory(String productCategory) {
		this.prodCategory = productCategory;
	}

	public void setProductDescription(String productDescription) {
		this.prodDescription = productDescription;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.prodManufacturer = productManufacturer;
	}

	public void setProductName(String productName) {
		this.prodName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	// Constructors
	public Product(int productId, String productCategory, String productDescription, String productManufacturer,
			String productName, double productPrice, String unitStock) {
		super();
		this.prodId = productId;
		this.prodCategory = productCategory;
		this.prodDescription = productDescription;
		this.prodManufacturer = productManufacturer;
		this.prodName = productName;
		this.productPrice = productPrice;
		this.unitStock = unitStock;
	}

	public Product() {

	}

}
