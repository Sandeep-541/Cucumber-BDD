package org.OpenCart.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.OpenCart.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    public WebDriver driver;
    public LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the Opencart login page")
    public void i_am_on_the_opencart_login_page() {

        loginPage = new LoginPage(driver);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_credentials(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.LoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Add an assertion to verify successful login
        Assert.assertTrue(loginPage.CheckLogoutLink());
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        if (linkText.equals("Forgotten Password")) {
            loginPage.clickForgottenPassword();
        }
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getForgotPageURL().contains("account/forgotten"));

    }


}
