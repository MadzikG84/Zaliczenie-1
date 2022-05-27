package zad2;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SweaterBuyTest {
    private WebDriver driver;
    private LogIn logInShop;
    private SweaterSearchAndAdd sweaterBuy;
    private DeliveryAndPay confirmPurchase;

    @Test
    public void logInAndBuy ()
        {
        logInShop.signInPage();
        logInShop.loginAs("oxkbzjqrhslndwzgnt@nvhrw.com", "12345mm");
        sweaterBuy.searchOurProduct("Hummingbird Printed Sweater");
        sweaterBuy.sweaterSize();
        sweaterBuy.sweaterQty("5");
        sweaterBuy.addToCartAndCheck();
        confirmPurchase.confirmAddAndDelivery();
        confirmPurchase.payByCheck();
    }

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logInShop = new LogIn(driver);
        sweaterBuy = new SweaterSearchAndAdd(driver);
        confirmPurchase = new DeliveryAndPay(driver);
    }

    @After
    public void screen() throws IOException, InterruptedException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Screen\\screenshot.jpg"));
        String testName = new Throwable() {}
                .getStackTrace()[0]
                .getMethodName();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        Date date = new Date();
        String dateTime = dateFormat.format(date);

        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + dateTime + ".jpg"));

    }
}
