package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;


public class SeleniumTest {
    private String URL = "http://automationpractice.com/index.php";
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public static List<Dimension> screenDimensionsList;


    @BeforeAll
    static void setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\selenium\\chromedriver.exe");
        screenDimensionsList = new ArrayList<Dimension>();
        screenDimensionsList.add(new Dimension(1600,800));
        screenDimensionsList.add(new Dimension(1200,800));
        screenDimensionsList.add(new Dimension(992,800));
        screenDimensionsList.add(new Dimension(768,800));
        screenDimensionsList.add(new Dimension(480,800));
        screenDimensionsList.add(new Dimension(360,800));
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void correctCreateNewAccount() throws Exception {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("testselenium-15@wp.pl");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("aa");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("bb");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("testselenium");
        driver.findElement(By.id("days")).click();
        new Select(driver.findElement(By.id("months"))).selectByIndex(1);
        driver.findElement(By.id("days")).click();
        driver.findElement(By.id("months")).click();
        new Select(driver.findElement(By.id("months"))).selectByIndex(1);
        driver.findElement(By.id("months")).click();
        driver.findElement(By.id("years")).click();
        new Select(driver.findElement(By.id("years"))).selectByIndex(1);
        driver.findElement(By.id("years")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("aa");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("brak");
        driver.findElement(By.id("address2")).click();
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys("aa");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("gdańsk");
        driver.findElement(By.id("id_state")).click();
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).click();
        driver.findElement(By.id("other")).clear();
        driver.findElement(By.id("other")).sendKeys("brak");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("12334511431");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("123124124124");
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.xpath("//button[@id='submitAccount']/span/i")).click();
    }

    @Test
    public void incorrectCreateNewAccount() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("testselenium-1@wp.pl");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::li[1]")).click();
        driver.findElement(By.id("create_account_error")).isDisplayed();
    }

    @Test
    public void correctSingIn() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("testselenium-1@wp.pl");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("testselenium");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
    }

    @Test
    public void incorrectSingIn() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("testselenium1@wp.pl");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("testselenium");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Test
    void testVariousScreenSizes() {
        for (Dimension d : screenDimensionsList) {
            driver.manage().window().setSize(d);
            driver.findElement(By.xpath("//img[@alt='My Store']")).click();
            driver.findElement(By.id("search_query_top")).click();
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }



}
