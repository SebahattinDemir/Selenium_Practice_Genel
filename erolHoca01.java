package practiceGenel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Watchable;
import java.util.List;

public class erolHoca01 extends TestBase {

    @Test
    public void test(){

//    - ebay sayfasına gidiniz
        driver.get("https://ebay.com");

//    - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

//    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        for (int i = 1; i < 24; i++) {
            List<WebElement> list = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            list.get(i).click();
            System.out.println(i+". baslik "+driver.getTitle());
            driver.navigate().back();
        }

//    - Her sayfanın sayfa başlığını yazdıralım

//    - sayfayı kapatalım
        driver.close();

    }
}
