package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemsController controller;

	@Test
	public void testCreate() {
		final String I_NAME = "cilit bang";
		final Long I_PRICE = 3L;
		final Item created = new Item(I_NAME, I_PRICE);

		Mockito.when(utils.getString()).thenReturn(I_NAME);
		Mockito.when(utils.getLong()).thenReturn(I_PRICE);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, item.create();)
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> item = new ArrayList<>();
		items.add(new Item(1L, "ball", 4L));

		Mockito.when(dao.readAll()).thenReturn(item);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "bottle", 5L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getLong()).thenReturn(5L);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	// need to add delete below//