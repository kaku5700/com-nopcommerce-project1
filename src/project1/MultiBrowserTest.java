package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "Chrome"; // static variable
    static WebDriver driver; //storing webdriver object to variable

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Incorrect Browser Name");
        }
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F"); // opening provided url in chrome Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // telling browser to wait implicity

        System.out.println(driver.getTitle()); // get the title of the web page.
        System.out.println("The current url of the page is :" + driver.getCurrentUrl()); // getting ans printing current url of the page.
        Thread.sleep(5000);

        System.out.println("The page source is :" + driver.getPageSource()); // Getting and printing the current page source.

        driver.findElement(By.id("Email")).sendKeys("jaynikapatel1@gmail.com");
        Thread.sleep(5000);

        driver.findElement(By.id("Password")).sendKeys("12345");
        Thread.sleep(5000);

        driver.quit();
    }
}

