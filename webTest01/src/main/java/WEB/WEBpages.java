package WEB;

import org.testng.Assert;

public class WEBpages extends WEBdata {


    public void successLogin() throws Exception {
        getChromeDriver();
        openPage(siteUrl);
        Thread.sleep(1000);

        for (int i=0; i< 2;i++){
            Thread.sleep(1000);
            String[] users = {username01,username02};
            sendKeys(txt_username,users[i]);
            Thread.sleep(1000);
            sendKeys(txt_password,password);
            click(btn_login);
            Thread.sleep(1000);
            String systemTitle = getText(txt_homelogo);
            Assert.assertEquals(title,systemTitle);
            Thread.sleep(1000);
            click(btn_navi);
            Thread.sleep(1000);
            click(btn_LogOut);

        }

    }

    public void InvalidLoginScenarios() throws Exception {
        getChromeDriver();
        openPage(siteUrl);

        for (int i=0; i< 3;i++){
            Thread.sleep(1000);
            String[] users = {invUser01,invUser02,invUser03};
            sendKeys(txt_username,users[i]);
            Thread.sleep(1000);
            sendKeys(txt_password,password);
            click(btn_login);

            if(isDisplayed(txt_errorMsg)){
                System.out.println("Error message displayed when user enter invalid user name or password");

            }else{
                System.out.println("Error message not displayed when user enter invalid user name or password");
                break;
            }
            pageRefersh();
            Thread.sleep(1000);


        }


    }



}
