import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageTest {

    BasePage basePage;
    LoginPage loginPage;
    MenuPage menuPage;
    public WebDriver driver;


    @BeforeTest
    public void tearup() throws IOException {
        driver = SetupPage.initiateDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }

    @BeforeMethod
    public void getUrl() {
        driver.get(SetupPage.properties.getProperty("url"));
        driver.manage().window().maximize();
        SetupPage.holdExcution(10);
    }

    @AfterTest
    public void tearnDown() {
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyLogo() {
        basePage.logoenabled();
    }

    @Test(priority = 1)
    public void verifyCurrencyDropdown() {
        basePage.setCurrencydropdown();
    }

    @Test(priority = 12)
    public void verifySignup() {
        basePage.clickSignup();
    }

    @Test(priority = 13)
    public void verifySignIn() {
        basePage.clickSignIn();
        SetupPage.holdExcution(3);
        loginPage.enterusername(SetupPage.properties.getProperty("username"));
        loginPage.enterpassword(SetupPage.properties.getProperty("password"));

        SetupPage.holdExcution(3);
        loginPage.signIn();
        SetupPage.holdExcution(3);

    }

    @Test(priority = 3)
    public void verifyComanyDropdown() {
        basePage.clickCompnay();
    }

    @Test(priority = 4)
    public void verifyAboutUs() {
        basePage.aboutbutton();
    }

    @Test(priority = 5)
    public void verifyTermsofUse() {
        basePage.termsOfUsebutton();
    }

    @Test(priority = 6)
    public void verifyfaq() {
        basePage.faqButton();
    }

    @Test(priority = 7)
    public void verifyMenubutton() {
        menuPage.clickhomebutton();
        SetupPage.holdExcution(5);
        menuPage.clickflightbutton();
        SetupPage.holdExcution(5);
        menuPage.clicktoursbutton();
        SetupPage.holdExcution(5);
        menuPage.clickVisabutton();
        SetupPage.holdExcution(5);
        menuPage.clickhotelsbutton();
    }

    @Test(priority = 8)
    public void verifyHotelSearch() {
        menuPage.hotelSearch();
    }

    @Test(priority = 9)
    public void verifyTourSearch() {
        menuPage.tourSearch();
    }
}
