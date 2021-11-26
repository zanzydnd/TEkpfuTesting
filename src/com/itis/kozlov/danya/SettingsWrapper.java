package com.itis.kozlov.danya;

import jdk.internal.org.xml.sax.SAXException;
import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class SettingsWrapper {

    public static class Settings {
        public static String file = "/Users/dane4kq/IdeaProjects/TEkpfuTesting/Settings.xml";
        public static String baseURL;
        public static String login;
        public static String password;

        public static void init() throws Exception{
            System.out.println("Started");
            File settings_file = new File(file);

            if (settings_file.exists()) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                try {
                    dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(file);
                    NodeList list = doc.getElementsByTagName("customSettings");

                    for (int temp = 0; temp < list.getLength(); temp++) {

                        Node node = list.item(temp);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {

                            Element element = (Element) node;

                            baseURL = element.getElementsByTagName("baseUrl").item(0).getTextContent();
                            login = element.getElementsByTagName("login").item(0).getTextContent();
                            password = element.getElementsByTagName("password").item(0).getTextContent();


                        }
                    }
                } catch (ParserConfigurationException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new Exception("Settings file not found");
            }
        }
    }

}
