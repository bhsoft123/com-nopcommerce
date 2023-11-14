package browsertesting;
/*Project-1 - ProjectName : com-nopcommerce
BaseUrl = https://demo.nopcommerce.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Navigate to Url.
“https://demo.nopcommerce.com/login?returnUrl=
%2F”
7. Print the current url.
8. Navigate back to the home page.
9. Navigate to the login page.
10. Print the current url.
11. Refresh the page.
12. Enter the email to email field.
13. Enter the password to password field.
14. Click on Login Button.
15. Close the browser.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. Setup browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2. Open Url
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //to maximize window
        driver.manage().window().maximize();
        //Print the title of the page
        System.out.println("Title of the page : " + driver.getTitle());
        //Print the current URl
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //Print the current page source
        System.out.println("Page source code:" + driver.getPageSource());

        //Navigate to Login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);
        //To make the process slower by 5 sec
        //Thread.sleep(5000);
        //Print the current Url
        System.out.println("Current URL: " +driver.getCurrentUrl());
        //Navigate back to home page
        driver.navigate().back();
        //Navigate to login page
        driver.navigate().to(loginUrl);
        //Print the current Url
        System.out.println("Current URL:" +driver.getCurrentUrl());
        //Thread.sleep(5000);
        //Refresh the page
        driver.navigate().refresh();
        //Find login element and click on it
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Find Email Field Element and Type in the email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");
        //Find Password Field element and Type in the password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("12345");
        // click on link with the text "Login"
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        button.click();
        Thread.sleep(5000);
        //Close the browser
        driver.quit();
    }
}