package techproed.day02_DriverMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        implicitlyWait(Duration.ofSeconds(20) Sayfadaki web elementleri gorunur olana kadar
        yani sayfada olusana kadar maximum 20 saniye bekler.
        Eger web elementler 3 saniyede olusursa 3 saniye bekler ve alt satira gecer.
        Fakat belirttigimiz max sure boyunca internetten ya da saydadan kaynakli olarak
        web elementler olusmazsa fail verir

        Thread.sleep()java kodlarini bizim belirttigimiz sure kadar bekler. 30 saniye beklemesini
        belirtirsem 30 saniye bekler ve alt satira gecer.

       */

        //techproeducation sayfasina gidelim
        String techproUrl = "https://techproeducation.com";
        String amazonUrl= "https://amazon.com";
        driver.get(techproUrl);

        //amazona gidelim
        driver.get(amazonUrl);

        //techproya geri donelim
        driver.navigate().back();

        //sayfa basliginin Techpro icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed-> "+ actualTitle);
        }

        //tekrar amazon sayfasina gidelim
        driver.navigate().forward();

        //sayfa basliginin Amazon icerdigini test edelim
        if (driver.getTitle().contains("Amazon")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        //sayfayi kapatiniz
        driver.close();


    }
}
