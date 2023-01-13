package practiceGenel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TutorialsNinja {

    static List<WebElement> phonesAdd;
    static List<WebElement> listName;
    static List<WebElement> phonesNames;
    static List<String> sepetListesi = new ArrayList<>();
    static List<String> goruntulemeListesi = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");

  // ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[@href='http://tutorialsninja.com/demo/index.php?route=product/category&path=24']")).click();

  // ~ get the brandName of phones
        phonesNames = driver.findElements(By.cssSelector("div.caption>h4>a"));
        getName(phonesNames, goruntulemeListesi);
        Thread.sleep(2000);
  //  ~ click on add to button for all elements
        phonesAdd=driver.findElements(By.xpath("//div[@class='button-group']"));
        allElementsAdd(phonesAdd);

  //  ~ click on black total added cart button
        driver.findElement(By.id("cart-total")).click();
        Thread.sleep(3000);

  //  ~ get the names of list from the cart
        listName = driver.findElements(By.cssSelector("td.text-left>a"));
        getName(listName,sepetListesi);

  //  ~ compare the names from displaying list and cart list
        compareTwoList(goruntulemeListesi,sepetListesi);

  //  - close
        driver.close();
    }

    public static void allElementsAdd(List<WebElement> a) throws InterruptedException {
        for (WebElement w : phonesAdd) {
            w.click();
            Thread.sleep(2000);
        }
    }
    public static void getName(List<WebElement>a,List<String>b){
        for (WebElement w : a){
            b.add(w.getText());
        }
        Collections.sort(b);
        System.out.println(b);
    }
    public static void compareTwoList(List<String> a, List<String> b) {
        System.out.println(goruntulemeListesi.equals(sepetListesi) ? "Listeler Aynı" : "Listeler Farklı");
    }
}
