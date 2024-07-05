package org.OpenCart.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Web elements
    @FindBy(id = "input-email")
    WebElement username;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement forgottenPassword;
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement logoutLink;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterEmail(String email){
        username.sendKeys(email);
    }
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void LoginButton(){
        loginButton.click();
    }
    public void clickForgottenPassword() {
        forgottenPassword.click();
    }
    public boolean CheckForgotPassLink(){
        return forgottenPassword.isDisplayed();
    }
    public boolean CheckLogoutLink(){
        return logoutLink.isDisplayed();

    }
    public void login(String email, String pass){
        enterEmail(email);
        enterPassword(pass);
        LoginButton();
    }
    public String getForgotPageURL(){
        String pageUrl = driver.getCurrentUrl();
        return pageUrl;


    }
}

