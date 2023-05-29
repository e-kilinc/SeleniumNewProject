package techproed.day02_DriverMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasina gidelim
        driver.navigate().to("https://techproeducation.com");//get () methodu ile ayni mantikta calisir
        Thread.sleep(3000);//Java kodlarini bekletmek icin Thread.sleep () kullanabuliriz

        //Amazon sayfasina gidelim
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);

        //Amazon sayfasinin basligini yazdiralim
        System.out.println("Amazon sayfa basligi: " + driver.getTitle());
        Thread.sleep(3000);

        //Techproeducation sayfasina geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdiralim
        System.out.println("Techpro sayfa basligi: " + driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasina tekrar gidip url yi yazdiralim
        driver.navigate().forward();
        System.out.println("Amazon sayfasi Url`i"+ driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasindayken sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //sayfayi kapatalim
        driver.close();


    }
}
