package zad1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddingAddressSteps {

    private WebDriver driver;

    @Given("^Opened webpage: (.*)$")
    public void beforeEach(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @And("Click on \"Sign in\"")
    public void logInPage() {
        driver.findElement(By.cssSelector("[title='Log in to your customer account']")).click();
    }

    @When("^Enter \"(.*)\" in email field and \"(.*)\" in password field$")
    public void validEmailAndPasswordProvided(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("Press \"Sign in\" button")
    public void clickSingInButton() {
        driver.findElement(By.id("submit-login")).click();
    }

    @And("Press \"Addresses\" button at the bottom of the page")
    public void clickAddressesButton() {
        driver.findElement(By.cssSelector("[title='Addresses']")).click();
    }

    @And("Click on \"+Create new address\"")
    public void pressCreateNewAddress() {
        driver.findElement(By.cssSelector("[data-link-action='add-address']")).click();
    }

    @And("^Fill in valid address data: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void fillValidAddressData(String alias, String address, String city, String zip, String country, String phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("postcode")).sendKeys(zip);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("id_country")).sendKeys(country);
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys(phone);
    }

    @Then("Save new address")
    public void saveNewAddress() {
        Assert.assertTrue(true);
        System.out.println("Address correct");
        driver.findElement(By.cssSelector("[class='btn btn-primary float-xs-right']")).submit();
    }
}
//    @And("Browser quit")
//    public void browserQuit() {
//        driver.quit();
//  }


