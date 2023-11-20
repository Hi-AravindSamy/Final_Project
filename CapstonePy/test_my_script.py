import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC




@pytest.fixture(scope="session")
def browser():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()

def test_scenario_1(browser):
    url = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/"
    browser.get(url)

    assert browser.title == "Want to practice test automation? Try these demo sites! | Automation Panda"

    speaking_link = browser.find_element(By.XPATH, "//a[text()='Speaking']")
    speaking_link.click()

    assert browser.title == "Speaking | Automation Panda"

    keynote_addresses_element = browser.find_element(By.XPATH, "//h2[text()='Keynote Addresses']")
    assert keynote_addresses_element.is_displayed()

    conference_talks_element = browser.find_element(By.XPATH, "//h2[text()='Conference Talks']")
    assert conference_talks_element.is_displayed()

def test_scenario_2(browser):
    url = "https://www.flipkart.com/"
    browser.get(url)

   
    wait = WebDriverWait(browser, 10)
    
    phone_number_input = wait.until(EC.presence_of_element_located((By.XPATH, "//div[@class='_22Dgdy _29BEA8']//input")))
    phone_number_input.send_keys("9952525420")

    # Click on the Request OTP button
    request_otp_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//button[@class='_1wGnMD rX1XT4 _2nD2xJ']")))
    request_otp_button.click()

    # Verify the OTP message
    otp_message_element = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[contains(text(), 'Please enter the OTP sent to')]")))
    assert otp_message_element.text == "Please enter the OTP sent to"