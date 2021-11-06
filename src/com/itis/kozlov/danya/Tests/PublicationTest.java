package com.itis.kozlov.danya.Tests;


import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.Test;

public class PublicationTest extends TestBase {

    @Test
    public void testCreation() throws Exception {
        this.app.getAuth().login(new AuthenticationData("imtester@mail.com", "test123test"));
        this.app.getPublication().createPublication(new PublicationData("Тестирование",
                "Для полного счастья и гармонии в душе", "For happiness and balance in life",
                "Любовь, математика, голуби", "Автор1, Автор2", "text.txt",
                "http://doi.com/"));
    }

}
