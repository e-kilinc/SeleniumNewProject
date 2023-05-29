package techproed.day01_IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        //getTitle() Sayfa basligini verir
        System.out.println("Amazon sayfa basligi: "+ driver.getTitle());
        System.out.println("Amazon URL : "+ driver.getCurrentUrl());
        String amazonWindowHandle= driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri: "+ amazonWindowHandle);

        //getTitle() methodu sayfa basligini verir
        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation sayfa basligi: "+ driver.getTitle());


        //getCurrentUrl() gidilen sayfanin URL sini verir
        System.out.println("Techpro URL : "+ driver.getCurrentUrl());

        //driver.getPageSource() icinde olunan sayfanin kodlarini String olarak getirir
        //System.out.println(driver.getPageSource()); bilerek yoruma aldik.
        //her calistirdigimizda birsuru kod verecegi icin

        //getWindowHandle() Gidilen sayfanin handle degerini (hashkod) verir.
        //Bu handle degerini sayfalar arasi gecis icin kullaniriz
        System.out.println("Techpro Window Handle Degeri: "+ driver.getWindowHandle());


    }
}
