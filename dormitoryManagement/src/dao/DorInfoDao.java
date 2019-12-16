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


import pojo.DorInfo;

public class DorInfoDao {
	
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/dbdormitory?"
			+ "user=root&password=12345&useSSL=false&characterEncoding=utf-8"
			;
	

	
	
	
	//璇诲彇鍏朵腑涓�缁�
	public static List<DorInfo> readOneList2(String name ,String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorInfo> list=new ArrayList<DorInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_info where "+ name + " like ?"); 
			ps.setString(1, "%"+value+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String dor_id=rs.getString("dor_id");
				String dor_phone=rs.getString("dor_phone");
				String resident_num=rs.getString("resident_num");
				String occupied_num=rs.getString("occupied_num");
				
				DorInfo dg=new DorInfo(dor_id,dor_phone,resident_num,occupied_num);
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
	public static List<DorInfo> readOneList(String name ,String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorInfo> list=new ArrayList<DorInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_info where "+ name +" = " +value);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String dor_id=rs.getString("dor_id");
				String dor_phone=rs.getString("dor_phone");
				String resident_num=rs.getString("resident_num");
				String occupied_num=rs.getString("occupied_num");
				
				DorInfo dg=new DorInfo(dor_id,dor_phone,resident_num,occupied_num);
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
	public static List<DorInfo> readList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<DorInfo> list=new ArrayList<DorInfo>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from dor_info");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String dor_id=rs.getString("dor_id");
				String dor_phone=rs.getString("dor_phone");
				String resident_num=rs.getString("resident_num");
				String occupied_num=rs.getString("occupied_num");
				
				DorInfo dg=new DorInfo(dor_id,dor_phone,resident_num,occupied_num);
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
			ps = conn.prepareStatement("delete from dor_info where stu_id=?");
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
	
