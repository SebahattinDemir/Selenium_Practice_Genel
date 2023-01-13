package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class BurakHoca01 extends TestBase {


    @Test
    public void test01 (){

    // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

    // dropdown'dan "Books" secenegini secin
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");

    // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

    // arama sonuclarinin Java icerdigini test edin
        String verify = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(verify.contains("Java"));
    }




}
