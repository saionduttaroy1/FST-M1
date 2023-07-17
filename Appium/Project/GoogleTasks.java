package activities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleTasks {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.tasks");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.TaskListsActivity");

        // Initialize driver
        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appiumServerURL, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Test method
    @Test
    public void createTaskList() {
        // Click the button to add a new task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();

        // Add tasks
        addTask("Complete Activity with Google Tasks");
        // Click the button to add a new task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        addTask("Complete Activity with Google Keep");
        // Click the button to add a new task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        addTask("Complete the second Activity Google Keep");

        // Verify tasks
        Assert.assertTrue(verifyTaskAdded("Complete Activity with Google Tasks"));
        Assert.assertTrue(verifyTaskAdded("Complete Activity with Google Keep"));
        Assert.assertTrue(verifyTaskAdded("Complete the second Activity Google Keep"));
    }

    // Method to add a task
    public void addTask(String taskName) {
        // Enter task name
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title")))
                .sendKeys(taskName);

        // Click the Save button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.apps.tasks:id/add_task_done")))
                .click();
    }

    // Method to verify if a task is added
    public boolean verifyTaskAdded(String taskName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + taskName + "']")).isDisplayed();
    }

    // Method to capture screenshot on test pass
    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "src/test/resources/screenshots/" + result.getName() + ".png";
            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot captured and saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
