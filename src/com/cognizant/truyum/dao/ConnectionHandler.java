package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("c:\\890049\\truyum\\src\\connection.properties"));
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/truYum_sql", props);

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return con;
	}

}
