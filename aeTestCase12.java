package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aeTestCase12 extends TestBase {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement verify01 = driver.findElement(By.xpath("(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]"));
        Assert.assertTrue(verify01.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Hover over first product and click 'Add to cart'
        String name1 = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p")).getText();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();

        //6. Click 'Continue Shopping' button
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart'
        String name2 = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/p")).getText();
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //9. Verify both products are added to Cart
        List<WebElement> addCartList = driver.findElements(By.xpath("//h4/a"));
        List<String> addCartName = new ArrayList<>();
        for (WebElement w : addCartList) {
            String x = w.getText();
            addCartName.add(x);
        }
        List<String> productName = new ArrayList<>(Arrays.asList(name1,name2));
        Assert.assertEquals(addCartName,productName);

        //10. Verify their prices, quantity and total price
        String price1 = driver.findElement(By.xpath("//*[@id='product-1']/td[3]/p")).getText().split(" ")[1];
        int p1 = Integer.parseInt(price1);
        String price2 = driver.findElement(By.xpath("//*[@id='product-2']/td[3]/p")).getText().split(" ")[1];
        int p2 = Integer.parseInt((price2));
        String adet1 = driver.findElement(By.xpath("(//button[@class='disabled'])[1]")).getText();
        int a1 = Integer.parseInt((adet1));
        String adet2 = driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).getText();
        int a2 = Integer.parseInt((adet2));
        String total1 = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).getText().split(" ")[1];
        int t1 = Integer.parseInt(total1);
        String total2 = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]")).getText().split(" ")[1];
        int t2 = Integer.parseInt(total2);
        int actualTotal1 = p1*a1;
        int actualTotal2 = p2*a2;
        Assert.assertEquals(actualTotal1,t1);
        Assert.assertEquals(actualTotal2,t2);
    }

}
