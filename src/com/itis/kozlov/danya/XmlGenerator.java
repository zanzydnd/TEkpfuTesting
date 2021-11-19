package com.itis.kozlov.danya;

import com.itis.kozlov.danya.Models.PublicationData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlGenerator {


    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(PublicationData.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /*String fileName = args[0];
        String fileExtention = args[1];*/
        marshallerObj.marshal(PublicationData.getInstance(),new FileOutputStream("first_try.xml"));
    }

}
