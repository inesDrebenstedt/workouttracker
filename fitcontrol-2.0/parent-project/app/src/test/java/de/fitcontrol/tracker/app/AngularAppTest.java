package de.fitcontrol.tracker.app;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularAppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Assuming you have added chromedriver to the system path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open the Angular app URL (served by Spring Boot or a different server)
        driver.get("http://localhost:4200");
    }
    
    @Test
    public void testAngularComponentLoad() {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("angularComponent")));
        assertNotNull(element);
    }

    @Test
    public void testPageTitle() {
        // Test the title of the Angular app
        String expectedTitle = "My Angular App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testLoginForm() {
        // Find the username input field using Angular's attributes like ng-model, id, or class
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submitBtn"));

        // Simulate user input
        username.sendKeys("testuser");
        password.sendKeys("password");

        // Submit the form
        submitButton.click();

        // Validate that login was successful by checking for redirected URL or presence of an element
        String expectedUrl = "http://localhost:4200/dashboard";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Close the browser after each test
        driver.quit();
    }
}
