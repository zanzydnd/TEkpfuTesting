package com.itis.kozlov.danya.Tests;

import com.itis.kozlov.danya.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager app;


    @Before
    public void setUp() throws Exception {
        this.app = ApplicationManager.getInstance();
    }

}
