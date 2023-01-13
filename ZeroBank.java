package practiceGenel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroBank {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//      1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//      2. Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
//      3. Login alanine  "username" yazdirin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");
//      4. Password alanine "password" yazdirin
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");
//      5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.navigate().back();
//      6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();
//      7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("500");
//      8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10");
//      9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
//      10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        String baslik = driver.findElement(By.cssSelector("div[id='alert_content']")).getText();
        if (baslik.equals("The payment was successfully submitted."))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
        driver.close();
    }
}
