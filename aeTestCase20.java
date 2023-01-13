package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class aeTestCase20 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        List<String> allProductsText = new ArrayList<>();// 34 ürün ismi eklendi
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));//Listelenen tüm ürünlerin isimleri bir List içine alındı 7. soru için gerekli
        for (WebElement w : allProducts) {
            String y = w.getText();
            allProductsText.add(y);
        }

        //4. Verify user is navigated to 'ALL PRODUCTS' page successfully
        String verify01 = driver.findElement(By.cssSelector("h2[class='title text-center']")).getText();
        Assert.assertEquals("ALL PRODUCTS", verify01);

        //5. Enter product name in search input and click search button
        driver.findElement(By.cssSelector("input[id='search_product']")).sendKeys("Stylish Dress");
        driver.findElement(By.cssSelector("button[id='submit_search']")).click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        String verify02 = driver.findElement(By.cssSelector("h2[class='title text-center']")).getText();
        Assert.assertEquals("SEARCHED PRODUCTS", verify02);

        //7. Verify all the products related to search are visible(Arama yapılan ilgili ürünün tüm ürünlerin görünür olduğundan emin olun) Aynı isimde birden fazla ürün olabilir bu nedenle yapıldı
        List<String> allProductsCheck = new ArrayList<>();
        List<WebElement> verify03 = driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));// arama yapııldığında çıkan ürünleri isimleri List içine eklendi
        for (WebElement w : verify03) {
            String y = w.getText();
            allProductsCheck.add(y);
        }
        int counter = 0;
        for (String w : allProductsText) {
            for (String z : allProductsCheck) {
                if (z.equals(w)) {
                    counter++;
                }
            }
        }
        Assert.assertEquals(verify03.size(), counter);//aranan ürün list'inin size ile counter eşit ise ürün listesinde aynı isimde olan ürünlerin hepsi arama sonuçlarında çıkmış demektir
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //8. Add those product to cart

        // 1. Yol:
//        List<WebElement> tops=driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
//        for(WebElement w: tops){
//            driver.findElement(By.xpath("//input[@id='search_product']")).clear();
//            driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(w.getText());
//            driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
//            actions.sendKeys(Keys.PAGE_DOWN).perform();
//            driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
//            Thread.sleep(2000);
//            actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//div[@class='modal-footer']")).click();
//            Thread.sleep(1000);
//            driver.navigate().back();
//        }


        //2.Yol:
        for (int i = 1; i < 44; i++) {
            if (i == 9 || i == 10 || i == 17 || i == 25 || i == 26 || i == 27 || i == 32 || i == 34 || i == 36) {
                continue;
            } else {
                driver.findElement(By.xpath("(//a[@data-product-id='" + i + "'])[1]")).click();
                driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
            }
        }

        //9. Click 'View Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();//View Cart butonuna tıklama yapıldı
        List<String> addProductCheckText = new ArrayList<>();
        for (int i = 1; i < 44; i++) {
            if (i == 9 || i == 10 || i == 17 || i == 25 || i == 26 || i == 27 || i == 32 || i == 34 || i == 36) {
                continue;
            } else {
               String addProductCheck = driver.findElement(By.xpath("//a[@href='/product_details/" + i + "']")).getText();//sepette ki ürünlerin adı}
                addProductCheckText.add(addProductCheck);
            }
        }
        Assert.assertEquals(allProductsText, addProductCheckText);

        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("(//a[@href='/login'])[1]")).click();
        WebElement name = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        actions.click(name).sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        WebElement details = driver.findElement(By.cssSelector("input[id='id_gender1']"));
        actions.click(details).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.TAB).sendKeys("7")
                .sendKeys(Keys.TAB).sendKeys("February").sendKeys(Keys.TAB).sendKeys("1992").perform();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        WebElement signupclick = driver.findElement(By.xpath("//input[@name='optin']"));
        actions.click(signupclick).
                sendKeys(Keys.TAB).click().sendKeys(Keys.TAB)
                .click().sendKeys(Keys.TAB).sendKeys("Sebahattin").sendKeys(Keys.TAB).sendKeys("Demir").sendKeys(Keys.TAB).sendKeys("Demsa")
                .sendKeys(Keys.TAB).sendKeys("Antalya").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Israel").sendKeys(Keys.TAB)
                .sendKeys("Konyaaltı").sendKeys(Keys.TAB).sendKeys("Lara").sendKeys(Keys.TAB).sendKeys("07000").sendKeys(Keys.TAB)
                .sendKeys("05555555555").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //11. Again, go to Cart page
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //12. Verify that those products are visible in cart after login as well(Bu ürünlerin giriş yaptıktan sonra sepette de göründüğünden emin olun)
        WebElement verify04 = driver.findElement(By.xpath("//a[text()='Stylish Dress']"));
        Assert.assertTrue(verify04.isDisplayed());
    }
}

