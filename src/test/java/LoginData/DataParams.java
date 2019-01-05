package LoginData;

import org.testng.annotations.DataProvider;

public class DataParams {



    @DataProvider
    public Object[][] getProPrice(){
        return new Object[][]{
                {1,200},
                {0,-1},
                {3,80}
        };
    }

}
