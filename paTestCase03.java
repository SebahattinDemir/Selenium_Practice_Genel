package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class paTestCase03 extends TestBase {
    @Test
    public void test() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        driver.findElement(By.xpath("//a[text()='Shop']")).click();

        //4) Now click on Home menu button
        driver.findElement(By.xpath("//a[text()='Home']")).click();

        //5) Test whether the Home page has Three Arrivals only
        List<WebElement> list = driver.findElements(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
        Assert.assertEquals(3,list.size());

        //6) The Home page must contains only three Arrivals
        //7) Now click the image in the Arrivals
        list.get(2).click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        WebElement verify = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        Assert.assertTrue(verify.isDisplayed());

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
    }

}