package com.MySeleniumProject.API.Pojo;

public class EcomAddProductResponse {

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String productId;
	private String message;

}
