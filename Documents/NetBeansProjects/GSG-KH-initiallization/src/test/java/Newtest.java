



import io.github.bonigarcia.wdm.WebDriverManager;
import static java.lang.Thread.sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */
public class Newtest {
WebElement ContactButton;
WebElement submitButton;
WebDriver driver;
JavascriptExecutor jse;
    @BeforeClass
 
    public void setup() {
        //Initiallization Driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        
        driver.get("https://wewill.tech");
   

    }
   @Test
    public void submitDisplay(){
     ContactButton = driver.findElement(By.xpath("//*[@id=\"Contact\"]/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/button"));
     Assert.assertTrue(ContactButton.isDisplayed());
    }
    @Test
     public void submitClick(){
     ContactButton = driver.findElement(By.xpath("//*[@id=\"Contact\"]/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/button"));
     ContactButton.click();
    } 
     @Test (priority =4)
       public void scrollTopIsDisplayed() throws InterruptedException{
        jse.executeScript("window.scrollBy(0,500)");
        sleep(3000);
        
    }
     ContactButton = driver.findElement(By.xpath("//*[@id=\"Contact\"]/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/button"));
     ContactButton.click();
    } 
    }



