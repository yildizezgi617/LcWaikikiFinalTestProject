package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.ProductPage;

import java.time.Duration;

public class CategoryTest extends baseTest {


    ProductPage productPage;



    @Test
    public void testCategorySelection() throws InterruptedException {
        // Başlangıç URL'i
        driver.get("https://www.lcw.com/");
        // WebDriver'ı başlat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CategoryPage categoryPage = new CategoryPage(driver);

        // "Çocuk & Bebek" kategorisini bekle
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']")));
        categoryPage.hoverOverChildAndBabyCategory();
        Thread.sleep(2000);


        // "Kız Çocuk (6-14 Yaş)" kategorisini bekle
        category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='KIZ ÇOCUK']")));
        categoryPage.hoverOverGirlChildCategory();
        Thread.sleep(2000);


        // "Mont ve Kaban" tıklama
        category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']")));
        categoryPage.selectCoatsAndJackets();
        Thread.sleep(2000);

        // Sayfa başlığını kontrol et
        String expectedTitle = "Kız Çocuk Dış Giyim Fiyatları ve Modelleri | LCW";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Sayfa başlığı beklenen metni içermiyor.");
        Thread.sleep(2000);
    }


}

