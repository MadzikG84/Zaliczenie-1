package zad2;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SweaterSearchAndAdd {

    @FindBy(name = "s")
    private WebElement searchProduct;

    @FindBy(css = "[alt = 'Brown bear printed sweater']")
    private WebElement sweaterHum;

    @FindBy(css = "[title = 'M']")
    private WebElement productSize;

    @FindBy(name = "qty")
    private WebElement prodQty;

    @FindBy(css = "[class = 'btn btn-primary add-to-cart']")
    private WebElement addTo;

    @FindBy(css = "[class = 'btn btn-primary']")
    private WebElement checkout;

    public SweaterSearchAndAdd(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchOurProduct(String product) {
        searchProduct.sendKeys(product);
        searchProduct.sendKeys(Keys.ENTER);
        sweaterHum.click();
    }

    public void sweaterSize() {
        productSize.click();
    }

    public void sweaterQty(String qty) {
        prodQty.isEnabled();
        prodQty.sendKeys(Keys.SHIFT, Keys.HOME);
        prodQty.sendKeys(qty);
    }

    public void addToCartAndCheck() {
        addTo.sendKeys(Keys.ENTER);
        checkout.click();
        checkout.click();
    }
}
