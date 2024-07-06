package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
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
    public void getURLOfHeaderImage() {
    	
    	if(driver.findElement(By.xpath("//div[@class='companylogo']")).isDisplayed()) {
    	   String url= driver.findElement(By.xpath("//div[@class='companylogo']//child::*")).getAttribute("src");
    	   System.out.println("URL of the header image: "+url);
    	}
    	
    
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
