package com.cognizant.truyum.dao;

import java.util.List;


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;



public class MenuItemDaoCollectionImplTest{
	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuitem : menuItemList) {
			System.out.println(menuitem);
		}
	}
	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuitem : menuItemList) {
			System.out.println(menuitem);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuitem = new MenuItem(1, "RavaDosa", 30.00f, true, DateUtil.convertToDate("22/07/2015"),"Main Course" ,true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuitem);
		System.out.println(menuItemDao.getMenuItem(1));	
	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(1));
	}
	
	public static void main(String[] args){
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();	
		testModifyMenuItem();
		testGetMenuItem();
	}
	
}
