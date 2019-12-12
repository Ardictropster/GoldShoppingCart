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
	@Min(value = 50, message = "Minimum value should be greater than 100")
	@Column(name = "price")
	private double productPrice;

	@Column(name = "unit")
	private String unitStock;

	@Transient
	private MultipartFile productImage;

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

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public String getProdManufacturer() {
		return prodManufacturer;
	}

	public void setProdManufacturer(String prodManufacturer) {
		this.prodManufacturer = prodManufacturer;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getUnitStock() {
		return unitStock;
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

}
