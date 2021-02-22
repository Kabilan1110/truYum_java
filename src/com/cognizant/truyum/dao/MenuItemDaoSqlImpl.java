package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String query = "select * from menu_item;";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getInt("id");
				String name = rs.getString("Name");
				float price = rs.getInt("Price");
				String active = rs.getString("Active");
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String freeDelivery = rs.getString("Free_Delivery");
				boolean activeCheck = false;
				if (active.equalsIgnoreCase("Yes")) {
					activeCheck = true;
				}
				boolean freeDeli = false;
				if (freeDelivery.equalsIgnoreCase("Yes")) {
					freeDeli = true;
				}
				MenuItem menuItem = new MenuItem(id, name, price, activeCheck, date, category, freeDeli);
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String query = "select * from menu_item\r\n" + "where  Active=\"Yes\" && year(Date_of_Launch)>2018 ;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getInt("id");
				String name = rs.getString("Name");
				float price = rs.getInt("Price");
				String active = rs.getString("Active");
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String freeDelivery = rs.getString("Free_Delivery");
				boolean activeCheck = false;
				if (active.equalsIgnoreCase("Yes")) {
					activeCheck = true;
				}
				boolean freeDeli = false;
				if (freeDelivery.equalsIgnoreCase("Yes")) {
					freeDeli = true;
				}
				MenuItem menuItem = new MenuItem(id, name, price, activeCheck, date, category, freeDeli);
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		String query = "select * from menu_item \r\n" + "where  id=? ;";
		Connection con = ConnectionHandler.getConnection();
		MenuItem menuItem = null;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getInt("id");
				String name = rs.getString("Name");
				float price = rs.getInt("Price");
				String active = rs.getString("Active");
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String freeDelivery = rs.getString("Free_Delivery");
				boolean activeCheck = false;
				if (active.equalsIgnoreCase("Yes")) {
					activeCheck = true;
				}
				boolean freeDeli = false;
				if (freeDelivery.equalsIgnoreCase("Yes")) {
					freeDeli = true;
				}
				menuItem = new MenuItem(id, name, price, activeCheck, date, category, freeDeli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItem;

	}

	public void editMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		String query = "update  menu_item\r\n"
				+ "set Name=?,Price=?,Active=?,Date_of_Launch=?,Category=?,Free_Delivery=?\r\n" + "where id=?;";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			boolean active = menuItem.isActive();
			String activeValue = "No";
			if (active) {
				activeValue = "Yes";
			}
			ps.setString(3, activeValue);
			ps.setDate(4, (java.sql.Date) menuItem.getDateOfLaunch());
			ps.setString(5, menuItem.getCategory());
			boolean free = menuItem.isFreeDelivery();
			String freeValue = "No";
			if (active) {
				freeValue = "Yes";
			}
			ps.setString(6, freeValue);
			ps.setLong(7, menuItem.getId());
			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
	}

}