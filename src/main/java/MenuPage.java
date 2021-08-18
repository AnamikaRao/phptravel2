import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver1) {
        super(driver1);
    }

    @FindBy(xpath = "//a[text()='Home']")
    WebElement homebutton;
    @FindBy(xpath = "//a[text()='Hotels']")
    WebElement hotelsbutton;
    @FindBy(xpath = "//a[text()='flights']")
    WebElement flightsbutton;
    @FindBy(xpath = "//a[text()='Tours']")
    WebElement toursbutton;
    @FindBy(xpath = "//a[text()='visa']")
    WebElement visabutton;
    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    WebElement Hotellocation;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement HotelLocationsendkey;
    @FindBy(xpath = "//i[contains(@class,'mdi mdi-search')]")
    WebElement HotelSearch;
    @FindBy(xpath="//strong[normalize-space()='Filter Search']")
    WebElement HotelFilter;
    @FindBy(xpath = "//span[@role='combobox']")
    WebElement TourlocationBox;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement TourLocation;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement TourSearch;



    public void clickhomebutton()
    {
        homebutton.click();
        Assert.assertEquals("https://www.phptravels.net/",driver.getCurrentUrl());
    }
    public void clickhotelsbutton()
    {
        hotelsbutton.click();
        Assert.assertEquals("https://www.phptravels.net/hotels",driver.getCurrentUrl());
    }
    public void clickflightbutton()
    {
        flightsbutton.click();
        Assert.assertEquals("https://www.phptravels.net/flights",driver.getCurrentUrl());
    }
    public void clicktoursbutton()
    {
        toursbutton.click();
        Assert.assertEquals("https://www.phptravels.net/tours",driver.getCurrentUrl());
    }
    public void clickVisabutton()
    {
        visabutton.click();
        Assert.assertEquals("https://www.phptravels.net/visa",driver.getCurrentUrl());
    }

    public void hotelSearch()
    {
        hotelsbutton.click();
        SetupPage.holdExcution(4);
        Hotellocation.click();
        HotelLocationsendkey.sendKeys("Ahm");
        SetupPage.holdExcution(4);
       // driver.findElement(By.xpath("//input[@role='searchbox']")).click();
       driver.findElement(By.xpath("//li[normalize-space()='Ahmedabad,India']")).click();
        SetupPage.holdExcution(2);
        HotelSearch.click();
        SetupPage.holdExcution(5);
        Assert.assertTrue(HotelFilter.isDisplayed());
    }

    public void tourSearch()
    {
        toursbutton.click();
        SetupPage.holdExcution(2);

        TourlocationBox.click();
        SetupPage.holdExcution(2);

        TourLocation.sendKeys("Mum");
        SetupPage.holdExcution(2);
        driver.findElement(By.xpath("//li[normalize-space()='Mumbai,India']")).click();
        TourSearch.click();
        SetupPage.holdExcution(5);
        Assert.assertTrue(HotelFilter.isDisplayed());

    }
}
