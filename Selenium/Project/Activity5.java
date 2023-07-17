package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the website
        driver.get("https://alchemy.hguy.co/jobs");

        // Find the Jobs element
        WebElement jobsElement = driver.findElement(By.linkText("Jobs"));

        // Click the Jobs element
        ((WebElement) jobsElement).click();

        // Read the page title and verify that you are on the correct page
        String pageTitle = driver.getTitle();
        assert pageTitle.equals("Jobs – Alchemy Jobs");

        // Print a message if the assertion is true
        if (pageTitle.equals("Jobs – Alchemy Jobs")) {
            System.out.println("You are on the correct page");
        }

        // Close the browser
        driver.close();
    }
}