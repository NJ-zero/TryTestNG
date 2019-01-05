package LoginData;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @Description:
 */
public class LoginParams {


    /**
     * 提供用户登陆测试方法数据
     * @return
     */
    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]{
                {"zhangsan","123456","欢迎zhangsan"},
                {"lisi","","用户名或密码不能为空"},
                {"","","用户名或密码不能为空"},
                {"admin","123456","欢迎管理员"}
        };
    }

    @DataProvider
    public Object[][] buy(){
        return new Object[][]{
                {"lisi","","用户名或密码不能为空",1,1,-2},
                {"admin","123456","欢迎管理员",1,-1,-1},
                {"zhangsan","123456","欢迎zhangsan",2,2,1}
        };
    }
    @DataProvider
    public Object[][] dataMethod(){
        List<Map<String, String>> result = ReadExcelUtil.getExcuteList("E:\\Xunit\\src\\test\\java\\LoginData\\bug.xlsx");
        Object[][] files = new Object[result.size()][];
        for(int i=0; i<result.size(); i++){
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }
//    @Test(dataProvider = "testData")
//    public void testCase(HashMap<String, String> data) {
//        System.out.println(data);
//        String name = data.get("name");
//        System.out.println(name);
//        int proid = Integer.parseInt(data.get("proid"));
//        System.out.println(proid);
//    }
//    @DataProvider
//    public Object[][] getUsers(){
//        return new Object[][]{
//                {"","","用户名或密码不能为空"},
//                {"login","","用户名或密码不能为空"},
//                {"","123456","用户名或密码不能为空"},
//                {"admin","admin","欢迎管理员"},
////                {"","","用户名或密码不能为空"}
//                {"login","123456","欢迎login"}
//        };
//    }
}
