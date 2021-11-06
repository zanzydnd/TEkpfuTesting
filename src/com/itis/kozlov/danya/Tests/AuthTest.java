package com.itis.kozlov.danya.Tests;

import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.*;

public class AuthTest extends TestBase {
    @Test
    public void test() throws Exception {
        this.app.getAuth().login(new AuthenticationData());
    }
}
