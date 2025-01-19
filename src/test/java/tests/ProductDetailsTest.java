package tests;

import org.testng.annotations.Test;
import pages.ProductDetailsPage;

import static java.lang.Thread.sleep;

public class ProductDetailsTest extends baseTest {


    ProductDetailsPage productDetailsPage;

    {
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test
    public void testProductDetailsFlow() throws InterruptedException {

        // Page sınıfından nesne oluştur
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        // Favorilere ekle
        productDetailsPage.addToFavorites();
        sleep(2000); // Bir süre bekleyelim

        // Beden seçeneğini tıkla
        productDetailsPage.selectSize();
        sleep(2000);

        // Sepete ekle
        productDetailsPage.addToCart();
        sleep(5000); // Sepete ekleme işlemi için bekleme süresi
        productDetailsPage.goToFavorites();
        sleep(2000);

        // Sepetime git
        productDetailsPage.goToCart();
        sleep(2000);



    }
}
