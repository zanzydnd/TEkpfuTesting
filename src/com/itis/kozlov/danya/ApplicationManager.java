package com.itis.kozlov.danya;

import com.itis.kozlov.danya.Helpers.LoginHelper;
import com.itis.kozlov.danya.Helpers.NavigationHelper;
import com.itis.kozlov.danya.Helpers.PublicationHelper;
import static com.itis.kozlov.danya.SettingsWrapper.Settings;
import lombok.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
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
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    private ApplicationManager() throws Exception {
        Settings.init();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        baseUrl = Settings.baseURL;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;

        navigation = new NavigationHelper(this, this.baseUrl);
        auth = new LoginHelper(this);
        publication = new PublicationHelper(this);
    }

    public void stop(){
        driver.quit();
    }

    public static ApplicationManager getInstance() throws Exception {
        if(app.get() == null){
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

    protected void finalize() throws Throwable{
            driver.quit();
    }
}
