package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the title of the website
        String title = driver.getTitle();

        // Verify the title
        if (title.equals("Alchemy Jobs – Job Board Application")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match");
        }

        // Close the browser
        driver.close();

    }
}
