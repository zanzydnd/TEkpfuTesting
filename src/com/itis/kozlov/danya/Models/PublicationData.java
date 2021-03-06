package com.itis.kozlov.danya.Models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

@Data
@Builder
@AllArgsConstructor
/*@Getter
@Setter*/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PublicationData {
    private String name;
    private String rusAnnotation;
    private String enAnnotation;
    private Integer scienceAreaId;
    private String keyWords;
    private String notInSystemAuthors;
    private String file;
    private String doi;

    public PublicationData(){
        this.name = "Тестирование";
        this.rusAnnotation = "Для полного счастья и гармонии в душе";
        this.enAnnotation = "For happiness and balance in life";
        this.keyWords = "Любовь, математика, голуби";
        this.notInSystemAuthors = "Автор1, Автор2";
        this.file = "text.txt";
        this.doi = "http://doi.com/";
    }

    public PublicationData(String name, String rusAnnotation, String enAnnotation, String keyWords, String notInSystemAuthors, String file,String doi){
        this.name = name;
        this.rusAnnotation = rusAnnotation;
        this.enAnnotation = enAnnotation;
        this.keyWords = keyWords;
        this.notInSystemAuthors = notInSystemAuthors;
        this.file = file;
        this.doi = doi;
    }


    public static PublicationData getInstance(){
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        Faker faker = new Faker();

        String doi = "https://" + faker.company().url();
        String name = faker.funnyName().name();
        String rusAnnot = faker.howIMetYourMother().quote();
        String enAnnot = faker.friends().quote();
        String authors = faker.howIMetYourMother().character() + ", " + faker.friends().character();
        String keyWords = faker.animal().name()+ ", " + faker.ancient().hero();
        String file = "text.pdf";

        return new PublicationData(name,rusAnnot,enAnnot,keyWords,authors,file,doi);
    }
}
