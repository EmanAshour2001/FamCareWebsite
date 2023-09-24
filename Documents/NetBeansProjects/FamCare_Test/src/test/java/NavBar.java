import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class NavBar {
    Setup setup;
    WebElement FamcareLogoImg;
    WebElement FamcareLogoLink;
    WebElement FamcareLink;
    WebElement SpecialistsLink;
    WebElement BlogLink;
    WebElement AcademyLink;
    WebElement OrganizationsLink;
    WebElement WhoWeAreLink;
    WebElement JoinAsSpecialistButton;
    private WebDriver driver;

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    public void FamcareLogoIsDisplayed() {
        FamcareLogoImg = setup.driver.findElement(By.xpath("/html/body/header/div/div/nav/a/img"));
        Assert.assertTrue(FamcareLogoImg.isDisplayed());
    }

    //It failed with explicit wait
    public void FamcareLogoLinkIsClickable() {
        //Failed with explicit time
        // wait.until(ExpectedConditions.visibilityOf(FamcareLogoLink));
        //wait.until(ExpectedConditions.elementToBeClickable(FamcareLogoLink));
        FamcareLogoLink = setup.driver.findElement(By.xpath("/html/body/header/div/div/nav/a"));
        FamcareLogoLink.click();
    }

    // Test the visibility and text of a link in navigation bar on the FamCare website 
    @Test(priority = 3)
    public void FamcareLinkIsDisplayed() {
        FamcareLink = setup.driver.findElement(By.xpath("//*[@id='menu-item-6']"));
        Assert.assertTrue(FamcareLink.isDisplayed());
    }

    @Test(priority = 4)
    public void FamcareLinkTextIsCorrect() {
        Assert.assertEquals(FamcareLink.getText(), "فامكير");
    }

    @Test(priority = 5)
    public void FamcareLinkColorChangeOnHover() {
        // Get the initial color of the link
        String initialBackgroundColor = FamcareLink.getCssValue("background-color");

        // Hover over the link to trigger color change
        Actions actions = new Actions(driver);
        actions.moveToElement(FamcareLink).perform();

        // Get the color after hover
        String colorAfterHover = FamcareLink.getCssValue("color");

        // Convert the color values to lowercase and compare
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

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
    @Test(priority = 6)
    public void FamcareLinkIsClickable() {
        FamcareLink.click();
    }

    @Test(priority = 7)
    public void SpecialistsLinkIsDisplayed() {
        SpecialistsLink = setup.driver.findElement(By.xpath("//*[@id=\"menu-item-1026\"]"));
        Assert.assertTrue(SpecialistsLink.isDisplayed());
    }

    @Test(priority = 8)
    public void SpecialistsLinkTextIsCorrect() {
        Assert.assertEquals(SpecialistsLink.getText(), "الأخصائيين");
    }

    @Test(priority = 9)
    public void SpecialistsLinkColorChangeOnHover() {
        String initialBackgroundColor = SpecialistsLink.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(SpecialistsLink).perform();
        String colorAfterHover = SpecialistsLink.getCssValue("color");
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

    @Test(priority = 10)
    public void SpecialistsLinkIsClickable() {
        SpecialistsLink.click();
    }

    @Test(priority = 11)
    public void BlogLinkIsDisplayed() {
        BlogLink = setup.driver.findElement(By.xpath("//*[@id=\"menu-item-2633\"]"));
        Assert.assertTrue(BlogLink.isDisplayed());
    }

    @Test(priority = 12)
    public void BlogLinkTextIsCorrect() {
        Assert.assertEquals(BlogLink.getText(), "المدونة");
    }

    @Test(priority = 13)
    public void BlogLinkColorChangeOnHover() {
        String initialBackgroundColor = BlogLink.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(BlogLink).perform();
        String colorAfterHover = BlogLink.getCssValue("color");
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

    @Test(priority = 14)
    public void BlogLinkIsClickable() {
        BlogLink.click();
    }

    @Test(priority = 15)
    public void AcademyLinkIsDisplayed() {
        AcademyLink = setup.driver.findElement(By.xpath("//*[@id=\"menu-item-1227\"]"));
        Assert.assertTrue(AcademyLink.isDisplayed());
    }

    @Test(priority = 16)
    public void AcademyLinkTextIsCorrect() {
        Assert.assertEquals(AcademyLink.getText(), "الأكاديمية");
    }

    @Test(priority = 17)
    public void AcademyLinkColorChangeOnHover() {
        String initialBackgroundColor = AcademyLink.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(AcademyLink).perform();
        String colorAfterHover = AcademyLink.getCssValue("color");
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

    @Test(priority = 18)
    public void AcademyLinkIsClickable() {
        AcademyLink.click();
        setup.driver.navigate().back();

    }

    @Test(priority = 19)
    public void OrganizationsLinkIsDisplayed() {
        OrganizationsLink = setup.driver.findElement(By.xpath("//*[@id=\"menu-item-187\"]"));
        Assert.assertTrue(OrganizationsLink.isDisplayed());
    }

    @Test(priority = 20)
    public void OrganizationsLinkTextIsCorrect() {
        Assert.assertEquals(OrganizationsLink.getText(), "المنظمات");
    }

    @Test(priority = 21)
    public void OrganizationsLinkColorChangeOnHover() {
        String initialBackgroundColor = OrganizationsLink.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(OrganizationsLink).perform();
        String colorAfterHover = OrganizationsLink.getCssValue("color");
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

    @Test(priority = 22)
    public void OrganizationsLinkIsClickable() {
        OrganizationsLink.click();
    }

    @Test(priority = 23)
    public void WhoWeAreLinkIsDisplayed() {
        WhoWeAreLink = setup.driver.findElement(By.xpath("//*[@id=\"menu-item-188\"]"));
        Assert.assertTrue(WhoWeAreLink.isDisplayed());
    }

    @Test(priority = 24)
    public void WhoWeAreLinkTextIsCorrect() {
        Assert.assertEquals(WhoWeAreLink.getText(), "من نحن");
    }

    @Test(priority = 25)
    public void WhoWeAreLinkColorChangeOnHover() {
        String initialBackgroundColor = WhoWeAreLink.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(WhoWeAreLink).perform();
        String colorAfterHover = WhoWeAreLink.getCssValue("color");
        Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
    }

    @Test(priority = 26)
    public void WhoWeAreLinkIsClickable() {
        WhoWeAreLink.click();
    }

    @Test(priority = 27)
    public void JoinAsSpecialistButtonIsDisplayed() {
        JoinAsSpecialistButton = setup.driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/button"));
        Assert.assertTrue(JoinAsSpecialistButton.isDisplayed());
    }

    @Test(priority = 28)
    public void JoinAsSpecialistButtonTextIsCorrect() {
        Assert.assertEquals(JoinAsSpecialistButton.getText(), "انضم كأخصائي");
    }

    @Test(priority = 29)
    public void JoinAsSpecialistButtonIsClickable() throws InterruptedException {
        JoinAsSpecialistButton.click();
        Thread.sleep(5000);
    }
}
