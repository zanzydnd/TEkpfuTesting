package com.itis.kozlov.danya.Tests;

import com.itis.kozlov.danya.Models.AuthenticationData;
import static com.itis.kozlov.danya.SettingsWrapper.Settings;

import org.junit.*;

public class AuthTest extends TestBase {
//    @Test
//    public void test() throws Exception {
//        this.app.getAuth().login(new AuthenticationData(SettingsWrapper.Settings.login, SettingsWrapper.Settings.password));
//    }

    @Test
    public void loginWithValidData() throws Exception {
        this.app.getAuth().logout();
        this.app.getAuth().login(new AuthenticationData(Settings.login, Settings.password));
        String url = this.app.getDriver().getCurrentUrl();

        Assert.assertEquals(Settings.baseURL, url);
    }

    @Test
    public void loginWithInvalidData() throws Exception {
        this.app.getAuth().logout();
        this.app.getAuth().login(new AuthenticationData(Settings.login + "123123", Settings.password));
        String url = this.app.getDriver().getCurrentUrl();

        Assert.assertEquals(Settings.baseURL + "login/",url);
    }
}
