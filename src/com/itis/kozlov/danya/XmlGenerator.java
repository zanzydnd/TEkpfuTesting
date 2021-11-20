package com.itis.kozlov.danya;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.kozlov.danya.Models.PublicationData;
import org.json.JSONArray;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlGenerator {


    public static void main(String[] args) throws IOException {
        List<PublicationData> list = new ArrayList<>();
        list.add(PublicationData.getInstance());
        list.add(PublicationData.getInstance());

        ObjectMapper mapper = new ObjectMapper();
        String toWrite = mapper.writeValueAsString(list);
        FileWriter writer = new FileWriter("/Users/dane4kq/IdeaProjects/TEkpfuTesting/first_try.json");
        writer.write(toWrite);
        writer.close();
    }

}
