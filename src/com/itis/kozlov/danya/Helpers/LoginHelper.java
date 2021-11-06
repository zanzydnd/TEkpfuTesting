package com.itis.kozlov.danya.Helpers;

import com.itis.kozlov.danya.ApplicationManager;
import com.itis.kozlov.danya.Models.AuthenticationData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager){
        super(applicationManager);

    }

    public void login(AuthenticationData authData) throws Exception {
        this.applicationManager.getNavigation().goToLoginUrl();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(authData.getUsername());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(authData.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
