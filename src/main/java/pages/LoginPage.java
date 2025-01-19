package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// LoginPage sınıfı, giriş sayfasıyla etkileşim için gerekli yöntemleri içerir
public class LoginPage {
    WebDriver driver;

    // Constructor: WebDriver'ı ve sayfa elemanlarını başlatır
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//span[contains(@class,'user-wrapper')]//span[1]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='E-posta Adresi veya Telefon Numarası']")
    WebElement emailField;
    @FindBy(xpath = "//button[normalize-space()='Devam Et']")
    WebElement continueButton;
    @FindBy(xpath = "//input[@placeholder='Şifreniz']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Giriş Yap')]")
    WebElement submitLoginButton;

    // Sayfa elemetleri ile etkileşim yöntemleri
    public void clickLoginButton() {

        loginButton.click(); // Giriş butonuna tıkla

    }

    public void enterEmail(String email) {

        emailField.sendKeys(email); // E-posta alanına metin gir
    }

    public void enterPassword(String password) {

        passwordField.sendKeys(password); // Devam Et butonuna tıkla
    }

    public void clickContinueButton() {
        continueButton.click(); // Şifre alanına metin gir
    }
    public void clickSubmitLoginButton() {
        submitLoginButton.click(); // Giriş Yap butonuna tıkla
    }
}
