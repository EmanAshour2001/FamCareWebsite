
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Footer {

    WebDriver driver;
    WebElement FamcareLogo;
    WebElement FamcareContactText1;
    WebElement FamcareContactText2;
    WebElement ContactIcon;
    WebElement SupportEmailText;
    WebElement SupportEmailLink;
    WebElement EmailField;
    WebElement JoinButton;
    WebElement FamcareAppImg;
    WebElement JoinFamcareSocietyText;
    WebElement DownloadAppText;
    WebElement AppStore;
    WebElement GooglePlay;
    WebElement Copyright;
    WebElement PrivacyPolicy;
    WebElement TermsOfUse;
    WebElement WhoWeAre;
    String originalWindowHandle;
    WebElement InstgramIcon;
    WebElement InstgramLink;
    WebElement TwitterIcon;
    WebElement TwitterLink;
    //Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        //Initialize driver 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        //driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(5));
        //wait= new WebDriverWait(driver, Duration.ofSeconds(60));     
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.get("https://famcare.app/");
        originalWindowHandle = driver.getWindowHandle(); // Store the handle of the original window

    }
    //Footer Top
    @Test(priority = 1)
    public void scrollDownToFooter() throws InterruptedException {
        WebElement footer = driver.findElement(By.xpath("/html/body/footer"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the footer
        actions.scrollToElement(footer).perform();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void FamcareLogoIsDisplayed() {
        FamcareLogo = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(FamcareLogo.isDisplayed(), "Logo is displayed");
    }

    @Test(priority = 3)
    public void FamcareContactText1IsDisplayed() {
        FamcareContactText1 = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/h3"));
        Assert.assertTrue(FamcareContactText1.isDisplayed());
    }

    @Test(priority = 4)
    public void FamcareContaCText1IsCorrect() {
        Assert.assertEquals(FamcareContactText1.getText(), "نحن هنا لمساعدتك");
    }

    @Test(priority = 5)
    public void FamcareContactText2IsDisplayed() {
        FamcareContactText2 = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/span"));
        Assert.assertTrue(FamcareContactText2.isDisplayed());
    }

    @Test(priority = 6)
    public void FamcareFooterText2IsCorrect() {
        Assert.assertEquals(FamcareContactText2.getText(), "تواصل معنا من خلال قنوات التواصل");
    }

    @Test(priority = 7)
    public void ContactIconIsDisplayed() {
        ContactIcon = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[1]/img"));
        Assert.assertTrue(ContactIcon.isDisplayed(), "Icon is displayed");
    }

    @Test(priority = 8)
    public void SupportEmailTextIsDisplayed() {
        SupportEmailText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[2]/p"));
        Assert.assertTrue(SupportEmailText.isDisplayed());
    }

    @Test(priority = 9)
    public void SupportEmailTextIsCorrect() {
        Assert.assertEquals(SupportEmailText.getText(), "الدعم عبر البريد الإكتروني");
    }

    @Test(priority = 10)
    public void SupportEmailLinkIsDisplayed() {
        SupportEmailLink = driver.findElement(By.xpath("//html/body/footer/div[1]/div/div/div[1]/div/div[2]/div[1]/div[2]/a"));
        Assert.assertTrue(SupportEmailLink.isDisplayed());
    }

    @Test(priority = 11)
    public void SupportEmailLinkIsCorrect() {
        Assert.assertEquals(SupportEmailLink.getText(), "hi@famcare.app");
    }

    @Test(priority = 12)
    public void SupportEmailLinkIsClickable() {
        SupportEmailLink.click();
        driver.navigate().to("https://famcare.app/");
    }

    @Test(priority = 13)
    public void JoinFamcareSocietyTextIsDisplayed() {
        JoinFamcareSocietyText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/h6"));
        Assert.assertTrue(JoinFamcareSocietyText.isDisplayed());
    }

    @Test(priority = 14)
    public void JoinFamcareSocietyTextIsCorrect() {
        Assert.assertEquals(JoinFamcareSocietyText.getText(), "انضم الى مجتمع المعرفة والخبرة النفسية والزواجية");
    }

    @Test(priority = 15)
    public void verifyEmailFieldIsDisplayed() {
        EmailField = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-2\"]/div[1]/div/input[1]"));
        //EmailField = driver.findElement(By.cssSelector(".mail-list-email"));
        Assert.assertTrue(EmailField.isDisplayed());
    }

    @Test(priority = 16)
    public void verifyEmailFieldIsCorrect() {
        Assert.assertEquals(EmailField.getAttribute("placeholder"), "بريدك الالكتروني");
    }

    @Test(priority = 17)
    public void verifySubscriptionButtonDisplayed() {
        JoinButton = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-2\"]/div[1]/div/input[2]"));
        //JoinButton = driver.findElement(By.cssSelector(".mail-list-submit"));
        Assert.assertTrue(JoinButton.isDisplayed());
    }

    @Test(priority = 18)
    public void verifySubscriptionButtonIsCorrect() {
        Assert.assertEquals(JoinButton.getAttribute("value"), "اشتراك");
    }

    @Test(priority = 19)
    public void verifyEnteringValueinEmailField() {
        EmailField.sendKeys("eman.a.2001@hotmail.com");
    }

    @Test(priority = 20)
    public void verifySubscriptionButtonIsClickable() {
        JoinButton.click();
        //Assert.assertEquals(JoinButton.getText(), "تم الانضمام للقائمة البريدية بنجاح");
        driver.navigate().back();
    }

    @Test(priority = 21)
    public void DownloadAppTextIsDisplayed() {
        DownloadAppText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/h3"));
        Assert.assertTrue(DownloadAppText.isDisplayed());
    }

    @Test(priority = 22)
    public void DownloadAppTextIsCorrect() {
        Assert.assertEquals(DownloadAppText.getText(), "حمل التطبيق وابدأ جلستك الأولى");
    }

    @Test(priority = 23)
    public void DownloadAppThrougGooglePlayIsEnabled() {
        GooglePlay = driver.findElement(By.cssSelector(".google-app-downloads"));
        Assert.assertTrue(GooglePlay.isEnabled());
    }

    //Unwork
    @Test(priority = 24)
    public void DownloadAppThrougGooglePlayIsClickable() {
        GooglePlay.click();
    }

    @Test(priority = 25)
    public void DownloadAppThrougAppStoreIsEnabled() {
        AppStore = driver.findElement(By.cssSelector(".google-app-downloads"));
        Assert.assertTrue(AppStore.isEnabled());
    }

    //Unwork
    @Test(priority = 26)
    public void DownloadAppThrougAppStoreIsClickable() {
        //swait.until(ExpectedConditions.elementToBeClickable(AppStoreIcon));
        AppStore.click();
    }

    @Test(priority = 27)
    public void FamcareAppImgIsDisplayed() {
        // Find the image element by its attribute(s)
        FamcareAppImg = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(FamcareAppImg.isDisplayed(), "Image is displayed");
    }
//Footer Bottom

    @Test(priority = 28)
    public void CopyrightTextIsDisplayed() {
        Copyright = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[1]/div/p"));
        Assert.assertTrue(Copyright.isDisplayed());
    }

    @Test(priority = 29)
    public void CopyrightTextIsCorrect() {
        Assert.assertEquals(Copyright.getText(), "© فامكير 2022");
    }

    //Test the footer Menue
    @Test(priority = 30)
    public void PrivacyPolicyLinkIsDisplayed() {
        PrivacyPolicy = driver.findElement(By.xpath("//*[@id=\"menu-item-448\"]/a"));
        Assert.assertTrue(PrivacyPolicy.isDisplayed());
    }

    @Test(priority = 31)
    public void PrivacyPolicyLinkIsCorrect() {
        Assert.assertEquals(PrivacyPolicy.getText(), "سياسة الخصوصية");
    }

    @Test(priority = 32)
    public void verifyPrivacyPolicyLinkIsClickable() {
        PrivacyPolicy.click();
        driver.navigate().back();
    }

    @Test(priority = 33)
    public void TermsOfUseLinkIsDisplayed() {
        TermsOfUse = driver.findElement(By.xpath("//*[@id=\"menu-item-449\"]/a"));
        Assert.assertTrue(TermsOfUse.isDisplayed());
    }

    @Test(priority = 34)
    public void TermsOfUseLinkIsCorrect() {
        Assert.assertEquals(TermsOfUse.getText(), "شروط الاستخدام");
    }

    @Test(priority = 35)
    public void verifyTermsOfUseLinkIsClickable() {
        TermsOfUse.click();
        driver.navigate().back();
    }

    @Test(priority = 36)
    public void WhoWeAreIsDisplayed() {
        WhoWeAre = driver.findElement(By.xpath("//*[@id=\"menu-item-450\"]/a"));
        Assert.assertTrue(WhoWeAre.isDisplayed());
    }

    @Test(priority = 37)
    public void WhoWeAreIsCorrect() {
        Assert.assertEquals(WhoWeAre.getText(), "من نحن");
    }

    @Test(priority = 38)
    public void verifyWhoWeAreLinkIsClickable() {
        WhoWeAre.click();
        driver.navigate().back();
    }

    @Test(priority = 39)
    public void TwitterIconIsDisplayed() throws InterruptedException {
        TwitterIcon = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[2]/ul/li[1]/a/img"));
        Assert.assertTrue(TwitterIcon.isDisplayed(), "Twitter Icon is displayed");
    }

    @Test(priority = 40)
    public void verifyTwitterLinkIsClickableandopenFamCareAccount() throws InterruptedException {
        TwitterLink = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[2]/ul/li[1]/a"));
        TwitterLink.click();
        Thread.sleep(5000);
        //Switch back to the old window
        driver.switchTo().window(originalWindowHandle);
    }

    @Test(priority = 41)
    public void InstgramIconIsDisplayed() throws InterruptedException {
        InstgramIcon = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[2]/ul/li[2]/a/img"));
        Assert.assertTrue(InstgramIcon.isDisplayed(), "Instgram Icon is displayed");
    }

    @Test(priority = 42)
    public void verifyInstgramIconIsClickableandopenFamCareAccount() throws InterruptedException {
        InstgramLink = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[2]/ul/li[2]/a/img"));
        InstgramLink.click();
        Thread.sleep(5000);
        //Switch back to the old tab or window
        driver.switchTo().window(originalWindowHandle);
    }

}
