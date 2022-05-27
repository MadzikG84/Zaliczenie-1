package zad2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAndPay
{

    @FindBy(name = "confirm-addresses")
    private WebElement confirm;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDelivery;

    @FindBy(id = "payment-option-1")
    private WebElement payCheck;

    @FindBy(css = "[class = 'ps-shown-by-js']")
    private WebElement agreeBox;

    @FindBy(css = "[class = 'btn btn-primary center-block']")
    private WebElement order;

    public DeliveryAndPay(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void confirmAddAndDelivery() {
        confirm.click();
        confirmDelivery.click();
    }

    public void payByCheck() {
        payCheck.click();
        agreeBox.click();
        order.click();
    }
}
