package allureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void logo(){
        boolean disstatus = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
        Assert.assertEquals(disstatus, true);
    }

    @Test(priority = 5)
    public void login(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("somebodylikeme@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("test@4321");
//        driver.findElement(By.id("button-1")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();

//        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");
    }

    @Test(priority = 2)
    public void registration(){
        driver.findElement(By.linkText("Register")).click();
//
        driver.findElement(By.id("FirstName")).sendKeys("Gabi");
        driver.findElement(By.id("LastName")).sendKeys("Tendong");
//        driver.findElement(By.id("Street")).sendKeys("Somewhere");
//        driver.findElement(By.id("City")).sendKeys("Yaoundé");
//
//        Select select = new Select(driver.findElement(By.id("Country")));
//        select.selectByVisibleText("Cameroon");
//
//        driver.findElement(By.id("Postal Code")).sendKeys("237");
//        driver.findElement(By.id("Telephone number")).sendKeys("+237 690000000");
//        driver.findElement(By.id("Username")).sendKeys("GabiTendong");
        driver.findElement(By.id("Email")).sendKeys("gabitendongg@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("gabitendong237");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("gabitendong237");
//
//        WebElement checkbox = driver.findElement(By.id("Yes"));
//        boolean isChecked = checkbox.isSelected();
//        if (!isChecked) {
//            checkbox.click();
//        }
//
//        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[5]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
    }

    @Test(priority = 3)
    public void navigateToContinue(){
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[2]/a")).click();
    }

    @Test(priority = 4)
    public void logout(){
        driver.findElement(By.linkText("Log out")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
