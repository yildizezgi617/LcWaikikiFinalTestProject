package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    WebDriver driver;

    // Yapıcı metod, driver'ı ve sayfa elemanlarını başlatır
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Sayfa elemanlarını başlat
    }

    // Locators
    @FindBy(xpath = "//a[normalize-space()='ÇOCUK & BEBEK']")
    WebElement childAndBabyCategory;

    @FindBy(xpath = "//span[normalize-space()='KIZ ÇOCUK']")
    WebElement girlChildCategory;

    @FindBy(xpath = "//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']")
    WebElement coatsAndJackets;

    // Çocuk & Bebek kategorisine fareyi taşıma
    public void hoverOverChildAndBabyCategory() {
        Actions actions = new Actions(driver);
        // Çocuk & Bebek kategorisine fareyi getir
        actions.moveToElement(childAndBabyCategory).perform();
    }


    // Kız Çocuk kategorisine fareyi taşıma
    public void hoverOverGirlChildCategory() {
        Actions actions = new Actions(driver);
        // Kız Çocuk kategorisine fareyi getir
        actions.moveToElement(girlChildCategory).perform();
    }
    // Mont ve Kaban seçeneğine fareyi taşı ve tıkla
    public void selectCoatsAndJackets() {
        Actions actions = new Actions(driver);
        // Mont ve Kaban seçeneğine fareyi getir ve tıklama
        actions.moveToElement(coatsAndJackets).click().perform();
    }
}
