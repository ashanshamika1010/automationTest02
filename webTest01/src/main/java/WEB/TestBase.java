package WEB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static long WAIT = 1000;


    public WebDriver getChromeDriver() throws Exception {
        try {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        } catch (Exception e) {
            System.out.println(e);
        }
        return driver;
    }


    public void openPage(String url) throws Exception {
        try {
            driver.get(url);
        } catch (Exception e) {
            throw new AssertionError("Login page is not displayed.");
        }
    }

    public By getLocator(String locatorValue) throws Exception {
        By findLocator = null;

        if (locatorValue.indexOf("_Id") > -1) {
            findLocator = By.id(locatorValue.replaceAll("_Id", "").trim());
        } else if (locatorValue.indexOf("_Xpath") > -1 || locatorValue.indexOf("_") > -1) {
            findLocator = By.xpath(locatorValue.replaceAll("_Xpath", "").replaceAll("_xpath", "").trim());
        } else {
            findLocator = By.xpath(locatorValue.trim());
        }
        return findLocator;
    }

    public boolean click(String locator) throws Exception {
        boolean clickLink = true;
        try {
            driver.findElement(getLocator(locator)).click();
            Thread.sleep(WAIT * 1);

        } catch (Exception e) {
            clickLink = false;
        }
        return clickLink;
    }

    public boolean sendKeys(String locator, String value) throws Exception {
        boolean sendKey = true;
        try {
            driver.findElement(getLocator(locator)).clear();
            driver.findElement(getLocator(locator)).click();
            driver.findElement(getLocator(locator)).sendKeys(value);
        } catch (Exception e) {
            //errorLogs("Exception" + e.getMessage());
            sendKey = false;
        }
        return sendKey;
    }

    public String getText(String locator) throws Exception {

        String textValue = "";
        try {
            textValue = driver.findElement(getLocator(locator)).getText().trim();
        } catch (Exception e) {
           //errorLogs("Exception" + e.getMessage());
        }
        return textValue;
    }

    public boolean isDisplayed(String locator) throws Exception {

        boolean found = false;
        int tries = 0;

        while (!found && tries < 5) {
            tries += 1;
            try {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                if (driver.findElement(getLocator(locator)).isDisplayed()) {
                    found = true; // FOUND IT
                    break;
                } else {
                    Thread.sleep(200);

                }
            } catch (Exception e) {
                found = false;
            }
        }
        if (!found) {
            //errorLogs("Locator " + locator + " Element is not displyed");
        }
        return found;
    }

    public void pageRefersh() throws Exception {
        driver.navigate().refresh();

    }


}
