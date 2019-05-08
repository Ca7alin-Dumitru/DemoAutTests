package pageobject;

import org.testng.annotations.DataProvider;

public class DataProviderForLoginTests {

    @DataProvider(name="loginValues")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "", "" },
                        { "User123", "Pass123" }
                };

    }
}
