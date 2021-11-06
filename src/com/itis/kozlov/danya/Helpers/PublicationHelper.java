package com.itis.kozlov.danya.Helpers;

import com.itis.kozlov.danya.ApplicationManager;
import com.itis.kozlov.danya.Models.PublicationData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PublicationHelper extends HelperBase {

    public PublicationHelper(ApplicationManager applicationManager) {
        super(applicationManager);

    }

    public void createPublication(PublicationData data){

        this.applicationManager.getNavigation().goToPublicationCreationUrl();
        driver.findElement(By.id("topic")).click();
        driver.findElement(By.id("topic")).clear();
        driver.findElement(By.id("topic")).sendKeys(data.getName());

        driver.findElement(By.id("annotation_rus")).click();
        driver.findElement(By.id("annotation_rus")).clear();
        driver.findElement(By.id("annotation_rus")).sendKeys(data.getRusAnnotation());

        driver.findElement(By.id("annotation_en")).click();
        driver.findElement(By.id("annotation_en")).clear();
        driver.findElement(By.id("annotation_en")).sendKeys(data.getEnAnnotation());

        Select project = new Select(driver.findElement(By.id("project")));
        project.selectByIndex(1);

        Select scArea = new Select(driver.findElement(By.id("area")));
        scArea.selectByIndex(2);

        driver.findElement(By.id("words")).click();
        driver.findElement(By.id("words")).clear();
        driver.findElement(By.id("words")).sendKeys(data.getKeyWords());

        driver.findElement(By.id("authors")).click();
        driver.findElement(By.id("authors")).clear();
        driver.findElement(By.id("authors")).sendKeys(data.getNotInSystemAuthors());
        driver.findElement(By.id("file")).sendKeys(System.getProperty("user.dir") + "/" + data.getFile());

        driver.findElement(By.id("doi")).click();
        driver.findElement(By.id("doi")).clear();
        driver.findElement(By.id("doi")).sendKeys(data.getDoi());


        driver.findElement(By.id("btn_submit")).click();
    }

}
