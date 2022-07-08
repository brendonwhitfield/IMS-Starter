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
		return "Order [orderId=" + orderId + ", fkCustomerId=" + fkCustomerId + ", address=" + address
		// + ", totalCost=" + totalCost + ""
				+ "]";
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
		return Objects.equals(fkCustomerId, other.fkCustomerId) && Objects.equals(address, other.address)
				&& Objects.equals(orderId, other.orderId);
	}

}