package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long orderId;
	private Long fkCustomerId;
	private Long fkOrderContentsId;

	public Order(Long fkCustomerId, Long fkOrderContentsId) {
		this.setFkCustomerId(fkCustomerId);
		this.setFkOrderContentsId(fkOrderContentsId);
	}

	public Order(Long orderId, Long fkCustomerId, Long fkOrderContentsId) {
		this.setOrderId(orderId);
		this.setFkCustomerId(fkCustomerId);
		this.setFkOrderContentsId(fkOrderContentsId);
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

	public Long getFkOrderContentsId() {
		return fkOrderContentsId;
	}

	public void setFkOrderContentsId(Long fkOrderContentsId) {
		this.fkOrderContentsId = fkOrderContentsId;
	}

	@Override
	public String toString() {
		return "order ID:" + orderId + "/n customer ID:" + fkCustomerId + "/n order contents ID" + fkOrderContentsId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkCustomerId, fkOrderContentsId, orderId);
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
				&& Objects.equals(fkOrderContentsId, other.fkOrderContentsId) && Objects.equals(orderId, other.orderId);
	}
	// public int getTotalCost() {
	// return 0;
	// }
	// loop through and calculate the cost
	//

}