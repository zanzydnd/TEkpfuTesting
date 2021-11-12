package com.itis.kozlov.danya.Tests;


import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.Assert;
import org.junit.Test;

public class PublicationTest extends TestBase {

    @Test
    public void testCreation() throws Exception {
        this.app.getAuth().login(new AuthenticationData("imtester@mail.com", "test123test"));
        PublicationData data = new PublicationData("Тестирование",
                "Для полного счастья и гармонии в душе", "For happiness and balance in life",
                "Любовь, математика, голуби", "Автор1, Автор2", "text.txt",
                "http://doi.com/");
        this.app.getPublication().createPublication(data);

        PublicationData newData = this.app.getPublication().getPublicationData();

        Assert.assertEquals(data.getDoi(), newData.getDoi());
        Assert.assertEquals(data.getName(), newData.getName());
        Assert.assertEquals(data.getRusAnnotation(), newData.getRusAnnotation());
        Assert.assertEquals(data.getEnAnnotation(), newData.getEnAnnotation());
        Assert.assertEquals(data.getKeyWords(), newData.getKeyWords());
    }

}
