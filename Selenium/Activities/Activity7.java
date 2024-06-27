package examples;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity7 {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the football
        WebElement football = driver.findElement(By.id("draggable"));
       
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
       
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

  
        builder.clickAndHold(football).moveToElement(dropzone1).pause(5000).release().build().perform();
 
        
        builder.dragAndDrop(football, dropzone2).build().perform();
        
       
        
        driver.close();
    }
}

