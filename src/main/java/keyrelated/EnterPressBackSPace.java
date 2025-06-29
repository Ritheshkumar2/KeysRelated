package keyrelated;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;



public class EnterPressBackSPace {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeTest
	public void launchTheURL() {
		driver=new ChromeDriver();
		
		driver.get("https://techbeamers.com/selenium-practice-test-page/");
		//https://demo.guru99.com/test/upload/
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	@Test
	public void test() {
		
		WebElement user=driver.findElement(By.cssSelector("#username"));
		user.sendKeys("InputValue");
		user.sendKeys(Keys.ENTER);
		user.sendKeys(Keys.TAB);
		user.sendKeys(Keys.BACK_SPACE);
		
//	if tab not works mostly it is due to nextelement isn’t focusable (like a <div> or hidden input), focus will not move.
		
		WebElement email=driver.findElement(By.cssSelector("#email"));
		email.sendKeys("test@gmail.com");
		
		for(int i=0;i<20;i++){
			email.sendKeys(Keys.ARROW_LEFT);
		}
		
		
		Actions action=new Actions(driver);
		action.moveToElement(email)
		.keyDown(Keys.SHIFT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.sendKeys(Keys.ARROW_RIGHT)
		.keyUp(Keys.SHIFT)
		.perform();
		
		email
		.sendKeys(Keys.chord(Keys.CONTROL,"c"));
	
		
		WebElement targetBox=driver.findElement(By.cssSelector("#bio"));
		targetBox.sendKeys(Keys.chord(Keys.CONTROL, "v"));
		
		
	}
	
	@Test
	public void testone() {
		
		WebElement element=driver.findElement(By.cssSelector("#country"));
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#country")));
		//below concept is applicable only when there is no select attribute
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		
		System.out.print(element.getText());
		
	}
	

}
