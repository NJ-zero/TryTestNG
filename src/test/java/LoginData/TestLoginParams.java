package LoginData;

import org.testng.annotations.Test;

import java.util.Map;

public class TestLoginParams {
    @Test(dataProvider = "dataMethod")
    public void test(Map<?,?> param){
        System.out.println(param.get("name"));
    }
}
