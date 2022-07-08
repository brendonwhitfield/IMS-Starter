package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderContent {

	private Long orderContentsId;
	private Long fkOrderId;
	private Long fkItemId;
	private Long quantity;

	public OrderContent(Long fkOrderId, Long fkItemId, Long quantity) {
		this.setFkOrderId(fkOrderId);
		this.setFkItemId(fkItemId);
		this.setQuantity(quantity);
	}

	public OrderContent(Long orderContentsId, Long fkOrderId, Long fkItemId, Long quantity) {
		this.setOrderContentsId(orderContentsId);
		this.setFkOrderId(fkOrderId);
		this.setFkItemId(fkItemId);
		this.setQuantity(quantity);
	}

	
	public Long getOrderContentsId() {
		return orderContentsId;
	}

	public void setOrderContentsId(Long orderContentsId) {
		this.orderContentsId = orderContentsId;
	}

	public Long getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(Long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public Long getFkItemId() {
		return fkItemId;
	}

	public void setFkItemId(Long fkItemId) {
		this.fkItemId = fkItemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public int getTotalCost() {
		return 0;
	}

	@Override
	public String toString() {
		return "order contents id:" + orderContentsId + "/n order id:" + fkOrderId + "/n item id:" + fkItemId + "/n quantity:";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkItemId, fkOrderId, orderContentsId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderContent other = (OrderContent) obj;
		return Objects.equals(fkItemId, other.fkItemId) && Objects.equals(fkOrderId, other.fkOrderId)
				&& Objects.equals(orderContentsId, other.orderContentsId) && Objects.equals(quantity, other.quantity);
	}

	

}

