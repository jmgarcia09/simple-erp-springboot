package com.gitlab.adilcan.erp;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = ErpApplication.class, loader = SpringBootContextLoader.class)
    public class SpringIntegrationTest {

    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //@Before
    public void setUp() throws Exception {
        if(driver == null){
            //System.out.println(WebDriverManager.chromedriver().getVersions());
            //WebDriverManager.chromedriver().version("77.0.3865.40").setup();
            //driver = new ChromeDriver();
            //DesiredCapabilities capability = DesiredCapabilities.chrome();
            //driver = new RemoteWebDriver(new URL("http://192.168.99.101:4444/wd/hub"), capability);
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");

            driver = new ChromeDriver(chromeOptions);
            baseUrl = "https://www.katalon.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    //@After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public synchronized  WebDriver getDriver() throws Exception {
        setUp();
        return driver;
    }
}
