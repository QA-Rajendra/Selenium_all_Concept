import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // Set the path to chromedriver executable if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open a website (e.g., Google)
        driver.get("https://www.google.com");

        // Optionally, maximize the browser window
        driver.manage().window().maximize();

        // Wait for a few seconds to see the browser
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
