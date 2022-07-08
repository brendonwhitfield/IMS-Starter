package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderContentDAO;
import com.qa.ims.persistence.domain.OrderContent;
import com.qa.ims.utils.Utils;

/**
 * Takes in contents of an order for CRUD functionality
 *
 */
public class OrderContentsController implements CrudController<OrderContent> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderContentDAO OrderContentDAO;
	private Utils utils;

	public OrderContentsController(OrderContentDAO OrderContentDAO, Utils utils) {
		super();
		this.OrderContentDAO = OrderContentDAO;
		this.utils = utils;
	}

	/**
	 * Reads all order contents to the logger
	 */
	@Override
	public List<OrderContent> readAll() {
		List<OrderContent> orderContents = OrderContentDAO.readAll();
		for (OrderContent orderContent : orderContents) {
			LOGGER.info(orderContent);
		}
		return orderContents;
	}

	/**
	 * Creates an order content by taking in user input
	 */
	@Override
	public OrderContent create() {
		LOGGER.info("Please enter the order ID");
		Long fkOrderId = utils.getLong();
		LOGGER.info("Please enter the item ID");
		Long fkItemId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		LOGGER.info("Please enter the price");
		Long price = utils.getLong();
		OrderContent orderContent = OrderContentDAO.create(new OrderContent(fkOrderId, fkItemId, quantity, price));
		LOGGER.info("Order contents now created!");
		return orderContent;
	}

	/**
	 * Updates an existing order content by taking in user input
	 */
	@Override
	public OrderContent update() {
		LOGGER.info("Please enter the ID of the order contents you would like to update");
		Long orderContentsId = utils.getLong();
		LOGGER.info("Please enter the same order ID as before");
		Long fkOrderId = utils.getLong();
		LOGGER.info("Please enter the item ID");
		Long fkItemId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		OrderContent orderContent = OrderContentDAO.update(new OrderContent(orderContentsId, fkOrderId, fkItemId, quantity));
		LOGGER.info("Order Contents Updated");
		return orderContent;
	}

	/**
	 * Deletes an existing order content by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order contents you would like to delete");
		Long orderContentsId = utils.getLong();
		return OrderContentDAO.delete(orderContentsId);
	}

}
