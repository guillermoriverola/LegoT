package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class LegoHome {

	private WebDriver driver;

    //public static String Items = "";
    public static int ItemsSize = 0;


    //Constructor
    public LegoHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"root\"]/div[3]/div/div[2]/button")
    public WebElement cookies;
    @FindBy(xpath="//*[@id=\"root\"]/div[5]/div/div/div[1]/div[1]/div/button")
    public WebElement continuar;

    public void closePopUp(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);
        //Pop Up
        wait.until(ExpectedConditions.visibilityOf(continuar));
        actions.moveToElement(continuar).click().build().perform();
        //Close Cookies
        wait.until(ExpectedConditions.visibilityOf(cookies));
        actions.moveToElement(cookies).click().build().perform();
    }

    @FindBy(xpath ="//*[@id=\"root\"]/div[2]/header/div[2]/div[2]/div/nav/ul/li[2]/button/span")
    public WebElement comprarPor;
    @FindBy(xpath ="//*[@id=\"bltb9d6f2110f37ddd5\"]/div/div[1]/button[3]")
    public WebElement edad;
    @FindBy(xpath ="//*[@id=\"bltb9d6f2110f37ddd5\"]/div/div[2]/ul/li[2]/a")
    public WebElement edad35;
    @FindBy(xpath ="//*[@id=\"blt0723e5915b29f00d\"]/section/div/aside/div/div/div[2]/div/div/div/ul/li[10]/label")
    public WebElement llaveros;

    public void menu(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(comprarPor));
        comprarPor.click();
        edad.click();
        edad35.click();
        wait.until(ExpectedConditions.visibilityOf(llaveros));
        llaveros.click();
    }

    @FindBy(xpath ="//*[@id=\"blt0723e5915b29f00d\"]/section/div/div/div[2]/ul")
    public WebElement items;
    @FindBy(xpath ="//body/div[@id='root']/main[@id='main-content']/div[1]/div[4]/div[1]/section[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[1]/a[1]/h2[1]/span[1]")
    public WebElement articleName;

    public void assertItems() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(items));
        List<WebElement> Items = items.findElements(By.xpath("//*[@id=\"blt0723e5915b29f00d\"]/section/div/div/div[2]/ul/li"));
        Items.size();
        ItemsSize = Items.size();
        Assert.assertEquals(ItemsSize, 3);
    }
    public void assertName() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(items));
        String text = articleName.getText();
        String texto = "Llavero con linterna";
        Assert.assertTrue(text.contains(texto));
    }

    @FindBy(xpath ="//header/div[2]/div[2]/div[1]/div[1]/button[1]/*[1]")
    public WebElement search;
    @FindBy(xpath ="//input[@id='desktop-search-search-input']")
    public WebElement searchInput;
    @FindBy(xpath ="//*[@id=\"desktop-search-search-suggestions\"]/li[1]/a/div/div/p[1]")
    public WebElement searchClick;


    public void search(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(search));
        search.click();
        String text = "Connections Kit";
        searchInput.sendKeys(text);
    }

    public void assertSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchClick));
        String text = searchClick.getText();
        String texto = "Connections";
        Assert.assertTrue(text.contains(texto));
        searchClick.click();
    }

    @FindBy(xpath ="//*[@id=\"main-content\"]/div/div[2]/div/div/div[2]/h1/span")
    public WebElement search2;

    public void assertItemTrue(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(search2));
        String text = search2.getText();
        String texto = "Connections";
        Assert.assertTrue(text.contains(texto));
    }


    @FindBy(xpath ="//*[@id=\"main-content\"]/div/div[2]/div/div/div[2]/div[5]/div[1]/button[2]")
    public WebElement plusItem;
    @FindBy(xpath ="//*[@id=\"main-content\"]/div/div[2]/div/div/div[2]/div[6]/div[1]/div/div/div/button/div[3]")
    public WebElement addToBag;

    public void plusItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);
        actions.moveToElement(addToBag).perform();
        actions.moveToElement(plusItem).click().build().perform();
        Thread.sleep(200);
        actions.moveToElement(addToBag).click().build().perform();
    }

    @FindBy(xpath ="//*[@id=\"main-content\"]/div/div[1]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div/div/input")
    public WebElement countItems;

    public void assertBag() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);
        driver.get("https://www.lego.com/es-es/cart");
        wait.until(ExpectedConditions.visibilityOf(countItems));
        String number = countItems.getAttribute("value");
        Assert.assertNotNull(number);
    }
}
