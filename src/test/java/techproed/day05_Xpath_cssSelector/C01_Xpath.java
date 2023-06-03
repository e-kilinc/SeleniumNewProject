package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //arama kutusuna city bike yazip aratin
        /*ARAMA KUTUSU HTML KODLARI
        <input type="text" id="twotabsearchtextbox" value=""
        name="field-keywords" autocomplete="off" placeholder="Search Amazon"
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">

          */

        //Cesitli Xpath alma yontemleri asagida
        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       // WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

       //  id ile ise asagidaki sekilde locate alabiliriz
        //  driver.findElement(By.id("twotabsearchtextbox"));

        //hybrid bikes bolumune tiklayin
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();
        //xpathi su sekilde de alabiliriz ==> //*[.='Hybrid Bikes']

        //sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class = 'sg-col-inner'])[1]"));
        System.out.println("sonuc yazisi = "+ sonucYazisi.getText());
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("sonuc sayisi = "+ sonucSayisi[0]);


        //ilk urune tiklayin
        driver.findElement(By.xpath("(//h2)[1]")).click();

        //sayfayi kapatin
        driver.close();




    }
}
