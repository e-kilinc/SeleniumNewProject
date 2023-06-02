package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //arama kutusuna city bike yazip aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //sonuc yazisini yazdirin
        List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());

        //Xpath ile list kullanmadan tek seferde locate aldık
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        //sonuc sayisini yazdirin
        String [] sonucSayisi = sonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc sayisi = "+sonucSayisi[2]);

        //Sayfadaki 12. elementi list kullanmadan xpath'in index özelliğini kullanarak locate aldık
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        //ilk urunun locatini alin
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkurun = urunler.get(0);

        //ilk urunun gorunur olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkurun.isDisplayed());

        //ilk urunun erisilebilir olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkurun.isEnabled());

        //ilk urunun secilebilir olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkurun.isSelected());//false doner cunku Webelement secilme ozelligine sahip degil

        //ilk urune tiklayin
        ilkurun.click();

        //sayfayi kapatin
        driver.close();

        /*
            //ARAMA KUTUSUNUN HTML KODLARI
            <input type="text" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
            tabindex="0" aria-label="Search Amazon" spellcheck="false">
             */
        //Relative Xpath syntax -->  //tagname[@attributeName='atributeValue']
        //input[@type='text']
        //                            (//input[@type='text'])[1]
        //                            //*[@type='text']
    /*
        Aldığımız xpath unique olmadığı zaman xpath'imizi parantez içine alarak index belirtebiliriz.
    Böylelikle webelementleri Liste atıp istediğimiz elementi almakla uğraşmayız.
    Xpath'in değişik kullanma yolları vardır.
     */


        //Techproeducation sayfasına gidelim
        //Çıkan reklamı locate edip kapatalım
        //Arama bölümünde qa aratalım
        //Sayfa başlığının qa içerdiğini doğrulayalım
        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        //Carrer Opportunities In QA linkine tıklayalım
        //Başlığın Opportunities içerdiğini test edelim
        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım



        //





    }
}
