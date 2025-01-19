package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

import java.sql.Driver;

import static java.lang.Thread.sleep;

public class CartTest extends baseTest{
     CartPage cartPage;

    @Test
    public void testCartFlow() throws InterruptedException {

        cartPage = new CartPage(driver);

        // Ürün miktarını artır
        cartPage.increaseQuantity();
        sleep(2000);


        String expectedProductName = "Mont"; // Beklenen ürün adı
        String expectedProductQuantity = "2"; // Beklenen ürün miktarı
        String expectedProductPrice = "2.999,98 TL"; // Beklenen ürün fiyatı


        String actualProductName = cartPage.getProductName();
        String actualProductQuantity = cartPage.getProductQuantity();
        String actualProductPrice = cartPage.getProductPrice();
        Assert.assertEquals(actualProductName, expectedProductName, "Ürün adı eşleşmiyor!");
        Assert.assertEquals(actualProductQuantity, expectedProductQuantity, "Ürün miktarı eşleşmiyor!");
        Assert.assertEquals(actualProductPrice, expectedProductPrice, "Ürün fiyatı eşleşmiyor!");



        // Ödemeye geç
        cartPage.proceedToCheckout();
        sleep(5000); // Ödeme işlemine geçiş süresi

    }


    }
