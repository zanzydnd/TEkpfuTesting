package com.itis.kozlov.danya.Helpers;

import com.itis.kozlov.danya.ApplicationManager;
import com.itis.kozlov.danya.Models.PublicationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PublicationHelper extends HelperBase {

    public PublicationHelper(ApplicationManager applicationManager) {
        super(applicationManager);

    }

    public void createPublication(PublicationData data) {

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


    public PublicationData getPublicationData() {

        System.out.println("hiiiiiiii");
        PublicationData data = new PublicationData();

        data.setName(driver.findElement(By.xpath("/html/body/div/section[1]/div/div/h2")).getText());
        System.out.println(1);
        data.setDoi(driver.findElement(By.xpath("/html/body/div/section[1]/div/div/div[2]/div/a")).getText());
        System.out.println(2);
        data.setEnAnnotation(driver.findElement(By.xpath("/html/body/div/section[2]/div/div/div[1]/div[2]/p")).getText());
        System.out.println(3);
        data.setRusAnnotation(driver.findElement(By.xpath("/html/body/div/section[2]/div/div/div[1]/div[1]/p")).getText());
        System.out.println(4);
        data.setKeyWords(driver.findElement(By.xpath("/html/body/div/section[2]/div/div/div[1]/div[3]/p")).getText());
        System.out.println(5);
        return data;
    }

    public String selectLastCreatedPublication() {
        this.applicationManager.getNavigation().goToPublicationsPage();
        String lastPublicationXPATH = "/html/body/div/form/div/div/div/div[1]/a[1]";
        System.out.println(driver.findElement(By.xpath(lastPublicationXPATH)).getAttribute("href"));
        return driver.findElement(By.xpath(lastPublicationXPATH)).getAttribute("href");
    }

    public void openLastPublicationLink() {
        applicationManager.getNavigation().goToPage(this.selectLastCreatedPublication());
    }


    public void openEditPage() {
        openLastPublicationLink();
        System.out.println(driver.findElement(
                By.xpath("/html/body/div/section[1]/div/div/div[4]/div[1]/a[2]")).getAttribute("href")
        );
        applicationManager.getNavigation().goToPage(driver.findElement(
                By.xpath("/html/body/div/section[1]/div/div/div[4]/div[1]/a[2]")).getAttribute("href")
        );
        System.out.println("im busted");
    }

    public void editData(PublicationData data) {
        this.applicationManager.getNavigation().goToPublicationsPage();
        System.out.println(123123);
        openEditPage();

        driver.findElement(By.id("topic")).click();
        driver.findElement(By.id("topic")).clear();
        driver.findElement(By.id("topic")).sendKeys(data.getName());


        driver.findElement(By.id("annotation_rus")).click();
        driver.findElement(By.id("annotation_rus")).clear();
        driver.findElement(By.id("annotation_rus")).sendKeys(data.getRusAnnotation());

        driver.findElement(By.id("annotation_en")).click();
        driver.findElement(By.id("annotation_en")).clear();
        driver.findElement(By.id("annotation_en")).sendKeys(data.getEnAnnotation());

        driver.findElement(By.id("words")).click();
        driver.findElement(By.id("words")).clear();
        driver.findElement(By.id("words")).sendKeys(data.getKeyWords());

        driver.findElement(By.id("authors")).click();
        driver.findElement(By.id("authors")).clear();
        driver.findElement(By.id("authors")).sendKeys(data.getNotInSystemAuthors());

        driver.findElement(By.id("doi")).click();
        driver.findElement(By.id("doi")).clear();
        driver.findElement(By.id("doi")).sendKeys(data.getDoi());

        driver.findElement(By.id("btn_submit")).click();
    }

}
