package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */
public class ChromeBrowserTest {
    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://demo.nopcommerce.com/";

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into Browser
        driver.get(baseUrl);

        // Maximise the Browser
        driver.manage().window().maximize();

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the Title of the Page
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current URL
        System.out.println("The current Url :" + driver.getCurrentUrl());

        // Get Page Source Code
        System.out.println(driver.getPageSource());

        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

        driver.navigate().to(loginUrl);
        System.out.println("Get current url : " + driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("Get current url : " + driver.getCurrentUrl());

        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println("Get current url : " + driver.getCurrentUrl());

        Thread.sleep(2000);
        driver.findElement(By.id("Email")).sendKeys("jaynikapatel1@gmail.com");

        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("12345");

        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}