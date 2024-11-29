package com.MySeleniumProject.API.Pojo;

import java.util.List;

public class EcomAddProductBody {

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

	private List<OrderDetails> orders;
}
