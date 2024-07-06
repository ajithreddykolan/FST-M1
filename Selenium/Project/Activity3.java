package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }

    @Test
    public void getCopyrightText() {
    	
    	if(driver.findElement(By.xpath("//a[@id='admin_options']")).isDisplayed()) {
    	   String copyrightText= driver.findElement(By.xpath("//a[@id='admin_options']")).getText();
    	   System.out.println("Copyright text in the footer: "+copyrightText);
    	}
    	
    
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
