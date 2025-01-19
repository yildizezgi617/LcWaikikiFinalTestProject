# LCW Otomasyon Projesi
Bu proje, Selenium, Java, TestNG ve Maven kullanarak geliştirilen bir test otomasyon sistemini içermektedir. Web uygulamalarını test etmek amacıyla çeşitli testler oluşturulmuş ve POM (Page Object Model) tasarım deseni kullanılmıştır. Ayrıca, Allure Report ile test sonuçlarının görselleştirilmesi sağlanmıştır.

### Kullanılan Teknolojiler
Java: Testlerin yazılması ve yürütülmesi için kullanılan ana programlama dili.                  
Selenium WebDriver: Web uygulamalarını test etmek için kullanılan araç.                         
TestNG: Testlerin yönetilmesi ve raporlanması için kullanılan çerçeve.                         
Maven: Bağımlılık yönetimi ve proje yapılandırması için kullanılan araç.                        
POM (Page Object Model): Testlerin daha sürdürülebilir ve okunabilir olması için kullanılan tasarım deseni.

## Proje Yapısı
Proje, şu ana başlıklardan oluşmaktadır:

BaseTest: Testlerin başlatılması, yapılandırılması ve temizlenmesi için kullanılan temel sınıf.                                                                                                                     
Page Object Model: Web sayfalarına karşılık gelen sayfa nesnelerinin tanımlandığı sınıflar.                                                                                                                         
Test Sınıfları: Gerçek test senaryolarının yazıldığı sınıflar.                                                        

## Kurulum
Java                                                                                                                                                                                                                
Maven                                                                                                                                                                                                               
IDE                                                                                                                                                                                                                 
WebDriver                                                                                                                                                                                                           

## Adım Adım Kurulum 
Adım Adım Kurulum
Proje dosyasını indirin veya klonlayın:

`git clone https://github.com/yildizezgi617/selenium-automation.git`
Maven Bağımlılıklarını İndirin:

Proje kök dizininde terminal açın ve aşağıdaki komutu çalıştırın:
`mvn clean install`

Testleri Çalıştırın:
Maven komutuyla testleri çalıştırabilirsiniz:
`mvn test`

## Test Senaryoları
Test senaryoları, aşağıdaki adımları içerecek şekilde yazılmıştır:               
### 1- Giriş Testi
  + Kullanıcı doğru bilgilerle giriş yapar ve kontrol edilir.
                  
### 2- Kategori Seçim Testi
  + Doğru kategori seçimi yapılır ve kontrol edilir.

### 3- Ürün Filtreleme Testi
  + Ürün renk ve beden filtresi yapılır.
  
### 4- Sıralama  Testi
 + İstenen kritere göre sıralama yapılır.

### 5- Ürün Seçme Testi
  + İstenen ürün seçilir ve detay sayfasına gidilir.

### 6- Ürün Detay Testi
  + Ürün favorilere eklenir, beden seçilir, sepete eklenir.

### 7- Favori Testi
  + Favorilere eklenen ürün favori sayfasında görüntülenir.

### 8- Sepet Testi
  + Sepetteki ürün miktarı arttırılır ve ödemeye geçilir.

### Page Object Model (POM)
Bu projede, her web sayfası için bir Java sınıfı oluşturulmuştur. Bu sınıflar, sayfalarla etkileşime geçmek için gerekli yöntemleri içerir.

Örnek olarak: Login Page Sınıfı
   ```java
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
```



### Login Test Sınıfı ve BaseTest ile İlişkisi
Projede, LoginTest sınıfı BaseTest sınıfını genişleterek (extend) temel yapılandırmayı devralır. BaseTest sınıfında, WebDriver başlatma, testlerin yapılandırılması ve sonlandırılması işlemleri merkezi bir şekilde yapılır. Bu sayede, her test sınıfında aynı kodları tekrar yazmamıza gerek kalmaz.

### baseTest Sınıfı

 ```java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class baseTest {

    // WebDriver instance, tüm testlerde kullanılmak üzere tanımlandı
    public static WebDriver driver;
    private static boolean isInitialized = false; // Driver sadece bir kez başlatılmasını kontrol eder
@BeforeSuite
    public void setUp() {
    // Eğer driver null ise yeni bir ChromeDriver başlat
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Eleman bulma işlemleri için zaman aşımı
            // Pencereyi maksimum boyuta getir
        }
    // Sadece bir kez başlangıç URL'sine gitmek için kontrol
        if (!isInitialized) {
            driver.get("https://www.lcw.com"); // Başlangıç URL’si
            isInitialized = true; // Başlangıç ayarı bir kez yapılır
        }
    }


@AfterSuite
    public void tearDown() {
    // Testler tamamlandıktan sonra driver'ı kapat
        if (driver != null) {
            driver.quit();
        }
    }

}
```

##### LoginTest Sınıfı:
LoginTest sınıfı BaseTest sınıfından türetilerek test senaryoları yazılır. Bu sınıf sadece test adımlarına odaklanır, temel test yapılandırması BaseTest sınıfından alınır.

 ```java
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
```

### Ekran Görüntüleri
Proje sırasında yapılan testlerin sonuçlarına dair bazı ekran görüntüleri aşağıda yer almaktadır:

#### Giriş Sayfası
Aşağıdaki ekran görüntüsü, geçerli kullanıcı bilgileriyle başarılı bir şekilde giriş yapıldıktan sonraki ana sayfayı göstermektedir:

![Login Page](https://github.com/yildizezgi617/LcWaikikiFinalTestProject/blob/main/LoginPage.PNG?raw=true)

#### Ürün Kategorisi
Ürün kategorilerinin doğru şekilde yüklendiği bir örnek ekran görüntüsü:

![Product Page](https://github.com/yildizezgi617/LcWaikikiFinalTestProject/blob/main/ProductPage.PNG?raw=true)

#### Ürün Detay Sayfası
Ürün detay sayfasının doğru şekilde yüklendiğini gösteren bir ekran görüntüsü:

![ProductDetails Page](https://github.com/yildizezgi617/LcWaikikiFinalTestProject/blob/main/ProductDetailsPage.PNG?raw=true)

### Favorilerim Sayfası
Favorilere eklenen ürünün, favorilerim sayfasında doğru bir şekilde gözüktüğünü gösteren ekran görüntüsü:

![Favorite Page](https://github.com/yildizezgi617/LcWaikikiFinalTestProject/blob/main/FavoritePage.PNG?raw=true)



### Sepetim Sayfası
Sepet sayfasının görüntüsü, eklenen ürünleri ve toplam fiyatı doğrulamak için kullanılır:

![Cart Page](https://github.com/yildizezgi617/LcWaikikiFinalTestProject/blob/main/CartPage.PNG?raw=true)


### Katkıda Bulunma
Bu projeye katkıda bulunmak için aşağıdaki adımları takip edebilirsiniz:

+ Bu depo ile ilgili bir fork oluşturun.
+ Kendi değişikliklerinizi yapın.
+ Değişikliklerinizi bir pull request ile ana depoya gönderin.

Teşekkürler.
