package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElementLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //arama kutusunu locate edelim, iphone yazdiralim ve aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        /*Eger webelementin locatini birden fazla kullanacaksaniz bir Webelemente degisken olarak atayabilirsin.

          Webelement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

         1- Locate islemi bittikten sonra eger webelemente bir metin gondereceksek sendKeys() methodu kullaniriz
         2- webelemente tiklayacaksak click () methodu kullanilir
         3- Webelementin uzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz
         4- sendKeys() methodundan sonra (yani webElemente metin gonderdikten sonra) Keys.ENTER ile ya da submit()
         metodu ile
         */

        //Sayfayi kapatalim
        driver.close();





    }
}
