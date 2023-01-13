package practiceGenel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemo01 {
    static String ilkUrunBaslik;
    static String sonuc;
    static String sepetUrunuBaslik;
    static WebElement sepetUrunu;
    static WebElement ilkUrunBul;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        ilkUrunBul=driver.findElement(By.id("item_4_title_link"));
        ilkUrunBaslikMth(ilkUrunBul);

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        sepetUrunu = driver.findElement(By.cssSelector("div[class='inventory_item_name']"));
        sepetUrunuBaslikMth(sepetUrunu);

        //9. Sayfayi kapatin
        driver.close();

        //Note: class seviyesinde oluşturduğunuz static bir String değer ile
        //5.step ve 8.step de titledan gelecek String değerleri validate etmenizi bekliyoruz.
    }
    private static void ilkUrunBaslikMth(WebElement a){
        ilkUrunBaslik=a.getText();
        a.click();
    }
    private static void sepetUrunuBaslikMth(WebElement x){
        sepetUrunuBaslik = x.getText();
        sonuc=(sepetUrunuBaslik.equals(ilkUrunBaslik)) ? "Test's Passed" : "Test's Failed";
        System.out.println(sonuc);
    }

}
