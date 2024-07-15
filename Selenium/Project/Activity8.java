package Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {

	WebDriver driver;
	WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }

    @Test
    public void traversingTables() throws InterruptedException {
    	
    	WebElement userName= driver.findElement(By.xpath("//*[@id='user_name']"));
    	userName.click();
    	userName.sendKeys("admin");
    	
    	WebElement password= driver.findElement(By.xpath("//*[@id='username_password']"));
    	password.click();
    	password.sendKeys("pa$$w0rd");
    	
    	driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
    	
    	
    	
    	driver.findElement(By.xpath("(//a[contains(text(),'Sales')])[1]")).click();
    	driver.findElement(By.xpath("//*[@id='moduleTab_9_Accounts']")).click();
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[@class=' inlineEdit']")));
    
    	List<WebElement> listOfNames= driver.findElements(By.xpath("//td[@class=' inlineEdit']"));
    	int count=0;
    	for(int j=0;j<=listOfNames.size();j+=2){
    			System.out.println(listOfNames.get(j).getText());
    			count++;
    			if(count==5)
    				break;
    		
    	}
    	
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
