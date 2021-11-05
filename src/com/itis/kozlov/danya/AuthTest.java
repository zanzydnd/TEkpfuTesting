package com.itis.kozlov.danya;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.itis.kozlov.danya.classes.AuthenticationData;
import com.itis.kozlov.danya.classes.PublicationData;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class AuthTest extends TestBase{

    @Test
    public void test() throws Exception {
        login(new AuthenticationData());
    }

    @Test
    public void testCreation() throws Exception{
        login(new AuthenticationData());
        createPublication(new PublicationData());
    }
}
