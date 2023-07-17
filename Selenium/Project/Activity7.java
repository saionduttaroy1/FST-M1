package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Click on Post a Job
        WebElement jobsElement = driver.findElement(By.linkText("Post a Job"));
        jobsElement.click();

        // Locate the navigation menu and click the menu item that says "Post a Job"
        WebElement postJobLink = driver.findElement(By.linkText("Post a Job"));
        postJobLink.click();

        // Fill in the necessary details

        // ***Email id should be unique each time***
        WebElement yourEmail = driver.findElement(By.id("create_account_email"));
        yourEmail.sendKeys("abcdtest05072023@gmail.com");

        WebElement jobTitle = driver.findElement(By.id("job_title"));
        jobTitle.sendKeys("Software Engineer");

        // Enter the Job Description

        // Find the iframe element that contains the rich text editor
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        // Switch the focus to the iframe
        driver.switchTo().frame(iframe);
        // Locate the editable area within the iframe
        WebElement editableArea = driver.findElement(By.tagName("body"));
        // Clear any existing text within the editable area (optional)
        editableArea.clear();
        // Enter the desired text into the editable area
        editableArea.sendKeys("This is a job description for a Software Engineer.");
        // Switch the focus back to the default content
        driver.switchTo().defaultContent();

        WebElement applicationEmail = driver.findElement(By.id("application"));
        applicationEmail.sendKeys("abc@gmail.com");

        WebElement companyName = driver.findElement(By.id("company_name"));
        companyName.sendKeys("IBM");

        // Click the "Preview" button
        WebElement previewButton = driver.findElement(By.name("submit_job"));
        previewButton.click();

        Thread.sleep(1000);

        // Click the Submit Listing
        WebElement submitListing = driver.findElement(By.id("job_preview_submit_button"));
        submitListing.click();

        // View Listing
        WebElement viewListing = driver.findElement(By.xpath("//*[@id=\"post-5\"]/div/a"));
        viewListing.click();

        // Click on Jobs to verify
        WebElement viewJobs = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
        viewJobs.click();

        Thread.sleep(5000);

        // Close the browser
        driver.close();
    }
}
