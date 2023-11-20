package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(xpath = "//a[contains(@href, 'contact')]")
    private WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),'✕')]")
	private WebElement closeButton;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickContact() {
        contactLink.click();
    }

    public void search(String query) {
        searchBox.sendKeys(query);
        searchButton.click();
    }
}
