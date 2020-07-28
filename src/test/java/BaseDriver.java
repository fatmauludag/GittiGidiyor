import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {
    static WebDriverWait wait;
    static WebDriver driver;
    static ExpectedCondition<Boolean> documentReady = driver -> {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    };

    static {
        if (driver == null)
            setup();
    }

    @Before
    public static void setup() {
        if (driver != null)
            return;
        System.setProperty("webdriver.chrome.driver", "C:/Users/testinium/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.gittigidiyor.com/");
        wait = new WebDriverWait(driver, 15);
    }

    @After
    public static void cutConnection() {
        driver.close();
        // driver.quit();
    }

    public void setById(String id, String value) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void getUrl(String URL) {
        driver.get(URL);
    }

}
