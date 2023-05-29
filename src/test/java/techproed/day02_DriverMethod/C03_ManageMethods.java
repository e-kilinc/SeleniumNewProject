package techproed.day02_DriverMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Browserin konumunu yazdiralim
        System.out.println("Sayfanin konumu: " +driver.manage().window().getPosition());

        //Browserin boyutlarini yazdiralim
        System.out.println( "Sayfanin boyutlari: " +driver.manage().window().getSize());

        //Browseri maximize yapalim
        driver.manage().window().maximize();

        /* ***************************NOTE**********************************
        Bir web sitesine gittiginizde browser default olarak bir boyutta gelir.
        Acilan browserdadaki web elementlere browser maximize olmadigi icin ulasamayabiliriz.
        Bu nedenle browseri actiktan sonra maximize yaparsak butun web elementleri gorur ve rahatlikla
        mudahale edebiliriz.
        Bu yuzden browseri actiktan sorna ilk olarak driver.manage().window().maximize();
        yapmamiz webelementlere ulasmada isimizi kolaylastirir.
         */


        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Browserin konumunu yazdiralim
        System.out.println("Sayfanin konumu: " +driver.manage().window().getPosition());

        //Browserin boyutlarini yazdiralim
        System.out.println("Sayfanin boyutlari: " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi minimize yapalim
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //Sayfayi fullscreen yapalim
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //Sayfayi kapatiniz
        driver.close();
    }
}
