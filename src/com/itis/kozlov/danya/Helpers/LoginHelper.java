package com.itis.kozlov.danya.Helpers;

import com.itis.kozlov.danya.ApplicationManager;
import com.itis.kozlov.danya.Models.AuthenticationData;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class LoginHelper extends HelperBase {

    private static Map<String, Boolean> loggedUsers = new HashMap<>();
    private static boolean currentState = false;


    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);

    }

    public boolean isLoggedIn() {
//        this.applicationManager.getNavigation().goToCabinet();
//
//        String cur_url = this.applicationManager.getDriver().getCurrentUrl();
//        return !cur_url.contains("login");

        return currentState;
    }

    public boolean isLoggedIn(String username) {
        try {
            return loggedUsers.get(username);
        } catch (Exception e){
            return false;
        }
    }


    public void login(AuthenticationData authData) throws Exception {
        if (isLoggedIn()) {
            if (isLoggedIn(authData.getUsername())) {
                return;
            }
            logout();
        }

        this.applicationManager.getNavigation().goToLoginUrl();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(authData.getUsername());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(authData.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        currentState = true;
        for (String key : loggedUsers.keySet()) {
            if (loggedUsers.get(key)) {
                loggedUsers.put(key, false);
            }
        }
        loggedUsers.put(authData.getUsername(), true);

    }

    public void logout() {
        this.applicationManager.getNavigation().goToLogout();
    }
}
