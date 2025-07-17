import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SignUpPageTestwithTestNG {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set the path to chromedriver executable if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://your-signup-page-url.com"); // Change to your actual URL
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSignUpPageElementsPresent() {
        // Wait for page title
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sign Up']")));
        Assert.assertTrue(title.isDisplayed(), "Sign Up title is not displayed");

        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='First Name']")).isDisplayed(), "First Name input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).isDisplayed(), "Last Name input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Mobile']")).isDisplayed(), "Mobile input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Email']")).isDisplayed(), "Email input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Password']")).isDisplayed(), "Password input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).isDisplayed(), "Confirm Password input not visible");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(.,'Sign Up')]")).isEnabled(), "Sign Up button is not enabled");
    }

    @Test
    public void testSignUpWithValidData() {
        fillSignUpForm("John", "Doe", "1234567890", "john.doe@example.com", "Test@1234", "Test@1234");
        driver.findElement(By.xpath("//button[contains(.,'Sign Up')]")).click();

        // Wait for success or next page, adjust as per actual behavior
        // Example: wait for a success message (replace locator as needed)
        // WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-msg")));
        // Assert.assertTrue(successMsg.isDisplayed(), "Sign Up was not successful!");
    }

    @Test
    public void testSignUpWithMismatchedPasswords() {
        fillSignUpForm("Jane", "Smith", "9876543210", "jane.smith@example.com", "Password1!", "Password2!");
        driver.findElement(By.xpath("//button[contains(.,'Sign Up')]")).click();

        // Check for password mismatch error message (adjust locator as needed)
        // WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-mismatch-error")));
        // Assert.assertTrue(errorMsg.isDisplayed(), "Password mismatch error message not displayed.");
    }

    @Test
    public void testSignUpWithInvalidEmail() {
        fillSignUpForm("Ali", "Khan", "5551234567", "invalidemail", "ValidPass1!", "ValidPass1!");
        driver.findElement(By.xpath("//button[contains(.,'Sign Up')]")).click();

        // Check for invalid email error message (adjust locator as needed)
        // WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invalid-email-error")));
        // Assert.assertTrue(errorMsg.isDisplayed(), "Invalid email error message not displayed.");
    }

    private void fillSignUpForm(String firstName, String lastName,
                                String mobile, String email, String password, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).clear();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder='Mobile']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys(mobile);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmPassword);
    }
}
