package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the website's backend
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");

        // Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys("root");

        // Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys("pa$$w0rd");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Verify that you have logged in
        String title = driver.getTitle();
        assert title.equals("Dashboard ‹ Alchemy Jobs — WordPress");

        // Find the Job Listings menu item
        WebElement jobListingsMenuItem = driver.findElement(By.linkText("Job Listings"));
        jobListingsMenuItem.click();

        // Locate the "Add New" button and click it
        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        addNewButton.click();

        // Click the cross button on the popup
        WebElement crossButton = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[1]/button"));
        crossButton.click();

        // Fill in the necessary details
        WebElement jobPosition = driver.findElement(By.id("post-title-0"));
        jobPosition.sendKeys("Software Tester - India");

        WebElement companyWebsite = driver.findElement(By.id("_company_website"));
        companyWebsite.sendKeys("https://www.ibm.com/in-en");

        WebElement companyTwitter = driver.findElement(By.id("_company_twitter"));
        companyTwitter.sendKeys("@ibm_in");

        WebElement jobLocation = driver.findElement(By.id("_job_location"));
        jobLocation.sendKeys("India");

        WebElement companyName = driver.findElement(By.id("_company_name"));
        companyName.sendKeys("IBM India");

        WebElement companyTagline = driver.findElement(By.id("_company_tagline"));
        companyTagline.sendKeys("Let's create");

        WebElement companyVideo = driver.findElement(By.id("_company_video"));
        companyVideo.sendKeys("https://www.youtube.com/watch?v=vNiRZWVNK7M");

        // Confirm do you want to Publish
        WebElement publishConfirm = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]"));
        publishConfirm.click();

        // Publish Job
        WebElement publishJob = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button"));
        publishJob.click();

        Thread.sleep(1000);

        // View Job
        WebElement viewJob = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a"));
        viewJob.click();

        // Verification

        // Navigate to the backend website's job listing page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/edit.php?post_type=job_listing");

        // Find the "Software Tester - India" job
        WebElement findSoftwareTester = driver.findElement(By.linkText("Software Tester – India"));
        findSoftwareTester.click();

        Thread.sleep(1000);

        // Find the textarea element
        WebElement textareaElement = driver.findElement(By.id("post-title-0"));

        // Get the text of the textarea element
        String textareaText = textareaElement.getAttribute("value");
        assert textareaText.equals("Software Tester - India");

        // Print a message if the assertion is true (Not necessary)
        if (textareaText.equals("Software Tester - India")) {
            System.out.println("We can verify that a job listing was created using the Backend");
        }

        // Close the browser
        driver.close();
    }
}
