package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//h1[@class='_2yAnYN']")
    private WebElement pageTitle;
    
    @FindBy(xpath = "//div[@data-id][1]")
    private WebElement firstSearchResult;

    @FindBy(css = "div._1AtVbE > div > div > div > a")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public int getItemCount() {
        return searchResults.size();
    }

    public void clickFirstItem() {
        // Scroll to the first search result to ensure it's in the view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstSearchResult);

        // Click on the first search result
        firstSearchResult.click();
    }
}

