import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPageTest {
    public static void main(String[] args) {
        // Set the path to chromedriver executable if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open Sign Up Page
            driver.get("https://your-signup-page-url.com"); // Change to your actual URL

            // Wait for page title
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sign Up']")));
            Assert.assertTrue(title.isDisplayed(), "Sign Up title is not displayed");

            // Fill fields with waits and assertions
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
            WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile']"));
            WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            WebElement confirmPassword = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
            WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(.,'Sign Up')]"));

            Assert.assertTrue(firstName.isDisplayed(), "First Name input not visible");
            Assert.assertTrue(lastName.isDisplayed(), "Last Name input not visible");
            Assert.assertTrue(mobile.isDisplayed(), "Mobile input not visible");
            Assert.assertTrue(email.isDisplayed(), "Email input not visible");
            Assert.assertTrue(password.isDisplayed(), "Password input not visible");
            Assert.assertTrue(confirmPassword.isDisplayed(), "Confirm Password input not visible");
            Assert.assertTrue(signUpBtn.isEnabled(), "Sign Up button is not enabled");

            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            mobile.sendKeys("1234567890");
            email.sendKeys("john.doe@example.com");
            password.sendKeys("Test@1234");
            confirmPassword.sendKeys("Test@1234");

            // Submit the form
            signUpBtn.click();

            // Wait for success or next page, adjust as per actual behavior
            // Example: wait for a success message (replace locator as needed)
            // WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-msg")));
            // Assert.assertTrue(successMsg.isDisplayed(), "Sign Up was not successful!");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
