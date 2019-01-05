package TestXunit;

import DemoXunit.Login;
import DemoXunit.Products;
import DemoXunit.Shopping;
import LoginData.DataParams;
import LoginData.LoginParams;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

/**
 * Created by duzhe on 2018/12/23.
 *
 * @Description:
 */
public class ShoppingTest {


    Login login = new Login();
    Shopping shopping = new Shopping();

    @BeforeClass
    public void beforeMethod(){
//        login.userLogin("zhangsan","123456");
        Products.getPro(1).setCount(0);
        Products.getPro(2).setCount(10);
        Products.getPro(3).setCount(1);
    }

    @Test(dataProvider = "buy",dataProviderClass = LoginParams.class)
    public void testBuy(String name1, String pwd1, String expect1,int proId,int num, int expect){
        String s = login.userLogin(name1,pwd1);
        Assert.assertEquals(s,expect1);
        int res = shopping.buys(proId,num);
        Assert.assertEquals(res,expect);
    }
    @Test(dataProvider = "dataMethod",dataProviderClass = LoginParams.class)
    public void testBuy2(HashMap<String,String> data){
        System.out.println(data.get("name")+data.get("pwd"));
        String s = login.userLogin(data.get("name"),data.get("pwd"));
        Assert.assertEquals(s,data.get("exp"));
        int pro = Integer.parseInt(data.get("pro").substring(0,(data.get("pro").length()-2)));
        int buynum = Integer.parseInt(data.get("num").substring(0,(data.get("num").length()-2)));
        int res = shopping.buys(pro,buynum);
        int exp = Integer.parseInt(data.get("res").substring(0,(data.get("res").length()-2)));
        Assert.assertEquals(res,exp);
    }


//    @AfterClass
//    public void AfterMethod(){
//        login.userLogin("","");
//    }
}
