# Import webdriver from selenium
from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
import time

# Set up Firefox driver
GeckoDriverManager().setup()
# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Navigate to the website's backend
driver.get("https://alchemy.hguy.co/jobs/wp-admin/")

# Find the username field and enter the username
usernameField = driver.find_element(By.ID, "user_login")
usernameField.send_keys("root")

# Find the password field and enter the password
passwordField = driver.find_element(By.ID, "user_pass")
passwordField.send_keys("pa$$w0rd")

# Wait for listings to show
time.sleep(1)

# Find the login button and click it
loginButton = driver.find_element(By.ID, "wp-submit")
loginButton.click()

# Verify that you have logged in
title = driver.title
assert title == "Dashboard ‹ Alchemy Jobs — WordPress"

# Print a message if the assertion is true
if title == "Dashboard ‹ Alchemy Jobs — WordPress":
    print("You are logged in")

# Close the browser
driver.quit()
