package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;



public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 3);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}
	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 3);
		try{
			cartDao.getAllCartItems(1);
		}
		catch (CartEmptyException e) {
			System.out.println("Cart is Empty");
		}
	}
	public static void main(String[] args) {
		try {
			testAddCartItem();
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testGetAllCartItems();
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testRemoveCartItem();
	}

}