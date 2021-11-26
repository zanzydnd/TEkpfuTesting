package com.itis.kozlov.danya.Tests;

import com.itis.kozlov.danya.ApplicationManager;
import com.itis.kozlov.danya.Models.AuthenticationData;
import static com.itis.kozlov.danya.SettingsWrapper.Settings;
import org.junit.Before;
import org.junit.BeforeClass;

public class AuthBase extends TestBase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.app.getAuth().login(new AuthenticationData(Settings.login,
                Settings.password));
        this.app.getNavigation().goToBaseURL();
    }
}
