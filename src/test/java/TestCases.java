import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import  org.junit.Before;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.io.PrintWriter;
import java.util.Random;

public class TestCases {


    protected WebDriver driver = new ChromeDriver();
    public static String loginUrl = "https://www.n11.com/giris-yap";


    @Test
    public void loginAndProductSearch(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"n11_testAutomation\\chromedriver.exe");


        driver.get("https://www.n11.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement elm = driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
        elm.click();

        WebElement textBoxUsername = driver.findElement(By.name("email"));
        WebElement textBoxPassword = driver.findElement(By.name("password"));
        WebElement loginOkeyButton = driver.findElement(By.id("loginButton"));

        textBoxUsername.sendKeys("kt.testautomation@gmail.com");
        textBoxPassword.sendKeys("123456aa.");
        loginOkeyButton.click();
        WebElement checkUsername = driver.findElement(By.cssSelector("#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccount > a.menuLink.user"));
        Assert.assertEquals("test testt",checkUsername.getText());
        System.out.println("Giriş yapıldı.");


        WebElement textBoxSearch = driver.findElement(By.id("searchData"));
        WebElement searchButton = driver.findElement(By.xpath("//a[@title='ARA']"));

        textBoxSearch.sendKeys("Bilgisayar");
        searchButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random r = new Random();
        int low = 29;
        int high = 56;
        int result = r.nextInt(high-low) + low;

        WebElement pageTwo = driver.findElement(By.xpath("//div[@class='pagination']/a[2]"));
        pageTwo.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement productOfSecondPage = driver.findElement(By.xpath("//div[@data-position='"+result+"']//h3"));
        productOfSecondPage.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
