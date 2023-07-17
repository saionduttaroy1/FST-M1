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

# Get the image element
imageElement = driver.find_element(By.CSS_SELECTOR, "img")

# Get the image URL
imageUrl = imageElement.get_attribute("src")

# Print the image URL to the console
print("Header Image URL:", imageUrl)

# Close the browser
driver.quit()