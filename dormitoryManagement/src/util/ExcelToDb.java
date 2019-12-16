package util;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import jxl.Workbook;
import pojo.StuInfo;
import jxl.Sheet;
import dao.*;

public class ExcelToDb {
    public static int excelToDb() {
    	int i = -1 ;
        //寰楀埌琛ㄦ牸涓墍鏈夌殑鏁版嵁
        List< StuInfo > listExcel=ExcelToDb.getAllByExcel("c://stuInfo.xls");
        /*//寰楀埌鏁版嵁搴撹〃涓墍鏈夌殑鏁版嵁
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        StudentInfoDao db=new StudentInfoDao();
        
        for (StuInfo stuEntity : listExcel) {
            String id=stuEntity.getStu_id();
            if (!isExist(id)) {
            
                String sql="insert into stu_info values(?,?,?,?,?,?,?,?)";
                String[] str=new String[]{id,stuEntity.getPassword(),stuEntity.getDor_id(),stuEntity.getName(),stuEntity.getSex(),stuEntity.getDepartment(),stuEntity.getStu_class(),stuEntity.getStu_phone()};
                i = db.AddU(sql, str);
            }else {
          
                String sql="update stu_info set password=?,dor_id=?,name=?,sex=?,department=?,stu_class=?,stu_phone=? where stu_id=?";
                String[] str=new String[]{stuEntity.getPassword(),stuEntity.getDor_id(),stuEntity.getName(),stuEntity.getSex(),stuEntity.getDepartment(),stuEntity.getStu_class(),stuEntity.getStu_phone(),id};
                i = db.AddU(sql, str);
            }
        }
        return i ;
    }
    public static List<StuInfo> getAllByExcel(String file){
        List<StuInfo> list=new ArrayList<StuInfo>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("stuInfo");//鎴栬�卹wb.getSheet(0)
            int clos=rs.getColumns();//寰楀埌鎵�鏈夌殑鍒�
            int rows=rs.getRows();//寰楀埌鎵�鏈夌殑琛�
            
            System.out.println("clos:"+clos+" rows:"+(rows-1));
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //绗竴涓槸鍒楁暟锛岀浜屼釜鏄鏁�
                    String stu_id=rs.getCell(j++, i).getContents();//榛樿鏈�宸﹁竟缂栧彿涔熺畻涓�鍒� 鎵�浠ヨ繖閲屽緱j++
                    String password=rs.getCell(j++, i).getContents();
                    String dor_id=rs.getCell(j++, i).getContents();
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String department=rs.getCell(j++, i).getContents();
                    String stu_class=rs.getCell(j++, i).getContents();
                    String stu_phone=rs.getCell(j++, i).getContents();
             
                    
                    System.out.println("学号:"+stu_id+"  密码:"+password+"  宿舍号:"+dor_id+"  姓名:"+name+"  性别:"+sex+"  所在系:"+department+"  班级:"+stu_class+"  联系方式:"+stu_phone);
                    list.add(new StuInfo(stu_id,password,dor_id,name,sex,department,stu_class,stu_phone
                			));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 閫氳繃Id鍒ゆ柇鏄惁瀛樺湪
     * @param id
     * @return
     */
    public static boolean isExist(String id){
        try {
        	StudentInfoDao db=new StudentInfoDao();
            ResultSet rs=db.Search("select * from stu_info where stu_id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
}
