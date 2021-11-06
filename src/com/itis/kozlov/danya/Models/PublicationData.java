package com.itis.kozlov.danya.Models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
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
}
