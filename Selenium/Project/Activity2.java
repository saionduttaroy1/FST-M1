package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class Activity2 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the heading of the webpage
        WebElement headingElement = driver.findElements(By.tagName("h1")).get(1);
        String heading = headingElement.getText();

        // Verify if the heading matches
        if (heading.equals("Welcome to Alchemy Jobs")) {
            System.out.println("Heading matches");
        } else {
            System.out.println("Heading does not match");
        }

        // Close the browser
        driver.close();
    }
}