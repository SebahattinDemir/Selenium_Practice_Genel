package practiceGenel;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class aeTestCase10 extends TestBase{

    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement verify01 = driver.findElement(By.xpath("(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]"));
        Assert.assertTrue(verify01.isDisplayed());

        //4. Scroll down to footer
        actions.sendKeys(Keys.PAGE_DOWN);

        //5. Verify text 'SUBSCRIPTION'
        WebElement verify02 = driver.findElement(By.cssSelector("div[class='single-widget']"));
        Assert.assertTrue(verify02.isDisplayed());

        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.lordOfTheRings().character()+faker.internet().emailAddress());
        driver.findElement(By.cssSelector("i[class='fa fa-arrow-circle-o-right']")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement verify03 = driver.findElement(By.cssSelector("div[class='alert-success alert']"));
        Assert.assertTrue(verify03.isDisplayed());

    }

}
