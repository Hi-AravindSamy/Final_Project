package tests;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class Scenario2Test extends BaseTest {

	@Test
	public void testScenario2() {
		driver.get("https://www.flipkart.com/");

		closeLoginPopup();
		Reporter.log("Popup closed", true);

		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Reporter.log("Home Page Title Verified and matching", true);

		Assert.assertTrue(driver.getPageSource().contains("Flipkart"));
		Reporter.log("Flipkart is present on left side of the top", true);

		homePage.search("iphone 14");

		SearchResultPage searchResultPage = new SearchResultPage(driver);
		int itemCount = searchResultPage.getItemCount();

		Reporter.log("Total item count " + itemCount + "", true);
		Assert.assertTrue(itemCount > 0);

		searchResultPage.clickFirstItem();
		Reporter.log("Clicked First Item", true);

		Assert.assertEquals(driver.getTitle(),
				"Iphone 14- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		Reporter.log("Title Matched", true);
	}

	private void closeLoginPopup() {
		try {

			WebElement closeButton = driver.findElement(By.xpath("//span[contains(text(),'✕')]"));
			if (closeButton.isDisplayed()) {
				closeButton.click();
			}
		} catch (NoSuchElementException | ElementNotInteractableException e) {

		}
	}
}
