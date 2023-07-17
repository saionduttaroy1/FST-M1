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

# Get the heading of the webpage
headingElement = driver.find_elements(By.TAG_NAME, "h1")[1]
heading = headingElement.text

# Verify if the heading matches
if heading == "Welcome to Alchemy Jobs":
    print("Heading matches")
else:
    print("Heading does not match")

# Close the browser
driver.quit()
