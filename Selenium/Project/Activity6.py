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

# Click on Jobs
jobsElement = driver.find_element(By.LINK_TEXT, "Jobs")
jobsElement.click()

# Search for Software Analyst job
searchBar = driver.find_element(By.ID, "search_keywords")
searchBar.send_keys("Software Analyst")

# Click the Search jobs button
searchButton = driver.find_element(By.CSS_SELECTOR, ".search_submit > input:nth-child(1)")
searchButton.click()

# Wait for listings to show
time.sleep(1)

# Get the Software Analyst job
softwareAnalystJob = driver.find_element(By.XPATH, "//*[@id='post-7']/div/div/ul/li/a/div[1]/h3")
softwareAnalystJob.click()

# Apply for the job
applyButton = driver.find_element(By.XPATH, "/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")
applyButton.click()

# Wait for email to show
time.sleep(1)

# Print the email address
email = driver.find_element(By.XPATH, "/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a")
emailAddress = email.get_attribute("innerText")
print("The email address is:", emailAddress)

# Close the browser
driver.quit()
