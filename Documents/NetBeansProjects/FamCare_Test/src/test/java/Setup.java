
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Setup {

    WebDriver driver;
    Wait<WebDriver> wait;

    public Setup(WebDriver driver) {
        this.driver = driver;
    }

    public void  setup() {
        //Initialize driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.get("https://famcare.app/");
    }

    public void TearDown() {
        driver.quit();
    }
}
