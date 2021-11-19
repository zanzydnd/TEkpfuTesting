package com.itis.kozlov.danya.Tests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.kozlov.danya.Models.AuthenticationData;
import com.itis.kozlov.danya.Models.PublicationData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class PublicationTest extends TestBase {
    private PublicationData publicationData;

    public PublicationTest(PublicationData data) {
        this.publicationData = data;
    }

    @Parameterized.Parameters
    public static Iterable<PublicationData> groupDataFromXml() throws IOException, JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(PublicationData.class);
        Unmarshaller unmarshaller = contextObj.createUnmarshaller();
        return Collections.singletonList((PublicationData) unmarshaller.unmarshal(new File("/Users/dane4kq/IdeaProjects/TEkpfuTesting/first_try.xml")));
    }


    @Test
    public void testCreation() throws Exception {
        //this.app.getAuth().login(new AuthenticationData("imtester@mail.com", "test123test"));
        /*PublicationData data = new PublicationData("Тестирование",
                "Для полного счастья и гармонии в душе", "For happiness and balance in life",
                "Любовь, математика, голуби", "Автор1, Автор2", "text.pdf",
                "http://doi.com/")*/
        ;
        this.app.getPublication().createPublication(publicationData);

        this.app.getPublication().openLastPublicationLink();

        PublicationData newData = this.app.getPublication().getPublicationData();

        Assert.assertEquals(publicationData.getDoi(), newData.getDoi());
        Assert.assertEquals(publicationData.getName(), newData.getName());
        Assert.assertEquals(publicationData.getRusAnnotation(), newData.getRusAnnotation());
        Assert.assertEquals(publicationData.getEnAnnotation(), newData.getEnAnnotation());
        Assert.assertEquals(publicationData.getKeyWords(), newData.getKeyWords());
    }


    @Test
    public void testChange() throws Exception {
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
