package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;
    String filePath = "src/test/resources/sample.xlsx";

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://www.training-support.net/selenium/simple-form");
    }

    @DataProvider(name = "Registration")
    public Object[][] signUpInfo() throws IOException {
        // Create Workbook and Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("RegistrationData");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Last Name");
        headerRow.createCell(3).setCellValue("Email");
        headerRow.createCell(4).setCellValue("Phone Number");

        // Create data rows
        Object[][] data = {
                {1, "Satvik", "Shah", "satshah@example.com", "4537829158"},
                {2, "Avinash", "Kati", "avinashK@example.com", "4892184058"},
                {3, "Lahri", "Rath", "lahri.rath@example.com", "4528727830"}
        };

        for (int i = 0; i < data.length; i++) {
            Row dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                dataRow.createCell(j).setCellValue(data[i][j].toString());
            }
        }

        // Write data to Excel file
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        }

        // Close the workbook
        workbook.close();

        // Read data from Excel file
        workbook = new XSSFWorkbook(filePath);
        sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] excelData = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                excelData[i][j] = cell.getStringCellValue();
            }
        }

        // Close the workbook
        workbook.close();

        return excelData;
    }

    @Test(dataProvider = "Registration")
    public void registerTest(String id, String firstName, String lastName, String email, String phoneNumber) {
        // Find the input fields and enter text
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='number']"));

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter the data in the fields
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);

        // Click Submit
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        // Switch to alert
        Alert message = driver.switchTo().alert();
        // Get alert message
        System.out.println("Alert message: " + message.getText());
        message.accept();

        // Refresh the page
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
