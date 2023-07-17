# Import webdriver from selenium
from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up Firefox driver
GeckoDriverManager().setup()
# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Navigate to the website
driver.get("https://alchemy.hguy.co/jobs/")

# Find the Jobs element
jobsElement = driver.find_element(By.LINK_TEXT, "Jobs")

# Click the Jobs element
jobsElement.click()

# Read the page title and verify that you are on the correct page
pageTitle = driver.title
assert pageTitle == "Jobs – Alchemy Jobs"

# Print a message if the assertion is true
if pageTitle == "Jobs – Alchemy Jobs":
    print("You are on the correct page")

# Close the browser
driver.quit()
