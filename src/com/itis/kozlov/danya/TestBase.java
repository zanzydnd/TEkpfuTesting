package com.itis.kozlov.danya;

import com.itis.kozlov.danya.classes.AuthenticationData;
import com.itis.kozlov.danya.classes.PublicationData;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    public void goToBaseURL(){
        driver.get("https://te.kpfu.ru/");
    }



    public void login(AuthenticationData authData) throws Exception {
        driver.get("https://te.kpfu.ru/login/");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(authData.getUsername());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(authData.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void createPublication(PublicationData data){

        driver.get("https://te.kpfu.ru/publications/create/");

        driver.findElement(By.id("topic")).click();
        driver.findElement(By.id("topic")).clear();
        driver.findElement(By.id("topic")).sendKeys(data.getName());

        driver.findElement(By.id("annotation_rus")).click();
        driver.findElement(By.id("annotation_rus")).clear();
        driver.findElement(By.id("annotation_rus")).sendKeys(data.getRusAnnotation());

        driver.findElement(By.id("annotation_en")).click();
        driver.findElement(By.id("annotation_en")).clear();
        driver.findElement(By.id("annotation_en")).sendKeys(data.getEnAnnotation());

        Select project = new Select(driver.findElement(By.id("project")));
        project.selectByIndex(1);

        Select scArea = new Select(driver.findElement(By.id("area")));
        scArea.selectByIndex(2);

        driver.findElement(By.id("words")).click();
        driver.findElement(By.id("words")).clear();
        driver.findElement(By.id("words")).sendKeys(data.getKeyWords());

        driver.findElement(By.id("authors")).click();
        driver.findElement(By.id("authors")).clear();
        driver.findElement(By.id("authors")).sendKeys(data.getNotInSystemAuthors());

        driver.findElement(By.id("file")).sendKeys(data.getFile());

        driver.findElement(By.id("doi")).click();
        driver.findElement(By.id("doi")).clear();
        driver.findElement(By.id("doi")).sendKeys(data.getDoi());


        driver.findElement(By.id("btn_submit")).click();
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
