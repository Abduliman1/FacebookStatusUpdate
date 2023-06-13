package FirstTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookStatusUpdate {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Setting up ChromeDriver
        driver = new ChromeDriver(); // Creating ChromeDriver instance
        driver.manage().window().maximize(); // Maximize the browser window
    }

    @Test
    public void testFacebookStatusUpdate() {
       
    	// login page
    	driver.get("https://web.facebook.com/"); 

        // email
        driver.findElement(By.id("email")).sendKeys("abdulimanautomation@gmail.com");
        
        // password
        driver.findElement(By.id("pass")).sendKeys("Automation1");
        
        // login button
        driver.findElement(By.name("login")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10); // Create WebDriverWait instance
        
        // Facebook logo
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Facebook']"))).click();
        
        // "Create story"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Create story']"))).click();
        
        // story creation preview
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Stories creation preview']/div/div/div/div/div[2]/div"))).click();
        
        // "Start typing" field
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@aria-label='Start typing']"))).click();
        
        // text "Hello World"
        driver.findElement(By.xpath("//label[@aria-label='Text']")).sendKeys("Hello World");
        
        // "Share to Story" button
        driver.findElement(By.xpath("//div[@aria-label='Share to Story']/div/div/div/span/span")).click();
    }

    @After
    public void tearDown() {
    	 // Quit the browser
        driver.quit();
    }
}
