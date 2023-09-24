
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
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

public class JoinAsSpecialist {

    WebDriver driver;
    WebElement JoinAsSpecialistButton;
    WebElement FormTitle;
    WebElement Name;
    // WebElement NameIcon;
    WebElement MobileNumber;
    // WebElement MobileIcon;
    WebElement Degree;
    // WebElement DegreeIcon;
    WebElement Specialization;
    //WebElement SpecializationIcon;
    WebElement YearsOfExperience;
    // WebElement ExperienceIcon;
    WebElement SocialMediaActiviy;
    // WebElement SocialMediaIcon;
    WebElement SendButton;
    WebElement CloseIcon;
    WebElement LoadingIcon;
    Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        //Initialize driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://famcare.app/");
    }

    @Test(priority = 1)
    public void NavigatetoTheJounAsSpecialistFotrm() {
        JoinAsSpecialistButton = driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/button"));
        JoinAsSpecialistButton.click();
    }

    @Test(priority = 2)
    public void FormTitleIsDisplayed() {
        FormTitle = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/h2"));
        Assert.assertTrue(FormTitle.isDisplayed());
    }

    @Test(priority = 3)
    public void FormTitleIsCorrect() {
        Assert.assertEquals(FormTitle.getText(), "الرجاء إدخال المعلومات لنقوم بالتواصل معكم");
    }

    @Test(priority = 4)
    public void DefineTheLocatorsforEachElementsInForm() {
        //Define The Locators for Each Elements in the form
        Name = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[2]/input"));
        MobileNumber = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[3]/input"));
        Degree = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[4]/input"));
        Specialization = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[5]/input"));
        YearsOfExperience = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[6]/input"));

        SocialMediaActiviy = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[7]/input"));
    }

    @Test(priority = 5)
    public void VerifyNamFieldTextIsCorrect() {
        //Content bug:الاسم
        Assert.assertEquals(Name.getAttribute("placeholder"), "الإسم الثلاثي");
    }

    @Test(priority = 6)
    public void VerifyMobileVieldTextIsCorrect() {
        //Content bug:الاسم
        Assert.assertEquals(MobileNumber.getAttribute("placeholder"), "الجوال");
    }

    @Test(priority = 7)
    public void VerifyDegreeFieldTextIsCorrect() {
        //Content bug:الاسم
        Assert.assertEquals(Degree.getAttribute("placeholder"), "الدرجة العلمية");
    }

    @Test(priority = 8)
    public void VerifySpecializationFieldTextIsCorrect() {
        Assert.assertEquals(Specialization.getAttribute("placeholder"), "التخصص العلمي");
    }

    @Test(priority = 9)
    public void VerifyYearsOfExperienceFieldTextIsCorrect() {
        Assert.assertEquals(YearsOfExperience.getAttribute("placeholder"), "عدد سنوات الخبرة في مجال الاستشارات؟");
    }

    @Test(priority = 10)
    public void VerifySocialMediaActivityFieldTextIsCorrect() {
        Assert.assertEquals(SocialMediaActiviy.getAttribute("placeholder"), "هل لديك نشاط فعال في منصات التواصل الاجتماعي");
    }

    @Test(priority = 11)
    public void VerifytSendingDataInTheForm() {
        Name.sendKeys("Eman Ashour");
        MobileNumber.sendKeys("0596535986");
        Degree.sendKeys("Bachelor's");
        Specialization.sendKeys("الهندسة");
        YearsOfExperience.sendKeys("1");
        SocialMediaActiviy.sendKeys(" Yes, On Istgram");

    }

    @Test(priority = 12)
    public void SendButtonIsClickable() {
        //wait.until(ExpectedConditions.elementToBeClickable(SendButton));
        SendButton = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/input"));
        SendButton.click();
    }

    @Test(priority = 13)
    public void CloseIconIsDisplayed() {
        CloseIcon = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button"));
        Assert.assertTrue(FormTitle.isDisplayed());
    }

    @Test(priority = 14)
    public void CloseIconIsClickable() throws InterruptedException {
        Thread.sleep(5000);
        CloseIcon.click();
    }

    @Test(priority = 15)
    public void VerifyLoadingIconIsDisplayed() throws InterruptedException {
        LoadingIcon = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/span"));
        Assert.assertTrue(FormTitle.isDisplayed());
    }
}
