
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import static org.apache.commons.lang3.ObjectUtils.wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class Specialists {

    NavBar navBar;
    WebDriver driver;
    WebElement SearchField;
    WebElement SearchResult;
    WebElement ViewMoreButton;

    Wait<WebDriver> wait;

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
        driver.get("https://famcare.app/specialists/");
        //originalWindowHandle = driver.getWindowHandle(); // Store the handle of the original window

    }

    @Test
    public void SearchFieldIsDisplayed() {
        // Locate the search field and enter a name
        SearchField = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/label/input"));
        SearchField.sendKeys("عفاف");
        //pressing Enter
        SearchField.sendKeys(Keys.ENTER);
    }

    @Test
    public void SearchResultIsDisplayed() {
        // Verify that the related result appears
        SearchResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/label/input"));
        Assert.assertTrue(SearchResult.isDisplayed(), "Search result is displayed");
        driver.navigate().back();

    }

    @Test
    public void scrollDownToViewMoreButton() throws InterruptedException {
        WebElement ViewMoreButton = driver.findElement(By.xpath("/html/body/div[1]/a"));
        // Create Actions class instance
        Actions actions = new Actions(driver);
        // Scroll to the  ViewMore Button
        actions.scrollToElement(ViewMoreButton).perform();
        Thread.sleep(5000);
    }

    @Test
    public void ViewMoreButtonIsDisplayed() {
        ViewMoreButton = driver.findElement(By.xpath("/html/body/div[1]/a"));
        Assert.assertTrue(ViewMoreButton.isDisplayed());
    }

    @Test
    public void ViewMoreSpecialiIsClickableandMoreSpecialistsareViewed() {
        ViewMoreButton.click();
        // Wait for additional data to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]")));
        // Verify that more specialists are visible
        List<WebElement> additionalSpecialists = driver.findElements(By.cssSelector("/html/body/div[1]/div[2]"));
        Assert.assertTrue(additionalSpecialists.size() > 0, "Additional specialists are displayed");
    }

    @Test
    public void NavBar() {
    navBar.FamcareLogoIsDisplayed();
    }
}
