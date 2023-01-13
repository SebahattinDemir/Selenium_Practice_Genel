package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class aeTestCase14 extends TestBase{
    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement verify01 = driver.findElement(By.xpath("(//img[@class='girl img-responsive'])[1]"));
        Assert.assertTrue(verify01.isDisplayed());

        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='14'])[1]")).click();

        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //6. Verify that cart page is displayed
        WebElement verify02 = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(verify02.isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();

        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.gameOfThrones().character()
                + Keys.TAB + faker.internet().emailAddress() + Keys.TAB + Keys.ENTER);
        WebElement accountInfo = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(accountInfo).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.pokemon().name()).sendKeys(Keys.TAB).sendKeys("7").sendKeys(Keys.TAB)
                .sendKeys("February").sendKeys(Keys.TAB).sendKeys("1992").sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
