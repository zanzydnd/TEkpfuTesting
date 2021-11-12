package com.itis.kozlov.danya.Tests;


import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.Assert;
import org.junit.Test;

public class PublicationTest extends TestBase {

    @Test
    public void testCreation() throws Exception {
        //this.app.getAuth().login(new AuthenticationData("imtester@mail.com", "test123test"));
        PublicationData data = new PublicationData("Тестирование",
                "Для полного счастья и гармонии в душе", "For happiness and balance in life",
                "Любовь, математика, голуби", "Автор1, Автор2", "text.pdf",
                "http://doi.com/");
        this.app.getPublication().createPublication(data);

        this.app.getPublication().openLastPublicationLink();

        PublicationData newData = this.app.getPublication().getPublicationData();

        Assert.assertEquals(data.getDoi(), newData.getDoi());
        Assert.assertEquals(data.getName(), newData.getName());
        Assert.assertEquals(data.getRusAnnotation(), newData.getRusAnnotation());
        Assert.assertEquals(data.getEnAnnotation(), newData.getEnAnnotation());
        Assert.assertEquals(data.getKeyWords(), newData.getKeyWords());
    }


    @Test
    public void testChange() throws Exception{
        PublicationData data = new PublicationData();
        data.setName("Изменения");
        data.setDoi("http://doi.com/");
        data.setKeyWords("Любовь, математика, голуби, изменения");
        data.setRusAnnotation("All changed");
        data.setEnAnnotation("All changed");
        data.setNotInSystemAuthors("Автор1, Автор2, все поменялось");


        app.getPublication().editData(data);
        PublicationData newData = app.getPublication().getPublicationData();


        Assert.assertEquals(data.getDoi(), newData.getDoi());
        Assert.assertEquals(data.getName(), newData.getName());
        Assert.assertEquals(data.getRusAnnotation(), newData.getRusAnnotation());
        Assert.assertEquals(data.getEnAnnotation(), newData.getEnAnnotation());
        Assert.assertEquals(data.getKeyWords(), newData.getKeyWords());
    }

}
