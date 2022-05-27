package zad2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
    @FindBy(css = "[title='Log in to your customer account']")
    private WebElement signInPage;

    @FindBy(name = "email")
    private WebElement userEmail;

    @FindBy(name = "password")
    private WebElement userPassword;

    @FindBy(id = "submit-login")
    private WebElement singIn;

    public LogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signInPage() {
        signInPage.click();
    }

    public void loginAs(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        singIn.click();
    }
}