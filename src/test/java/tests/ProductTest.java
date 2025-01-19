package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

import static java.lang.Thread.sleep;

public class ProductTest extends baseTest {
    ProductPage productPage;


    @Test
    public void testApplyFilters() throws InterruptedException {
        productPage = new ProductPage(driver);
//        driver.get("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010");
        driver.manage().window().maximize();

        // Filtreleme işlemleri
        //Fareyi filtre alanına taşı
        productPage.moveToFilterArea();
        sleep(2000);

        //Beden başlığına yönel
        productPage.hoverOverSizeHeader();
        sleep(2000);
        //Beden filtrelerini uygula
        productPage.selectSizeFilters();
        sleep(20000);
        //Renk Filtresini uygula
        productPage.selectBejColor();
        sleep(20000);

        //En çok satanlar şeklinde ürünleri listele
        productPage.selectBestSellers();
        sleep(10000);

        //3.Ürünü seç
        productPage.selectThirdProduct();
        sleep(10000);

        // Sayfa başlığını kontrol et
        String expectedTitle = "Bej Kapüşonlu Kız Çocuk Mont - W49176Z4-KXY | LCW"; // Beklenen başlık
        String actualTitle = driver.getTitle(); // Gerçek başlık
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Sayfa başlığı beklenen metni içermiyor.");


    }
}
