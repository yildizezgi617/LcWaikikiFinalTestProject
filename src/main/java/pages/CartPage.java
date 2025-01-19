package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    // Sepet sayfasındaki öğeler
    private By productNameLocator = By.xpath("//span[@class='rd-cart-item-code']");
    private By quantityInputLocator= By.xpath("//input[@value='2']");
    private By productPriceLocator = By.cssSelector("span.rd-cart-item-price");


    //Ödemeye geç butonu
    @FindBy(css ="div[class='col-md-12 pl-20 pr-20'] a[class='main-button mt-15']")
    WebElement proceedToCheckoutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //Ürün ismini alma
    public String getProductName() {
        WebElement productNameElement = driver.findElement(productNameLocator);
        return productNameElement.getText();
    }

    //Ürün miktarını alma
    public String getProductQuantity() {
        WebElement quantityElement = driver.findElement(quantityInputLocator);
        return quantityElement.getAttribute("value"); // Burada input elementinin 'value' özelliğini alıyoruz
    }

    //Ürün tutarını alma
    public String getProductPrice() {
        WebElement productPriceElement = driver.findElement(productPriceLocator);
        return productPriceElement.getText(); // Ürün fiyatını alıyoruz
    }


    public void increaseQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement increaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='+']")));
        increaseButton.click();
    }
        public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
