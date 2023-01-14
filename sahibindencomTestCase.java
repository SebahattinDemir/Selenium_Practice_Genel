package practiceGenel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class sahibindencomTestCase extends TestBase {

    @Test
    public void test() {
        //sahibinden.com a gidin
        driver.get("https://sahibinden.com/");
        waitFor(5);
        //driver.switchTo().alert().accept();
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
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();
        driver.findElement(By.xpath("//span[text()='Daire']")).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        //filtreler için sağıdakilere benzer methodlar oluşturun
        //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");

        detayli_Arama_Adres("Sivas", "", "");



        //detayli_Arama_Fiyat("4.000","4.000.000","USD");
        //detayli_Arama_Brut("180","400");
        //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
        // cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }

    public void detayli_Arama_Adres(String il, String ilce, String Mah) {

        driver.findElement(By.xpath("//*[@class='faceted-select']")).click();
        driver.findElement(By.xpath("//input[@placeholder='İl']")).sendKeys(il);
        //driver.findElement(By.xpath("//a[text()='" + il + "']")).click();

    }

}
