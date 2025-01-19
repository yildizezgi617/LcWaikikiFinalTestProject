package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends baseTest {


    @Test
    public void testLogin() throws InterruptedException {
        // LoginPage nesnesi oluştur
        LoginPage loginPage = new LoginPage(driver);

        // Giriş yap butonuna tıkla
        loginPage.clickLoginButton();
        Thread.sleep(2000);

        // Geçerli bir e-posta ve şifre ile giriş bilgilerini gir
        loginPage.enterEmail("5392295860");
        Thread.sleep(2000);
        loginPage.clickContinueButton();
        Thread.sleep(2000);
        loginPage.enterPassword("okseafilora34");

        // Giriş yap butonuna tıkla
        loginPage.clickSubmitLoginButton();

        // Giriş başarılı olduğunu doğrula
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.lcw.com/giris";
        Assert.assertEquals(actualUrl, expectedUrl, "Giriş işlemi başarısız!");

    }

    }