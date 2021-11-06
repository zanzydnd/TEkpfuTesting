package com.itis.kozlov.danya.Helpers;

import com.itis.kozlov.danya.ApplicationManager;

public class NavigationHelper extends HelperBase {

    protected String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl){
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void goToBaseURL(){
        driver.get(baseUrl);
    }

    public void goToLoginUrl(){
        driver.get(baseUrl + "login/");
    }

    public void goToPublicationCreationUrl(){
        driver.get(baseUrl + "publications/create/");
    }
}
