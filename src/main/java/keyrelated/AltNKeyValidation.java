package keyrelated;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AltNKeyValidation {
	
	public WebDriver driver;
	
	
	@Test
	public void test() {
		
		driver=new EdgeDriver();
		driver.get("http://keyevents.netlify.app");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		try {
			driver.findElement(By.tagName("body")).click();
			
			//to open new file/open header items 
			Actions action=new Actions(driver);
			action.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();
			
			  // The app shows a table – locate first “keydown” row
	        WebElement firstRow = driver.findElement(By.cssSelector("table tbody tr"));
	        String rowText = firstRow.getText();

	        System.out.println("Log entry: " + rowText);
	        Assert.assertTrue(rowText.contains("n"), "Key 'n' missing");
	        Assert.assertTrue(rowText.contains("true"), "Alt key not detected");
		}finally {
			// driver.quit(); 
		}
	}

}
