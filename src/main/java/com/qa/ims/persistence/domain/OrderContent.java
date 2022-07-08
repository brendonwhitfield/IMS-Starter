package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderContent {

	private Long orderContentsId;
	private Long fkOrderId;
	private Long fkItemId;
	private Long quantity;
	private Long price;
	private Long cost;

	public OrderContent(Long fkOrderId, Long fkItemId, Long quantity, Long price) {
		this.setFkOrderId(fkOrderId);
		this.setFkItemId(fkItemId);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	public OrderContent(Long orderContentsId, Long fkOrderId, Long fkItemId, Long quantity, Long price) {
		this.setOrderContentsId(orderContentsId);
		this.setFkOrderId(fkOrderId);
		this.setFkItemId(fkItemId);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	/*
	 * public Long cost(){
	 * 
	 * this.cost= price*quantity; return this.cost; }
	 */

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Long getCost() {
		cost = getPrice() * getQuantity();
		return this.cost;
	}

	@Override
	public String toString() {
		return "OrderContent [orderContentsId=" + orderContentsId + ", fkOrderId=" + fkOrderId + ", fkItemId="
				+ fkItemId + ", quantity=" + quantity + ", price=" + price + ", cost=" + getCost() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, fkItemId, fkOrderId, orderContentsId, price, quantity);
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
		return Objects.equals(cost, other.cost) && Objects.equals(fkItemId, other.fkItemId)
				&& Objects.equals(fkOrderId, other.fkOrderId) && Objects.equals(orderContentsId, other.orderContentsId)
				&& Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity);
	}

}
