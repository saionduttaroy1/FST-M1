# Import webdriver from selenium
from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
import time

# Set up Firefox driver
GeckoDriverManager().setup()
# Create a new instance of the Firefox driver
driver = webdriver.Firefox()

# Open the page
driver.get("https://alchemy.hguy.co/jobs/")

# Click on Post a Job
jobsElement = driver.find_element(By.LINK_TEXT, "Post a Job")
jobsElement.click()

# Locate the navigation menu and click the menu item that says "Post a Job"
postJobLink = driver.find_element(By.LINK_TEXT, "Post a Job")
postJobLink.click()

# Fill in the necessary details

# ***Email id should be unique each time***
yourEmail = driver.find_element(By.ID, "create_account_email")
yourEmail.send_keys("abcdtest15072023@gmail.com")

jobTitle = driver.find_element(By.ID, "job_title")
jobTitle.send_keys("Software Engineer")

# Enter the Job Description

# Find the iframe element that contains the rich text editor
iframe = driver.find_element(By.TAG_NAME, "iframe")
# Switch the focus to the iframe
driver.switch_to.frame(iframe)
# Locate the editable area within the iframe
editableArea = driver.find_element(By.TAG_NAME, "body")
# Clear any existing text within the editable area (optional)
editableArea.clear()
# Enter the desired text into the editable area
editableArea.send_keys("This is a job description for a Software Engineer.")
# Switch the focus back to the default content
driver.switch_to.default_content()

applicationEmail = driver.find_element(By.ID, "application")
applicationEmail.send_keys("abc15@gmail.com")

companyName = driver.find_element(By.ID, "company_name")
companyName.send_keys("IBM")

# Click the "Preview" button
previewButton = driver.find_element(By.NAME, "submit_job")
previewButton.click()

time.sleep(1)

# Click the Submit Listing
submitListing = driver.find_element(By.ID, "job_preview_submit_button")
submitListing.click()

# View Listing
viewListing = driver.find_element(By.XPATH, "//*[@id='post-5']/div/a")
viewListing.click()

# Click on Jobs to verify
viewJobs = driver.find_element(By.XPATH, "//*[@id='menu-item-24']/a")
viewJobs.click()

time.sleep(5)

# Close the browser
driver.quit()
