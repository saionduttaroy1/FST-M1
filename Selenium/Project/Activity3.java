package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class Activity3 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the image element
        WebElement imageElement = driver.findElement(By.cssSelector("img"));

        // Get the image URL
        String imageUrl = imageElement.getAttribute("src");

        // Print the image URL to the console
        System.out.println("Header Image URL: " + imageUrl);

        // Close the browser
        driver.close();

    }
}
