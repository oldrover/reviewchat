package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id= "inputUsername")
    private WebElement inputUsername;

    @FindBy(id= "inputPassword")
    private WebElement inputPassword;

    @FindBy(id= "submit-button")
    private WebElement submitButton;

    @FindBy(id= "signup-link")
    private WebElement signupLink;

    public LoginPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
    }

    public void setUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        submitButton.click();
    }

    public void clickSignupLink() {
        signupLink.click();

    }


}
