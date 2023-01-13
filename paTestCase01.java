package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class paTestCase01 extends TestBase {

    @Test
    public void test() {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        driver.findElement(By.xpath("//a[text()='Shop']")).click();

        //4) Now click on Home menu button
        driver.findElement(By.xpath("//a[text()='Home']")).click();

        //5) Test whether the Home page has Three Sliders only
        List<WebElement> list = driver.findElements(By.xpath("//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']"));
        Assert.assertEquals(3, list.size());

        //6) The Home page must contains only three sliders
    }


}
