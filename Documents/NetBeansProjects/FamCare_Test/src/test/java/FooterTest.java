
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTest {

    WebDriver driver;
    WebElement FamcareLogo;
    WebElement FamcareAppImg;
    WebElement DownloadAppText;
    WebElement AppStoreIcon;
    WebElement GooglePlayIcon;
    WebElement FamcareContactImg;
    WebElement FamcareContactText1;
    WebElement FamcareContactText2;
    WebElement ContactIcon;
    WebElement SupportEmailText;
    WebElement SupportEmailLink;
    JavascriptExecutor jse;
    Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        //Initialize driver 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");  
        driver = WebDriverManager.chromedriver().capabilities(options).create();
//        driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(5));//        wait= new WebDriverWait(driver, Duration.ofSeconds(60));        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMinutes(1));        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));        driver.get("https://famcare.app/");    }
        /*
        //Initialize driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(5));
        wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://famcare.app/");
         */
    }
    
        @Test(priority = 1)
    public void FamcareLogoIsDisplayed() {
        FamcareLogo = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(FamcareLogo.isDisplayed(), "Logo is displayed");
    }

    @Test(priority = 1)
    public void FamcareAppImgIsDisplayed() {

        // Find the image element by its attribute(s)
        FamcareAppImg = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(FamcareAppImg.isDisplayed(), "Image is displayed");
    }

    @Test(priority = 2)
    public void DownloadAppTextIsDisplayed() {
        DownloadAppText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/h3"));
        Assert.assertTrue(DownloadAppText.isDisplayed());
    }

    @Test(priority = 3)
    public void DownloadAppTextIsCorrect() {
        Assert.assertEquals(DownloadAppText.getText(), "حمل التطبيق وابدأ جلستك الأولى");
    }

    @Test(priority = 4)
    public void DownloadAppThrougGooglePlayIsEnabled() {
        GooglePlayIcon = driver.findElement(By.cssSelector(".google-app-downloads"));
        Assert.assertTrue(GooglePlayIcon.isEnabled());
    }

    @Test(priority = 5)
    public void DownloadAppThrougGooglePlayIsClickable() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", GooglePlayIcon);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GooglePlyIcon);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".google-app-downloads")));
        wait.until(ExpectedConditions.elementToBeClickable(GooglePlayIcon));
        //driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
        GooglePlayIcon.click();
        driver.close();
    }

    /*
        @Test(priority = 6)
    public void DownloadAppThrougAppStoreIconIsEnabled() {
        AppStoreIcon = driver.findElement(By.cssSelector(".apple-app-downloads"));
        AppStoreIcon.isEnabled();
    }
        @Test(priority = 7)
    public void DownloadAppThrougAppStoreIsClickable() {
        //wait.until(ExpectedConditions.elementToBeClickable(AppStoreIcon));
        AppStoreIcon.click();
    }
     */
    @Test(priority = 8)
    public void FamcareContactImgIsDisplayed() {
        // Find the image element by its attribute(s)
        FamcareContactImg = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[2]/img"));
        Assert.assertTrue(FamcareContactImg.isDisplayed(), "Image is displayed");
    }

    @Test(priority = 9)
    public void FamcareContactText1IsDisplayed() {
        FamcareContactText1 = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/h3"));
        Assert.assertTrue(FamcareContactText1.isDisplayed());
    }

    @Test(priority = 10)
    public void FamcareContCText1IsCorrect() {
        Assert.assertEquals(FamcareContactText1.getText(), "نحن هنا لمساعدتك");
    }

    @Test(priority = 11)
    public void FamcareContactText2IsDisplayed() {
        FamcareContactText2 = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/span"));
        Assert.assertTrue(FamcareContactText2.isDisplayed());
    }

    @Test(priority = 12)
    public void FamcareFooterText2IsCorrect() {
        Assert.assertEquals(FamcareContactText2.getText(), "تواصل معنا من خلال قنوات التواصل");
    }

    @Test(priority = 13)
    public void ContactIconIsDisplayed() {
        // Find the image element by its attribute(s)
        ContactIcon = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[1]/img"));
        Assert.assertTrue(ContactIcon.isDisplayed(), "Icon is displayed");
    }

    @Test(priority = 14)
    public void SupportEmailTextIsDisplayed() {
        SupportEmailText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[2]/p"));
        Assert.assertTrue(SupportEmailText.isDisplayed());
    }

    @Test(priority = 15)
    public void SupportEmailTextIsCorrect() {
        Assert.assertEquals(SupportEmailText.getText(), "الدعم عبر البريد الإكتروني");
    }

    @Test(priority = 16)
    public void SupportEmailLinkIsDisplayed() {
        SupportEmailLink = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[2]/a"));
        Assert.assertTrue(SupportEmailLink.isDisplayed());
    }

    @Test(priority = 17)
    public void SupportEmailLinkIsCorrect() {
        Assert.assertEquals(SupportEmailLink.getText(), "hi@famcare.app");
    }

    @Test(priority = 18)
    public void SupportEmailLinkIsClickable() {
        SupportEmailLink.click();
        driver.close();
    }

}

/*
    @Test(priority = 15)
    public void scrollTopIsDisplayed() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,500)");
        WebElement scrollTop= driver.findElement(By.cssSelector("svg.ast-arrow-svg"));
        Assert.assertTrue(scrollTop.isDisplayed());
 */
    /*
    @Test(priority = 1)
    public void scrollDownITofooter(WebDriver driver) throws InterruptedException {
         jse = (JavascriptExecutor) driver;
         jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //jse.executeScript("window.scrollBy(0,500)");
    }
     */
/*
    @Test(priority = 12)
    public void SupportEmailLinkIsClickable() {
        SupportEmailLink.click();
        // Switch to the new tab (assuming it's the last tab opened)
        String originalTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        driver.switchTo().window(originalTab);
    }
*/
    /*
        public void FamcareLinkColorStaysPurpleOnHover() {
        // Get the initial color of the Famcare link (should be purple)
        String initialColor = FamcareLink.getCssValue("background-color");

        // Perform the hover action on the Famcare link
        Actions actions = new Actions(driver);
        actions.moveToElement(FamcareLink).perform();

        // Get the color after hover
        String colorAfterHover = FamcareLink.getCssValue("color");

        // Assert that the color remains purple after hover
        Assert.assertEquals(initialColor, colorAfterHover, "Link color should stay purple on hover");
    }
    */
/*
    @Test(priority = 9)
    public void scrollDownIsDisplayed(WebDriver driver, WebElement element) throws InterruptedException {
        jse.executeScript("window.scrollBy(0,500)");
        WebElement scrollDown = driver.findElement(By.cssSelector("svg.ast-arrow-svg"));
        Assert.assertTrue(scrollDown.isDisplayed());
    }
    @Test(priority = 10)

    public  void scrollToElement(WebDriver driver, WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test(priority = 7)
    public void BookyourFirstSessionButtonIsClickable() {
        // Save the current window handle (the web page)
        OriginalWindow = driver.getWindowHandle();
        BookyourFirstSessionButton.click();
        //Switch back to the old tab or window
        driver.close();
        driver.switchTo().window(OriginalWindow);
    }

/*
        @Test(priority = 1)
    public void scrollDownToFooter() throws InterruptedException {
        WebElement footer = driver.findElement(By.xpath("/html/body/footer"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the footer
        actions.scrollToElement(footer).perform();
        Thread.sleep(5000);
    }
    
*/