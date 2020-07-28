import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search extends BaseTest {

    @Test
    public void doTest() throws InterruptedException {
        searchByKeyword();
        listProducts();
    }

    private void searchByKeyword() throws InterruptedException {
        setById("search_word", "fırın");
        clickById("header-search-find-link");
        Thread.sleep(5000);
        wait.until(documentReady);
    }

    private void listProducts() {
        List<WebElement> productElement = driver.findElements(By.cssSelector(".products-container > li"));

        for (WebElement element : productElement) {
            String title = element.findElement(By.cssSelector(".product-title > span")).getText();
            String price = element.findElement(By.cssSelector(".price-txt")).getText();

            System.out.println("Title : " + title + " Price :" + price);
        }
    }
}
