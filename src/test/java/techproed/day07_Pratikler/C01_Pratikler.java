package techproed.day07_Pratikler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Pratikler {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//    1-C01_TekrarTesti isimli bir class olusturun
//    2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        Thread.sleep(3000);
//
//    3- cookies uyarisini kabul ederek kapatin
        WebElement accept = driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]"));
        accept.click();
//    4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa Google iceriyor");
        }else System.out.println("Sayfa Google icermiyor "+ actualTitle);
//    5. Arama cubuguna “Nutella” yazip aratin
        WebElement arama = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        arama.sendKeys("Nutella");
        arama.submit();

//    6. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText()); //About 109,000,000 results (0.41 seconds)
//        String [] sonucSayisi = sonucYazisi.getText().split(" "); //About 109,000,000 results (0.41 seconds)
//        System.out.println("sonuc sayisi = "+ sonucSayisi[1]);

        String sonuc = sonucYazisi.getText().split(" ")[1];//109,000,000
        System.out.println("sonuc = "+ sonuc);
        String snc = sonuc.replaceAll(",","");
        int sonucInt= Integer.parseInt(snc); //Stringi integer degere cevirmek icin

//    7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if (sonucInt>10000000){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");


//    8. Sayfayi kapatin
        driver.close();

    }
}
