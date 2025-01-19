package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//div[@class='desktop-filter-area__content']")
    WebElement filterArea; //div[@class='desktop-filter-area__content']
    @FindBy(xpath = "//div[normalize-space()='Beden']")
    WebElement sizeHeader;
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[4]/div[1]")
    WebElement bedenFilterBody;
    // Filtreleme bölgesine fareyi getirmek için kullanılan element
    @FindBy(xpath = "//span[contains(text(),'5-6 Yaş')]")
    WebElement yasbes;

    // Yaş altı ve yaş 7 seçenekleri
    @FindBy(css = "body div[id='root'] div[class='page-wrapper'] div[class='product-list-container'] div[class='product-list'] div[class='container-fluid'] div[class='product-list__content-area'] div[class='desktop-filter-area desktop-filter-area--fixed'] div[class='desktop-filter-area__content'] div[class='filter'] div[class='collapsible-filter-container'] div[class='collapsible-filter-container__body'] div[class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter'] div:nth-child(3) span:nth-child(1)")
    private WebElement yasaltı;


    @FindBy(xpath = "//span[contains(text(),'6-7 Yaş')]")
    WebElement yasyedi;

//    // Renk filtresi
@FindBy(css = "div[class='collapsible-filter-container__content-area collapsible-filter-container__content-area--color-filter'] div:nth-child(2) span:nth-child(2)")
WebElement colorFilter;
    @FindBy(css = "img[src='https://img-lcwaikiki.mncdn.com//resource/images/icon/bej.png']")
   WebElement bej;

    // Ürün listesi
    @FindBy(xpath = "//div[@class='product-grid']")
    List<WebElement> productList;

    @FindBy(xpath = "//span[@class='dropdown-button__text']")
    WebElement sortButton;

    // "En Çok Satanlar" seçeneği
    @FindBy(xpath = "//a[normalize-space()='En çok satanlar']")
    WebElement bestSellersOption;
    @FindBy(xpath = "//a[@title='Kapüşonlu Kız Çocuk Mont']//h5[@class='product-card__title'][contains(text(),'Kapüşonlu Kız Çocuk Mont')]")
    WebElement thirdProduct;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Filtreleme alanına fareyi taşı
    public void moveToFilterArea() {
        actions.moveToElement(filterArea).perform();
    }

    // Beden filtresini aç
    public void hoverOverSizeHeader() {
        actions.moveToElement(sizeHeader).perform(); // Fareyi "Beden" başlığına götürür
    }

    // Beden seçeneklerini seç
    public void selectSizeFilters() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(yasbes)).click();
        sleep(5000);
        Actions actions = new Actions(driver); // Actions nesnesini başlatın
        actions.scrollByAmount(0, 500).perform(); // Örneğin, 500 piksel aşağı kaydır

        wait.until(ExpectedConditions.elementToBeClickable(yasaltı)).click();
        sleep(6000);
        wait.until(ExpectedConditions.elementToBeClickable(yasyedi)).click();
        sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(colorFilter)).click();
//        sleep(9000);
    }

    // Renk filtresine fareyi taşı
    public void moveToColorFilter() {
        // Fareyi renk filtresine doğru yönlendir
        actions.moveToElement(colorFilter).perform();


    }

    // Bej rengi filtresini seç
    public void selectBejColor() throws InterruptedException {
        // Renk filtresine fareyi taşı
        moveToColorFilter();
        actions.scrollByAmount(0, 500).perform();
        wait.until(ExpectedConditions.elementToBeClickable(bej)).click();
        sleep(2000); // Seçimi bekle
    }
    public void selectBestSellers() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(sortButton)).click(); // Sıralama menüsünü aç
        sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(bestSellersOption)).click(); // "En Çok Satanlar" seçeneğini seç
        sleep(3000); // Ürünlerin yeniden yüklenmesini bekle
    }
    public void selectThirdProduct() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(thirdProduct)).click();

    }
}