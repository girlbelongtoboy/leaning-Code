package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.WaterAndElectricityFare;

public class WaterAndElectricityFareDao {
	
	private final static String driverName = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/dbdormitory?"
			+ "user=root&password=12345&useSSL=false&characterEncoding=utf-8"
			;
	
	//鑾峰彇value缂寸撼鐘舵�佺殑瀹胯垗鏁�
		public static int readCount(int value) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			int l = 0;
			
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url);
				ps = conn.prepareStatement("select * from water_and_electricity where is_pay = ?");
				ps.setInt(1, value);
				rs = ps.executeQuery();
				rs.last();
				l = rs.getRow();
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
			return l;
		}
		//璇诲彇name婊¤冻value鐨刲ist
		public static List<WaterAndElectricityFare> readOneList2(String name , String value) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<WaterAndElectricityFare> list=new ArrayList<WaterAndElectricityFare>();
			
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url);
				ps = conn.prepareStatement("select * from water_and_electricity where " + name + " like ? ");
				ps.setString(1, "%"+value+"%");
				rs = ps.executeQuery();
				
				while(rs.next()) {
					int bill_id = rs.getInt("bill_id");
					String dor_id=rs.getString("dor_id");
					String time=rs.getString("time");
					String water_consum=rs.getString("water_consum");
					String water_charge=rs.getString("water_charge");
					String electricity_consum=rs.getString("electricity_consum");
					String electricity_charge=rs.getString("electricity_charge");
					int is_pay = rs.getInt("is_pay");
					
					WaterAndElectricityFare dg=new WaterAndElectricityFare(bill_id,dor_id,time,water_consum,water_charge,electricity_consum,electricity_charge,is_pay);
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
	//璇诲彇name婊¤冻value鐨刲ist
	public static List<WaterAndElectricityFare> readOneList(String name , String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<WaterAndElectricityFare> list=new ArrayList<WaterAndElectricityFare>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from water_and_electricity where " + name + " = " + value);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bill_id = rs.getInt("bill_id");
				String dor_id=rs.getString("dor_id");
				String time=rs.getString("time");
				String water_consum=rs.getString("water_consum");
				String water_charge=rs.getString("water_charge");
				String electricity_consum=rs.getString("electricity_consum");
				String electricity_charge=rs.getString("electricity_charge");
				int is_pay = rs.getInt("is_pay");
				
				WaterAndElectricityFare dg=new WaterAndElectricityFare(bill_id,dor_id,time,water_consum,water_charge,electricity_consum,electricity_charge,is_pay);
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
	public static List<WaterAndElectricityFare> readList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<WaterAndElectricityFare> list=new ArrayList<WaterAndElectricityFare>();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			ps = conn.prepareStatement("select * from water_and_electricity");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bill_id = rs.getInt("bill_id");
				String dor_id=rs.getString("dor_id");
				String time=rs.getString("time");
				String water_consum=rs.getString("water_consum");
				String water_charge=rs.getString("water_charge");
				String electricity_consum=rs.getString("electricity_consum");
				String electricity_charge=rs.getString("electricity_charge");
				int is_pay = rs.getInt("is_pay");
				
				WaterAndElectricityFare dg=new WaterAndElectricityFare(bill_id,dor_id,time,water_consum,water_charge,electricity_consum,electricity_charge,is_pay);
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
			ps = conn.prepareStatement("insert into water_and_electricity values(?,?,?,?,?,?,?,?)");
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
			ps = conn.prepareStatement("delete from water_and_electricity where dor_ad_id=?");
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
	
