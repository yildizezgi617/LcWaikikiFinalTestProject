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

public class ProductDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //Favoriye ekleme butonu
    @FindBy(xpath = "//a[@id='add-to-favorite-detail']")
    WebElement addToFavoriteButton;

    // Beden seçenekleri
    @FindBy(xpath = "//button[contains(text(),'6-7 Yaş')]")
    WebElement sizeSelectorButton;

    // Sepete ekle butonu
    @FindBy(xpath = "//button[normalize-space()='SEPETE EKLE']")
    WebElement addToCartButton;

    // Favorilerim linki
    @FindBy(xpath = "//span[normalize-space()='Favorilerim']")
    WebElement favoritesLink;
    // Sepetim linki
    @FindBy(xpath = "//span[normalize-space()='Sepetim']")
    WebElement cartLink;


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Favorilere ekle butonuna tıkla
    public void addToFavorites() {
    addToFavoriteButton.click();
        driver.manage().window().maximize();
    }

    // İstenilen bedene tıkla
    public void selectSize() {


        sizeSelectorButton.click();

    }
    public void moveToaddSepetButoon() {

        actions.moveToElement(addToCartButton).perform();
    }



    // Sepete ekle butonuna tıkla
    public void addToCart() {
       addToCartButton.click();
    }
    // Favorilerime git
    public void goToFavorites() {
        favoritesLink.click();
    }
    //Sepetime git
    public void goToCart() {
        cartLink.click();
    }

}
