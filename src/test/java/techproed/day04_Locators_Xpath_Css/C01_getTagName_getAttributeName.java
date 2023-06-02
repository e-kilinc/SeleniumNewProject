package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTagName_getAttributeName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon.com`a gidip arama kutusunu locate edin
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusunun tagnameinin input oldugunu test edin
        String actualTagName = aramaKutusu.getTagName();
        System.out.println("actualTagName = " + actualTagName);

        String expectedTagName = "input";
        if (actualTagName.equalsIgnoreCase(expectedTagName)){
            System.out.println("Test Passed");

        }else System.out.println("Test Failed");

        //arama kutusunun name attributeunun degerinin field-keywords oldugunu test edin

        String actualAttributeName = aramaKutusu.getAttribute("name");
        System.out.println("actualAttributeName = " + actualAttributeName);
        String expectedAttributeName = "field-keywords";
        if (actualAttributeName.equalsIgnoreCase(expectedAttributeName)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //sayfayi kapatiniz
        driver.close();

    }
}
