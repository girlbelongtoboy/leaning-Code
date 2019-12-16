package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.DorAdminInfo;
import pojo.WaterAndElectricityFare;

public class MysqlUtil {
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/dbdormitory?"
			+ "user=root&password=12345&useSSL=false&characterEncoding=utf-8";
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public static int AddU(String sql, String str[]) {
		int a = 0;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement(sql);
			
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			a = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return a;
	}
	
	public static int AddU2(String sql, int str[]) {
		int a = 0;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setInt(i + 1, str[i]);
				}
			}
			a = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return a;
	}
	
}
