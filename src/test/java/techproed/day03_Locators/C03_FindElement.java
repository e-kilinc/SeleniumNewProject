package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_FindElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Sayfadali linklerin sayisini ve linkleri yazdiralim
        /*
        findElement ile bir webelemente ulasabilirken, birden fazla element icin
        findElements() metodunu kullaniriz.
        Bu WebElementlerin sayisina ulasmak ya da yazisini konsola yazdirabilmek icin ise
        List<webelement> linklerListesi - driver.findElements(By.locator("locator degeri")) olarak kullaniriz.
        Olusturdugumuz listi loop ile konsola yazdirabiliriz.
         */

        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi : "+ linklerListesi.size());

//        for (WebElement w:linklerListesi) {
//            if (!w.getText().isEmpty()){
//                System.out.println(w.getText());
//            }
//        }

        //Lambda ile yazdiralim
        linklerListesi.stream().forEach(w -> {if(!w.getText().isEmpty())
                System.out.println(w.getText());});

        //Shop deals in electronics webElementinin yazisini yazdiralim
        System.out.println("*****************************************************************");
        System.out.println(driver.findElement(By.linkText("Shop deals in Electronics")).getText());

        driver.close();
    }
}
