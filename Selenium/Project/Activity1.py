# Import webdriver from selenium
from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager

# Set up Firefox driver
GeckoDriverManager().setup()
# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Open the page
driver.get("https://alchemy.hguy.co/jobs/")

# Get the title of the website
title = driver.title

# Verify the title
if title == "Alchemy Jobs – Job Board Application":
    print("Title matches")
else:
    print("Title does not match")

# Close the browser
driver.quit()
