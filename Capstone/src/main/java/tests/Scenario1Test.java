package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;


public class Scenario1Test extends BaseTest {
    @Test
    public void testScenario1() {
        driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), "Want to practice test automation? Try these demo sites! | Automation Panda");
        Reporter.log("Home Page Title Verified and matching", true);
        homePage.clickContact();

        ContactPage contactPage = new ContactPage(driver);
        Assert.assertEquals(driver.getTitle(), "Contact | Automation Panda");
        Reporter.log("Contact Page Title Verified and matching", true);
        
        contactPage.fillContactForm("Aravind Samy", "aravindsamy2509@gmail.com", "This is a test comment");
        Reporter.log("Given information filled", true);
        String messageSent = contactPage.getMessageSent();
        Assert.assertEquals(messageSent, "Your message has been sent");
        Reporter.log("Message sent verified", true);
    }
}
