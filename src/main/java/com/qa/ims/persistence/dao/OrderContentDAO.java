package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderContent;
import com.qa.ims.utils.DBUtils;

public class OrderContentDAO implements Dao<OrderContent> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderContent modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderContentsId = resultSet.getLong("order_contents_id");
		Long fkOrderId = resultSet.getLong("fk_order_id");
		Long fkItemId = resultSet.getLong("fk_item_id");
		Long quantity = resultSet.getLong("quantity");
		Long price = resultSet.getLong("price");
		return new OrderContent(orderContentsId, fkOrderId, fkItemId, quantity, price);
	}

	/**
	 * Reads all order content data from the database
	 * 
	 * @return A list featuring different order contents
	 */
	@Override
	public List<OrderContent> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_contents");) {
			List<OrderContent> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderContent readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM order_contents ORDER BY order_contents_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order content data entry in the database
	 *
	 */
	@Override
	public OrderContent create(OrderContent orderContent) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO order_contents(fk_order_id, fk_item_id, quantity, price) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, orderContent.getFkOrderId());
			statement.setLong(2, orderContent.getFkItemId());
			statement.setLong(3, orderContent.getQuantity());
			statement.setLong(4, orderContent.getPrice());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderContent read(Long orderContentsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM order_contents WHERE order_contents_id = ?");) {
			statement.setLong(1, orderContentsId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	// @Override

	/**
	 * Updates an Orders contents in the database
	 * 
	 *
	 * @return
	 */
	@Override
	public OrderContent update(OrderContent orderContent) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE order_contents SET fk_order_id = ?, fk_item_id = ?, quantity = ?, price = ? WHERE order_contents_id = ?");) {
			statement.setLong(1, orderContent.getFkOrderId());
			statement.setLong(2, orderContent.getFkItemId());
			statement.setLong(3, orderContent.getQuantity());
			statement.setLong(4, orderContent.getPrice());
			statement.setLong(5, orderContent.getOrderContentsId());
			statement.executeUpdate();
			return read(orderContent.getOrderContentsId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an order in the database
	 */
	@Override
	public int delete(long orderContentsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM order_contents WHERE order_contents_id = ?");) {
			statement.setLong(1, orderContentsId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;

	}
}