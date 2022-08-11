package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class LoginSteps  {

    WebDriver driver = null;
    WelcomePage welcomePage;

    HomePage homePage;


    @Given("user is on home page")
    public void userIsOnLoginPage() {
        System.out.println("Inside Step - user is on login page");
        String driverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        welcomePage = new WelcomePage(driver);
        welcomePage.verifyTitle();

    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String username, String password) {
        System.out.println("Inside Step - user enters username and password");
        welcomePage.enterUsernameAndPassword(username,password);
    }



    @And("clicks on login button")
    public void clicksOnLoginButton() {
        System.out.println("Inside Step - user clicks on login button");
        welcomePage.clickOnLoginButton();

    }

    @Then("user is login and navigated to home page")
    public void userIsNavigatedToHomePage() {
        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        driver.quit();
    }

}
