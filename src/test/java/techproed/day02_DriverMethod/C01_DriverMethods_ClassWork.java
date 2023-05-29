package techproed.day02_DriverMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Sayfa basliginin Amazon icerdigini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //URLin https://www.amazon.com/ oldugunu test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED -> "+ actualUrl);
        }
        //Sayfayi kapatalim
        driver.close(); //Browseri kapatir
        //driver.quit(); birden fazla browser varsa hepsini kapatir



    }
}
