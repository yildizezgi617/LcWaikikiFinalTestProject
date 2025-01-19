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
