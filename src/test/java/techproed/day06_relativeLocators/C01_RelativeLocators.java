package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasina gidin
        driver.get("https://www.amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altındaki elemente tıklayalım
        //WebElementlerin yazisini konsola yazdiralim
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBike.getText());
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBike));
        System.out.println(electricBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        System.out.println(completeBike.getText());
        System.out.println("*************************************");

        //Bikes altindaki tum WebElementleri konsola yazdiralim
        List<WebElement> linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>8 and position()<16]"));

        /*
        XPATH kullaniminda bir sayfadaki webelementlere mudahale etmek istedigimizde xpath ile locate aldigimizda
        birden fazla sonuc verebilir.
        [position()>8 and position()<16] kullanimiyla aralik belirterek istedigimiz Webelementleri secip mudahale edebilirz
         */

        //Lambda ile yazdirdik
        linklerListesi.forEach(t -> System.out.println(t.getText()));
        System.out.println("***************************************");

        //forEach ile yazdirmak istersek
        for (WebElement w : linklerListesi) {
            System.out.println(w.getText());
        }

        //Bu Linklerin hepsine tiklayalim ve sayfa basliklarini alalim
        for (int i = 0; i < linklerListesi.size(); i++) {
            linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>8 and position()<16]"));
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(3000);

            driver.navigate().back();
            Thread.sleep(3000);

        }



        //completeBike.click();
    }
}
