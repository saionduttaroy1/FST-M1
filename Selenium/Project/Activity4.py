# Import webdriver from selenium
from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up Firefox driver
GeckoDriverManager().setup()
# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Open the page
driver.get("https://alchemy.hguy.co/jobs/")

# Get the second heading on the page
secondHeading = driver.find_element(By.CSS_SELECTOR, "h2").text

# Make sure it matches "Quia quis non" exactly
if secondHeading == "Quia quis non":
    print("Second heading matches")
else:
    print("Second heading does not match")

# Close the browser
driver.quit()