package com.murilorb.course.entities.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.murilorb.course.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	Set<Long> categories = new HashSet<>();

	public ProductDTO() {
	}

	public ProductDTO(Product obj) {
		name = obj.getName();
		description = obj.getDescription();
		price = obj.getPrice();
		imgUrl = obj.getImgUrl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Long> getCategories() {
		return categories;
	}

}
