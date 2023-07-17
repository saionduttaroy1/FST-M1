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
driver.get("https://alchemy.hguy.co/jobs/wp-admin")

# Find the username field and enter the username
usernameField = driver.find_element(By.ID, "user_login")
usernameField.send_keys("root")

# Find the password field and enter the password
passwordField = driver.find_element(By.ID, "user_pass")
passwordField.send_keys("pa$$w0rd")

# Find the login button and click it
loginButton = driver.find_element(By.ID, "wp-submit")
loginButton.click()

# Verify that you have logged in
title = driver.title
assert title == "Dashboard ‹ Alchemy Jobs — WordPress"

# Find the Job Listings menu item
jobListingsMenuItem = driver.find_element(By.LINK_TEXT, "Job Listings")
jobListingsMenuItem.click()

# Locate the "Add New" button and click it
addNewButton = driver.find_element(By.LINK_TEXT, "Add New")
addNewButton.click()

# Click the cross button on the popup
crossButton = driver.find_element(By.XPATH, "/html/body/div[6]/div/div/div/div/div/div/div/div[1]/button")
crossButton.click()

# Fill in the necessary details
jobPosition = driver.find_element(By.ID, "post-title-0")
jobPosition.send_keys("Software Tester - India")

companyWebsite = driver.find_element(By.ID, "_company_website")
companyWebsite.send_keys("https://www.ibm.com/in-en")

companyTwitter = driver.find_element(By.ID, "_company_twitter")
companyTwitter.send_keys("@ibm_in")

jobLocation = driver.find_element(By.ID, "_job_location")
jobLocation.send_keys("India")

companyName = driver.find_element(By.ID, "_company_name")
companyName.send_keys("IBM India")

companyTagline = driver.find_element(By.ID, "_company_tagline")
companyTagline.send_keys("Let's create")

companyVideo = driver.find_element(By.ID, "_company_video")
companyVideo.send_keys("https://www.youtube.com/watch?v=vNiRZWVNK7M")

# Confirm do you want to Publish
publishConfirm = driver.find_element(By.XPATH, "/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")
publishConfirm.click()

# Publish Job
publishJob = driver.find_element(By.XPATH, "/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")
publishJob.click()

time.sleep(1)

# View Job
viewJob = driver.find_element(By.XPATH, "/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
viewJob.click()

# Verification

# Navigate to the backend website's job listing page
driver.get("https://alchemy.hguy.co/jobs/wp-admin/edit.php?post_type=job_listing")

# Find the "Software Tester - India" job
findSoftwareTester = driver.find_element(By.LINK_TEXT, "Software Tester – India")
findSoftwareTester.click()

time.sleep(1)

# Find the textarea element
textareaElement = driver.find_element(By.ID, "post-title-0")

# Get the text of the textarea element
textareaText = textareaElement.get_attribute("value")
assert textareaText == "Software Tester - India"

# Print a message if the assertion is true (Not necessary)
if textareaText == "Software Tester - India":
    print("We can verify that a job listing was created using the Backend")

# Close the browser
driver.quit()
