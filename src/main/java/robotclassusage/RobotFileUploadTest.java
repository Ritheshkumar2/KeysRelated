package robotclassusage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

@Test
public class RobotFileUploadTest {
	
	public WebDriver driver;
	public void test() throws AWTException {
		 driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://practice.expandtesting.com/upload");
	        
	        driver.findElement(By.cssSelector("#fileInput")).click();
	        
	       // driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\rithesh\\Documents\\resume.pdf");
	        
	        String filePath="C://Users//hp//OneDrive//Documents//CERTIFICATES//html-certificate.pdf";
	        
	        StringSelection selection=new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	        
	        Robot robot = new Robot();
	        robot.delay(1000); 
	       
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	       

	        
	        robot.delay(500); // Wait for paste action

	        // Press Enter to confirm the file selection
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);


	        // Click the "Upload" button
	        driver.findElement(By.id("file-submit")).click();
	        
	        String uploadedText = driver.findElement(By.id("uploaded-files")).getText();
	        if (uploadedText.contains("resume.pdf")) {
	            System.out.println("✅ File uploaded successfully!");
	        } else {
	            System.out.println("❌ Upload failed.");
	        }
	        
	        driver.quit();
	
	        
	}
	}
