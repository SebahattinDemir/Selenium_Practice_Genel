package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class sahibindencomTestCase extends TestBase {

    @Test
    public void test() {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");
        waitFor(1);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        //anasayfada oldugunuzu dogrulayin
        WebElement verify1 = driver.findElement(By.xpath("//a[@class='icon-category category-acil-acil trackLinkClick trackId_acilacil_sol_menu']"));
        Assert.assertTrue(verify1.isDisplayed());

        //detayli arama tiklayin
        driver.findElement(By.xpath("//a[@href='https://www.sahibinden.com/arama/detayli']")).click();

        //detayli arama sayfasina geldiginizi dogrulatin
        WebElement verify2 = driver.findElement(By.xpath("//h2[text()='Detaylı Arama']"));
        Assert.assertTrue(verify2.isDisplayed());

        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//span[text()='Emlak']")).click();
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        driver.findElement(By.xpath("//span[text()='Kiralık']")).click();
        driver.findElement(By.xpath("//span[text()='Daire']")).click();

        detayli_Arama_Adres("Sivas", "Suşehri", "Suşehri");
        detayli_Arama_Fiyat("1500", "5000");
        detayli_Arama_Brut("90", "300");
        WebElement odasayisi = driver.findElement(By.xpath("//div[@style='min-width: 219px;']"));
        Select select = new Select(odasayisi);
        select.selectByVisibleText("2+1");
        select.selectByVisibleText("3+1");
//        driver.findElement(By.xpath("//label[@for='a20_option_5']")).click();
//        driver.findElement(By.xpath("//label[@for='a20_option_9']")).click();
        driver.findElement(By.xpath("(//a[@class='close-pane'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='filtered-select js-filtered-select active-select closed']")).click();
        driver.findElement(By.xpath("//li[@data-value='false']")).click();
        driver.findElement(By.xpath("//div[@class='filtered-select js-filtered-select active-select closed']")).click();
        driver.findElement(By.xpath("//li[@data-value='date_desc']")).click();
        driver.findElement(By.xpath("//button[@class='btn mtdef']")).click();

    }

    public void detayli_Arama_Adres(String il, String ilce, String mahalle) {

        driver.findElement(By.xpath("//*[@class='faceted-select']")).click();
        driver.findElement(By.xpath("//input[@placeholder='İl']")).sendKeys(il);
        driver.findElement(By.xpath("//a[text()='" + il + "']")).click();

        driver.findElement(By.xpath("//a[text()='İlçe']")).click();
        driver.findElement(By.xpath("//input[@placeholder='İlçe']")).sendKeys(ilce);
        driver.findElement(By.xpath("//a[text()='" + ilce + "']")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();

        driver.findElement(By.xpath("//a[text()='Mahalle']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']")).sendKeys(mahalle);
        driver.findElement(By.xpath("//a[text()='" + mahalle + " " + "']")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
    }

    public void detayli_Arama_Fiyat(String minTl, String maxTl) {
        driver.findElement(By.xpath("(//input[@class='searchTextBox numericInput'])[1]")).sendKeys(minTl, Keys.TAB, maxTl);
    }

    public void detayli_Arama_Brut(String minM2, String maxM2) {
        driver.findElement(By.xpath("(//input[@class='searchTextBox numericInput'])[3]")).sendKeys(minM2, Keys.TAB, maxM2);
    }

}
