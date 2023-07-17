package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Click on Jobs
        WebElement jobsElement = driver.findElement(By.linkText("Jobs"));
        jobsElement.click();

        // Search for Software Analyst job
        WebElement searchBar = driver.findElement(By.id("search_keywords"));
        searchBar.sendKeys("Software Analyst");

        // Click the Search jobs button
        WebElement searchButton = driver.findElement(By.cssSelector(".search_submit > input:nth-child(1)"));
        searchButton.click();

        // Wait for listings to show
        Thread.sleep(1000);

        // Get the Software Analyst job
        WebElement softwareAnalystJob = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li/a/div[1]/h3"));
        softwareAnalystJob.click();

        // Apply for the job
        WebElement applyButton = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input"));
        applyButton.click();

        // Wait for email to show
        Thread.sleep(1000);

        // Print the email address
        WebElement email = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a"));
        String emailAddress = email.getAttribute("innerText");
        System.out.println("The email address is: " + emailAddress);

        // Close the browser
        driver.close();
    }
}
