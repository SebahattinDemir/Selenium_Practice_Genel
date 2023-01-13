package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class aeTestCase19 extends TestBase{

    @Test
    public void test() throws InterruptedException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //4. Verify that Brands are visible on left side bar
        WebElement verify01 = driver.findElement(By.cssSelector("div[class='brands_products']"));
        Assert.assertTrue(verify01.isDisplayed());

        //5. Click on any brand name
        String brandNameText = driver.findElement(By.xpath("//a[text()='Polo']")).getText().split("\n")[1];//(6) satır atla POLO şeklinde text aldığı için
        driver.findElement(By.xpath("//a[text()='Polo']")).click();

        //6. Verify that user is navigated to brand page and brand products are displayed(Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın)
        String verify02 = driver.findElement(By.cssSelector("li[class='active']")).getText().toUpperCase();//Marka adı küçük yazdığı için toUpperCase()
        Assert.assertEquals(brandNameText,verify02);
        WebElement verify03 = driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(verify03.isDisplayed());

        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='H&M']")).click();

        //8. Verify that user is navigated to that brand page and can see products
        String brandNameText2 = driver.findElement(By.xpath("//a[text()='H&M']")).getText().split("\n")[1];
        String verify04 = driver.findElement(By.cssSelector("li[class='active']")).getText().toUpperCase();
        Assert.assertEquals(brandNameText2,verify04);
        WebElement verify05 = driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(verify05.isDisplayed());
    }
}
