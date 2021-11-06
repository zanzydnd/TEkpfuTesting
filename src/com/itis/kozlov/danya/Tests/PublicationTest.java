package com.itis.kozlov.danya.Tests;


import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.Test;

public class PublicationTest extends TestBase {

    @Test
    public void testCreation() throws Exception{
        this.app.getAuth().login(new AuthenticationData());
        this.app.getPublication().createPublication(new PublicationData());
    }

}
