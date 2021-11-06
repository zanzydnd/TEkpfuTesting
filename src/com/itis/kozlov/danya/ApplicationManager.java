package com.itis.kozlov.danya;

import com.itis.kozlov.danya.Helpers.LoginHelper;
import com.itis.kozlov.danya.Helpers.NavigationHelper;
import com.itis.kozlov.danya.Helpers.PublicationHelper;
import lombok.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Data
@Getter
@Setter
public class ApplicationManager {

    private JavascriptExecutor js;
    private ChromeDriver driver;
    private StringBuilder verificationErrors;
    private String baseUrl;

    private NavigationHelper navigation;
    private LoginHelper auth;
    private PublicationHelper publication;


    public ApplicationManager(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://te.kpfu.ru/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

        navigation = new NavigationHelper(this, this.baseUrl);
        auth = new LoginHelper(this);
        publication = new PublicationHelper(this);
    }

    public void stop(){
        driver.quit();
    }
}