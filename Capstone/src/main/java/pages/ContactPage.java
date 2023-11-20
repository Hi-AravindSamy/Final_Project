package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
	@FindBy(xpath = "//input[@name='g3-name']")
    private WebElement nameInput;

	@FindBy(xpath = "//input[@name='g3-email' and @type='email']")
    private WebElement emailInput;

	@FindBy(xpath = "//textarea[@name='g3-message']")
    private WebElement commentInput;

	@FindBy(xpath = "//strong[text()='Contact Me']")
    private WebElement submitButton;

	@FindBy(xpath = "//h4[@id='contact-form-success-header' and text()='Your message has been sent']")
    private WebElement messageSent;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(String name, String email, String comment) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        commentInput.sendKeys(comment);
        submitButton.click();
    }

    public String getMessageSent() {
        return messageSent.getText();
    }
}
