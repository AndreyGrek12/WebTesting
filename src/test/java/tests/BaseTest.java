package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


 class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void installDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
    }

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void closeChrome() {
        driver.close();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}


