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


import pojo.DorAdminInfo;

public class DorAdminInfoDao {
	
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/dbdormitory?"
			+ "user=root&password=12345&useSSL=false&characterEncoding=utf-8"
			;
	

	
	
	//鐧诲綍
	public static boolean checkLogin(String username,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		boolean ifLogin=false;	
		try {
			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_admin where dor_ad_id=? and password=?");
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
	
	//妯＄硦璇诲彇鍏朵腑涓�缁�
	public static List<DorAdminInfo> readOneList2(String name , String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorAdminInfo> list=new ArrayList<DorAdminInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_admin where "+ name +" like ?");
			ps.setString(1, "%"+value+"%");
			/*System.out.println(ps.toString());*/
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				String dor_ad_id=rs.getString("dor_ad_id");
				String dor_ad_phone=rs.getString("dor_ad_phone");
				String dor_id=rs.getString("dor_id");
				String password=rs.getString("password");
				
				DorAdminInfo dg=new DorAdminInfo(dor_ad_id,password,dor_id,dor_ad_phone);
				list.add(dg);		
			}
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
		return list;
	}
	
	//璇诲彇鍏朵腑涓�缁�
	public static List<DorAdminInfo> readOneList(String name , String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorAdminInfo> list=new ArrayList<DorAdminInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_admin where "+ name +" = ?");
			ps.setString(1, value);
			/*System.out.println(ps.toString());*/
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				String dor_ad_id=rs.getString("dor_ad_id");
				String dor_ad_phone=rs.getString("dor_ad_phone");
				String dor_id=rs.getString("dor_id");
				String password=rs.getString("password");
				
				DorAdminInfo dg=new DorAdminInfo(dor_ad_id,password,dor_id,dor_ad_phone);
				list.add(dg);		
			}
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
		return list;
	}
	//璇诲彇
	public static List<DorAdminInfo> readList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorAdminInfo> list=new ArrayList<DorAdminInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_admin");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String dor_ad_id=rs.getString("dor_ad_id");
				String dor_ad_phone=rs.getString("dor_ad_phone");
				String dor_id=rs.getString("dor_id");
				String password=rs.getString("password");
				
				DorAdminInfo dg=new DorAdminInfo(dor_ad_id,password,dor_id,dor_ad_phone);
				list.add(dg);		
			}
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
		return list;
	}
	
	// 娣诲姞
	@SuppressWarnings("static-access")
	public static void insert(String stu_id, String password, String name, String department) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("insert into stu_info values(?,?,?,?,?,?,?,?)");
			ps.setString(1, stu_id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, name);
			
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	//鍒犻櫎
	public static void delete(String id){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("delete from dor_ad_info where dor_ad_id=?");
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ResultSet  Search(String sql, String str[]) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
        try {
        	Class.forName(driverName);
			conn = DriverManager.getConnection(url);
            ps =conn.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    ps.setString(i + 1, str[i]);
                }
            }
            rs = ps.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
	
	public int AddU(String sql, String str[]) {
        int a = 0;
        Connection conn = null;
		PreparedStatement ps = null;
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
        }
        return a;
    }

}
	
