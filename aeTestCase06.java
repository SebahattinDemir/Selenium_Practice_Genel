package practiceGenel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class aeTestCase06 {
    static WebDriver driver;
    Actions actions = new Actions(driver);

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:/Users/sdemi/Desktop/gighmmpiobklfepjocnamgkkbiglidom-5.3.3-Crx4Chrome.com.crx"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

//     @AfterClass
//    public static void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//    }
    @Test
    public void test() throws InterruptedException {

        // Adblock Deneme
//        driver.get("https://chrome.google.com/webstore/detail/adblock-plus-free-ad-bloc/cfhdojbkjhnklbpkdaibdccddilifddb?hl=tr");
//        driver.findElement(By.xpath("(//div[@class='g-c-x'])[1]")).click();
//        driver.switchTo().alert().accept();


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement verify01 = driver.findElement(By.cssSelector("img[src='/static/images/home/logo.png']"));
        Assert.assertTrue(verify01.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        String verify02 = driver.findElement(By.xpath("//*[text()='Get In Touch']")).getText();
        Assert.assertEquals("GET IN TOUCH",verify02);

        //6. Enter name, email, subject and message
        WebElement kayit = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        actions.click(kayit).sendKeys("sebahattin").sendKeys(Keys.TAB).sendKeys("sd@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("Selenium").sendKeys(Keys.TAB).sendKeys("Selenium is very funny").perform();

        //7. Upload file
        WebElement upload = driver.findElement(By.cssSelector("input[name='upload_file']"));
        upload.sendKeys("C:/Users/sdemi/Desktop/Ekran Alıntısı.PNG");

        //8. Click 'Submit' button
        driver.findElement(By.cssSelector("input[data-qa='submit-button']")).submit();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String verify03 = driver.findElement(By.xpath("//*[@id='contact-page']/div[2]/div[1]/div/div[2]")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",verify03);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.cssSelector("a[class='btn btn-success']")).click();
//        Thread.sleep(2000);
//        driver.navigate().back();
//        driver.findElement(By.cssSelector("a[class='btn btn-success']")).click();
        WebElement verify04 = driver.findElement(By.cssSelector("img[src='/static/images/home/logo.png']"));
        Assert.assertTrue(verify04.isDisplayed());
    }
}
