
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.apache.commons.lang3.ObjectUtils.wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FamcarePage {

    WebDriver driver;
    WebElement StartSessionWithSpicialistText;
    WebElement TakeYourDesisionText;
    WebElement BookyourFirstSessionButton;
    WebElement HeroImage;
    WebElement ScrollDown;
    WebElement ApprovedBySection;
    WebElement ApprovedByOrganization1;
    WebElement ApprovedByOrgImg1;
    WebElement ApprovedByOrganization2;
    WebElement ApprovedByOrgImg2;
    WebElement ApprovedByOrganization3;
    WebElement ApprovedByOrgImg3;
    WebElement ApprovedByOrganization4;
    WebElement ApprovedByOrgImg4;
    WebElement GroupOfSpecalistsSection;
    WebElement ContactNowButton;
    WebElement ConsultingIcon;
    WebElement NumberofConusulting;
    WebElement TakeMinutesInConsultantText;
    WebElement UsersIcon;
    WebElement NumberOfUsers;
    WebElement BeneficiariesText;
    WebElement JointoInformationSociety;
    WebElement EmailField;
    WebElement SubscribtinButton;
    String originalWindowHandle;

    Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        //Initialize driver 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        //driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(5));
        //wait= new WebDriverWait(driver, Duration.ofSeconds(60));     
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
        driver.get("https://famcare.app/");
        originalWindowHandle = driver.getWindowHandle(); // Store the handle of the original window
    }

    //Section 1
    // Test the visibility and text of a link with the text "فامكير" in navigation bar on the FamCare website 
    @Test(priority = 1)
    public void StartSessionWithSpicialistTextIsDisplayed() {
        StartSessionWithSpicialistText = driver.findElement(By.xpath("//*[@id=\"heroText\"]/div/div[1]/h2"));
        Assert.assertTrue(StartSessionWithSpicialistText.isDisplayed());
    }

    @Test(priority = 2)
    public void StartSessionWithSpicialistTextIsCorrect() {
        Assert.assertEquals(StartSessionWithSpicialistText.getText(), "ابدأ جلستك الأولى مع مستشارك الي يناسبك مع خصم 60%");
    }

    @Test(priority = 3)
    public void TakeYourDesisionTextIsDisplayed() {
        TakeYourDesisionText = driver.findElement(By.xpath("//*[@id=\"heroText\"]/div/div[2]/p"));
        Assert.assertTrue(TakeYourDesisionText.isDisplayed());
    }

    @Test(priority = 4)
    public void TakeYourDesisionTextIsCorrect() {
        Assert.assertEquals(TakeYourDesisionText.getText(), "لاتستهين بخطواتك، أخصائيين مرخصين متوفرين بتخصصات مختلفة .. خذ القرار الآن ");
    }

    @Test(priority = 5)
    public void BookyourFirstSessionButtonIsDisplayed() {
        BookyourFirstSessionButton = driver.findElement(By.xpath("//*[@id=\"heroText\"]/div/div[3]/a"));
        Assert.assertTrue(BookyourFirstSessionButton.isDisplayed());
    }

    @Test(priority = 6)
    public void BookyourFirstSessionButtonTextIsCorrect() {
        Assert.assertEquals(BookyourFirstSessionButton.getText(), "احجز جلستك الأولى");
    }
    //هنا اجهت مشكلة لما بضغط عالزر ما بيرجع يعمل ااختبارات اللي وراحتى لو عملت ارجع خطوة حنحلها عن طريق الهاندل

    @Test(priority = 7)
    public void BookyourFirstSessionButtonIsClickable() {
        BookyourFirstSessionButton.click();
        driver.navigate().back();
    }

    @Test(priority = 8)
    public void ImageSectionIsDisplayed() {
        HeroImage = driver.findElement(By.xpath("//*[@id=\"heroSection\"]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(HeroImage.isDisplayed());
    }

    @Test(priority = 9)
    public void scrollDownToSection2() throws InterruptedException {
        WebElement section2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the element
        actions.scrollToElement(section2).perform();
        Thread.sleep(5000);
    }
  
    //Section 2 : تطبيق معتمد من الجهات الرسمية
    @Test(priority = 10)
    public void ApprovedByTextIsDisplayed() {
        ApprovedBySection = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[1]/h2"));
        //Using Css selector failed
        //ApprovedBySection = driver.findElement(By.className(".kc-title"));
        Assert.assertTrue(ApprovedBySection.isDisplayed());
    }

    @Test(priority = 11)
    public void ApprovedBySection2IsCorrect() {
        Assert.assertEquals(ApprovedBySection.getText(), "تطبيق معتمد من الجهات الرسمية");
    }

    @Test(priority = 12)
    public void ApprovedByOrrganization1NameIsDisplayed() {
        //ApprovedByOrganization1 = driver.findElement(By.cssSelector(".kc-elm kc-css-348304 kc_col-sm-3 kc_column_inner kc_col-sm-3"));
        //ApprovedByOrganization1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[4]/div/div[2]/h3"));
        ApprovedByOrganization1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[2]/div/div[2]")));
        Assert.assertTrue(ApprovedByOrganization1.isDisplayed());
    }

    @Test(priority = 13)
    public void ApprovedByOrrganization1NameIsCorrect() {
        Assert.assertEquals(ApprovedByOrganization1.getText(), "مركز طب اتصالي");
    }

    @Test(priority = 14)
    public void ApprovedByOrrganization1ImgIsDisplayed() {
        ApprovedByOrgImg1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[4]/div/div[1]/img"));
        // Check if the image is displayed
        Assert.assertTrue(ApprovedByOrgImg1.isDisplayed(), "Image is displayed");
    }

    @Test(priority = 15)
    public void ApprovedByOrrganization2NameIsDisplayed() {
        ApprovedByOrganization2 = driver.findElement(By.cssSelector(".kc-elm.kc-css-167776.kc-title-wrap.kc-pc-loaded"));
        //ApprovedByOrganization1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[4]/div/div[2]"));
        Assert.assertTrue(ApprovedByOrganization2.isDisplayed());
    }

    @Test(priority = 16)
    public void ApprovedByOrrganization2NameIsCorrect() {
        Assert.assertEquals(ApprovedByOrganization2.getText(), "مركزارشاد اسري");
    }

    @Test(priority = 17)
    public void ApprovedByOrrganization2ImgIsDisplayed() {
        ApprovedByOrgImg2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[3]/div/div[1]/img"));
        // Check if the image is displayed
        Assert.assertTrue(ApprovedByOrgImg2.isDisplayed(), "Image is displayed");
    }

    @Test(priority = 18)
    public void ApprovedByOrrganization3NameIsDisplayed() {
        ApprovedByOrganization3 = driver.findElement(By.cssSelector(".kc-elm.kc-css-167776.kc-title-wrap.kc-pc-loaded"));
        //ApprovedByOrganization1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[4]/div/div[2]"));
        Assert.assertTrue(ApprovedByOrganization3.isDisplayed());
    }

    @Test(priority = 19)
    public void ApprovedByOrrganization3NameIsCorrect() {
        Assert.assertEquals(ApprovedByOrganization1.getText(), "مركزارشاد اسري");
    }

    @Test(priority = 20)
    public void ApprovedByOrrganization3ImgIsDisplayed() {
        ApprovedByOrgImg3 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[2]/div/div[1]/img"));
        // Check if the image is displayed
        Assert.assertTrue(ApprovedByOrgImg3.isDisplayed(), "Image is displayed");
    }

    @Test(priority = 21)
    public void ApprovedByOrrganization4NameIsDisplayed() {
        ApprovedByOrganization4 = driver.findElement(By.cssSelector("kc-elm kc-css-493653 kc-title-wrap kc-pc-loaded"));
        //ApprovedByOrganization1 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[4]/div/div[2]"));
        Assert.assertTrue(ApprovedByOrganization4.isDisplayed());
    }

    @Test(priority = 22)
    public void ApprovedByOrrganization4NameIsCorrect() {
        Assert.assertEquals(ApprovedByOrganization1.getText(), "شركة مجتمعية");
    }

    @Test(priority = 23)
    public void ApprovedByOrrganization4ImgIsDisplayed() {
        ApprovedByOrgImg4 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[1]/div/div[1]/img"));
        // Check if the image is displayed
        Assert.assertTrue(ApprovedByOrgImg4.isDisplayed(), "Image is displayed");
    }

    /*
    @Test(priority = 14)
    public void ApprovedByText2IsDisplayed() {
        ApprovedByText2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[3]/div/div[2]"));
        Assert.assertTrue(ApprovedByText2.isDisplayed());
    }

    @Test(priority = 15)
    public void ApprovedByText2IsCorrect() {
        ApprovedByText2 = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[3]/div/div[2]"));
        Assert.assertEquals(ApprovedByText2.getText(), "مركز ارشاد اسري");
    }
     */
    //Section3
    @Test(priority = 24)
    public void scrollDownToSection3() throws InterruptedException {
        WebElement section3 = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[4]/div/div/div/a"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the element
        actions.scrollToElement(section3).perform();
        Thread.sleep(5000);
    }

    /*
    @Test(priority = 25)
    public void GroupOfSpecalistsTextIsDisplayed() {
        GroupOfSpecalistsSection = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[1]/h2"));
        Assert.assertTrue(GroupOfSpecalistsSection.isDisplayed());
    }
     */
    @Test(priority = 26)
    public void GroupOfSpecalistsSectionTextIsCorrect() {
        Assert.assertEquals(GroupOfSpecalistsSection.getText(), "نخبة من الأخصائيين والمرشدين");
    }

    //Specialist Profile
    @Test(priority = 27)
    public void SpecialistsTalalProfileDisplayed() {
        ContactNowButton = driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-10739cc9ad4d82a6d\"]/div[5]/div"));
        Assert.assertTrue(ContactNowButton.isDisplayed());
    }

    @Test(priority = 28)
    public void ContactNowButtonIsCorrect() {
        Assert.assertEquals(ContactNowButton.getText(), "تواصل الآن");
    }

    @Test(priority = 29)
    public void VerifyContactNowButtonIsClickable() {
        ContactNowButton.click();
        driver.navigate().back();
    }

    @Test(priority = 30)
    public void SupportContactNowButtonDisplayed() {
        ContactNowButton = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[4]/div/div/div/a"));
        Assert.assertTrue(ContactNowButton.isDisplayed());
    }

    /*
    @Test(priority = 28)
    public void ContactNowButtonIsCorrect() {
        Assert.assertEquals(ContactNowButton.getText(), "تواصل الآن");
    }

    @Test(priority = 29)
    public void VerifyContactNowButtonIsClickable() {
        ContactNowButton.click();
        driver.navigate().back();
    }
     */
    //Section 4
    @Test(priority = 31)
    public void ConsultingIconIsDisplayed() {
        ConsultingIcon = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[1]/div/div[1]/img"));
        Assert.assertTrue(ConsultingIcon.isDisplayed());
    }

    @Test(priority = 32)
    public void NumberofConusultingInAppIsDisplayed() {
        NumberofConusulting = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[1]/div/div[2]"));
        Assert.assertTrue(NumberofConusulting.isDisplayed());
    }

    @Test(priority = 33)
    public void NumberofConusultingInAppIsCorrect() {
        Assert.assertEquals(NumberofConusulting.getText(), "+2,000,000");
    }

    @Test(priority = 34)
    public void TakeMinutesInConsultanTexttIsDisplayed() {
        TakeMinutesInConsultantText = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[1]/div/div[3]/p"));
        Assert.assertTrue(TakeMinutesInConsultantText.isDisplayed());
    }

    @Test(priority = 35)
    public void TakeMinutesInConsultantTextIsCorrect() {
        Assert.assertEquals(TakeMinutesInConsultantText.getText(), "دقيقة من الاستشارات والإرشاد");
    }

    @Test(priority = 36)
    public void UsersIconIsDisplayed() {
        UsersIcon = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[2]/div/div[1]/img"));
        Assert.assertTrue(UsersIcon.isDisplayed());
    }

    @Test(priority = 37)
    public void NumberofUsersInAppIsDisplayed() {
        NumberOfUsers = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[2]/div/div[2]/p"));
        Assert.assertTrue(NumberOfUsers.isDisplayed());
    }

    @Test(priority = 38)
    public void NumberofUsersInAppIsCorrect() {
        Assert.assertEquals(NumberOfUsers.getText(), "+500,000");
    }

    @Test(priority = 39)
    public void BeneficiariesTexttIsDisplayed() {
        TakeMinutesInConsultantText = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[2]/div/div[3]/p"));
        Assert.assertTrue(TakeMinutesInConsultantText.isDisplayed());
    }

    @Test(priority = 40)
    public void BeneficiariesTextIsCorrect() {
        Assert.assertEquals(BeneficiariesText.getText(), "مستفيد ومستفيدة");
    }

    @Test(priority = 40)
    public void NvBarTestt() {

    }
    //Section 8
    @Test(priority = 39)
    public void FromBlogTexttIsDisplayed() {
        JointoInformationSociety = driver.findElement(By.xpath("/html/body/div[1]/section[9]/div/div/div/div/div[1]/div"));
        Assert.assertTrue(JointoInformationSociety.isDisplayed());
    }

    @Test(priority = 40)
    public void JointoInformationSocietyTextIsCorrect() {
        Assert.assertEquals(JointoInformationSociety.getText(), "من المدونة");
    }
    //Section 9
    @Test(priority = 39)
    public void JointoInformationSocietyTexttIsDisplayed() {
        JointoInformationSociety = driver.findElement(By.xpath("/html/body/div[1]/section[9]/div/div/div/div/div[1]/div"));
        Assert.assertTrue(JointoInformationSociety.isDisplayed());
    }

    @Test(priority = 40)
    public void JointoInformationSocietTextIsCorrect() {
        Assert.assertEquals(JointoInformationSociety.getText(), "انضم الى مجتمع المعرفة والخبرة النفسية والزواجية");
    }
        @Test(priority = 15)
    public void verifyEmailFieldIsDisplayed() {
        EmailField = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/div/input[1]"));
        //EmailField = driver.findElement(By.cssSelector(".mail-list-email"));
        Assert.assertTrue(EmailField.isDisplayed());
    }

    @Test(priority = 16)
    public void verifyEmailFieldIsCorrect() {
        Assert.assertEquals(EmailField.getAttribute("placeholder"), "بريدك الالكتروني");
    }

    @Test(priority = 17)
    public void verifySubscriptionButtonDisplayed() {
       SubscribtinButton = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-2\"]/div[1]/div/input[2]"));
        //SubscribtinButton = driver.findElement(By.cssSelector(".mail-list-submit"));
        Assert.assertTrue(SubscribtinButton.isDisplayed());
    }

    @Test(priority = 18)
    public void verifySubscriptionButtonIsCorrect() {
        Assert.assertEquals(SubscribtinButton.getAttribute("value"), "اشتراك");
    }

    @Test(priority = 19)
    public void verifyEnteringValueinEmailField() {
        EmailField.sendKeys("eman.a.2001@hotmail.com");
    }

    @Test(priority = 20)
    public void verifySubscriptionButtonIsClickable() {
        SubscribtinButton.click();
        //Assert.assertEquals(JoinButton.getText(), "تم الانضمام للقائمة البريدية بنجاح");
        driver.navigate().back();
    }

}
/*
        @Test(priority = 34)
    public void scrollTop() throws InterruptedException {
        WebElement Header = driver.findElement(By.xpath("//*[@id=\"topcontrol\"]"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the footer
        actions.scrollToElement(Header).perform();
        Thread.sleep(5000);
    }
 */
