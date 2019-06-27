package pageobject;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

public class DataProviderForLoginTests {

    @Step
    @DataProvider(name="loginValues")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "", "" },
                        { "User123", "Pass123" }
                };

    }
}
