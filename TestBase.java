package practiceGenel;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class TestBase {
    static WebDriver driver;
    Actions actions = new Actions(driver);
    Faker faker = new Faker();



    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:/Users/sdemi/Desktop/gighmmpiobklfepjocnamgkkbiglidom-5.3.3-Crx4Chrome.com.crx"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
