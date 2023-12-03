package WEB;

import WEB.WEBpages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_01_Login extends WEBpages {


    @Test
    public void VerifyTheSuccessLogin() throws Exception {
        successLogin();

    }

    @AfterClass
    public void after() throws Exception{
        driver.close();
    }

}