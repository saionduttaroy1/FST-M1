package activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {
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

        // Wait for listings to show
        Thread.sleep(1000);

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();



        // Verify that you have logged in
        String title = driver.getTitle();
        assert title.equals("Dashboard ‹ Alchemy Jobs — WordPress");

        // Print a message if the assertion is true
        if (title.equals("Dashboard ‹ Alchemy Jobs — WordPress")) {
            System.out.println("You are logged in");
        }

        // Close the browser
        driver.close();
    }
}
