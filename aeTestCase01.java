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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class aeTestCase01 {
    static WebDriver driver;
    Actions actions = new Actions(driver);

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

//    @AfterClass
//    public static void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//    }

    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement visible01 = driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue(visible01.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
        String visible02 = driver.findElement(By.xpath("//*[text()='New User Signup!']")).getText();
        Assert.assertEquals("New User Signup!", visible02);

        //6. Enter name and email address //7. Click 'Signup' button
        WebElement name = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        actions.click(name).sendKeys("Sebahattin").sendKeys(Keys.TAB).sendKeys("sa@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String visible03 = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", visible03);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        WebElement details = driver.findElement(By.cssSelector("input[id='id_gender1']"));
        actions.click(details).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.TAB).sendKeys("7")
                .sendKeys(Keys.TAB).sendKeys("February").sendKeys(Keys.TAB).sendKeys("1992").perform();

        WebElement signupclick1= driver.findElement(By.xpath("//input[@name='newsletter']"));
        actions.click(signupclick1).perform();
        WebElement signupclick2= driver.findElement(By.xpath("//input[@name='optin']"));
        actions.click(signupclick2).
                sendKeys(Keys.TAB).click().sendKeys(Keys.TAB)
                .click().sendKeys(Keys.TAB).sendKeys("Sebahattin").sendKeys(Keys.TAB).sendKeys("Demir").sendKeys(Keys.TAB).sendKeys("Demsa")
                .sendKeys(Keys.TAB).sendKeys("Antalya").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Israel").sendKeys(Keys.TAB)
                .sendKeys("Konyaltı").sendKeys(Keys.TAB).sendKeys("Lara").sendKeys(Keys.TAB).sendKeys("07000").sendKeys(Keys.TAB)
                .sendKeys("05555555555").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String visible04 = driver.findElement(By.xpath("//*[text()='Account Created!']")).getText();
        Assert.assertEquals("ACCOUNT CREATED!", visible04);

        //15. Click 'Continue' button
        driver.findElement(By.cssSelector("div[class='pull-right']")).click();

        //16. Verify that 'Logged in as username' is visible
        String visible05 = driver.findElement(By.cssSelector("i[class='fa fa-user']")).getText();
        Assert.assertEquals("Logged in as sebahattin", visible05);

        //17. Click 'Delete Account' button
        driver.findElement(By.cssSelector("i[class='fa fa-trash-o']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String visible06 = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']")).getText();
        Assert.assertEquals("ACCOUNT DELETED!", visible06);

    }
}
