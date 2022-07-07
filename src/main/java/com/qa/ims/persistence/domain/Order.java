package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long orderId;
	private Long fkCustomerId;
	private String address;

	public Order(Long fkCustomerId, String address) {
		this.setFkCustomerId(fkCustomerId);
		this.setAddress(address);
	}

	public Order(Long orderId, Long fkCustomerId, String address) {
		this.setOrderId(orderId);
		this.setFkCustomerId(fkCustomerId);
		this.setAddress(address);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getFkCustomerId() {
		return fkCustomerId;
	}

	public void setFkCustomerId(Long fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "order ID:" + orderId + "/n customer ID:" + fkCustomerId + "/n address" + address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkCustomerId, address, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(fkCustomerId, other.fkCustomerId)
				&& Objects.equals(address, other.address) && Objects.equals(orderId, other.orderId);
	}
	// public int getTotalCost() {
	// return 0;
	// }
	// loop through and calculate the cost
	//

}