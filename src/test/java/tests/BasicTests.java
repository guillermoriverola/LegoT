
package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LegoHome;

public class BasicTests {

    private String PATHDRIVER = "src/test/resources/drivers/";


    private String baseURL = "https://www.lego.com/es-es";
    WebDriver driver;
    public static String title = "";
    

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test
    public void ShopbyAge() throws InterruptedException {
        driver.get(baseURL);
        Actions actions = new Actions(driver);
        LegoHome legoHome = new LegoHome(driver);

        //Close Pop Ups
        legoHome.closePopUp();

        //Menu
        legoHome.menu();

        //Asserts
        legoHome.assertItems();
        legoHome.assertName();
    }

    @Test
    public void LudoLego() throws InterruptedException {
        driver.get(baseURL);
        Actions actions = new Actions(driver);
        LegoHome legoHome = new LegoHome(driver);

        //Close Pop Ups
        legoHome.closePopUp();

        //Search
        legoHome.search();
        legoHome.assertSearch();

        //AddItems
        legoHome.assertItemTrue();
        legoHome.plusItems();

        //Assert Bag
        legoHome.assertBag();
    }

    @After
    public void close(){
        driver.close();
    }
}
