package practiceGenel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class aeTestCase08 {
    static WebDriver driver;
    //Actions actions = new Actions(driver);

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:/Users/sdemi/Desktop/gighmmpiobklfepjocnamgkkbiglidom-5.3.3-Crx4Chrome.com.crx"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

//    @AfterClass
//    public static void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//    }

    @Test
    public void test(){
        //2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to 'ALL PRODUCTS' page successfully
        String verify01 = driver.findElement(By.cssSelector("h2[class='title text-center']")).getText();
        Assert.assertEquals("ALL PRODUCTS", verify01);

        //6. The products list is visible
        WebElement visible01 = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(visible01.isDisplayed());

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        WebElement visible02 = driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(visible02.isDisplayed());

    }
}
