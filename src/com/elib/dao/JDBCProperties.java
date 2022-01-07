package com.elib.dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCProperties {
	
	public static String driverClass = null;
	public static String url = null;
	public static String username = null;
	public static String password = null;
	static Connection con;
	
	public static void loadProperties() {
		
		
		
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\training\\java\\JspTest\\resources\\database.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			driverClass = prop.getProperty("MySQLJdbc.driver");
			url = prop.getProperty("MySQLJdbc.url");;
			username = prop.getProperty("MySQLJdbc.user");
			password = prop.getProperty("MySQLJdbc.pass");
			prop.clear();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			loadProperties();
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		JDBCProperties.loadProperties();
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		Connection con = getConnection();
		System.out.println("Connection : "+con);
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}