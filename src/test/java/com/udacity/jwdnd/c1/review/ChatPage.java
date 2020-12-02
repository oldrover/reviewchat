package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id= "messageText")
    private WebElement messageText;

    @FindBy(id= "messageType")
    private WebElement messageType;

    @FindBy(id= "submitButton")
    private WebElement submitButton;

    @FindBy(id= "logoutLink")
    private WebElement logoutLink;

    public ChatPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void setMessageText(String message) {
        messageText.sendKeys(message);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }





}
