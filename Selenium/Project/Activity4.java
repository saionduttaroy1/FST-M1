package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class Activity4 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the second heading on the page
        String secondHeading = driver.findElement(By.cssSelector("h2")).getText();

        // Make sure it matches "Quia quis non" exactly
        if (secondHeading.equals("Quia quis non")) {
            System.out.println("Second heading matches");
        } else {
            System.out.println("Second heading does not match");
        }

        // Close the browser
        driver.close();

    }
}
