package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import pojo.Admin;

public class AdminDao {
	
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/dbdormitory?"
			+ "user=root&password=12345&useSSL=false&characterEncoding=utf-8";
	
		//登录
		public static boolean checkLogin(String username,String password) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			boolean ifLogin=false;	
			try {
				
				Class.forName(driverName);
				conn = DriverManager.getConnection(url);
				ps = conn.prepareStatement("select * from admin where ad_id=? and password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();	
				if(rs.next()) ifLogin=true;
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			return ifLogin;
		
		}
	
}
	
