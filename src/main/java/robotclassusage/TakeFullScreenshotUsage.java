package robotclassusage;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakeFullScreenshotUsage {
	
	public WebDriver driver;
	
	
	@Test
	public void test() throws AWTException, IOException {
		
		driver=new EdgeDriver();
		driver.get("http://keyevents.netlify.app");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		try {
			
			Robot robot=new Robot();
			//Toolkit is a Java AWT class that gives access to native GUI components and system-level resources, like:screensize
			//fonts.image//This method returns the default Toolkit instance for your platform
			//A Rectangle is the simplest and most standard way in Java to define a 2D area (x, y, width, height).
			//BufferedImage is a standard Java class used to manipulate or save images in memory.
			
			Rectangle area=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage mage=robot.createScreenCapture(area);
			File file = new File("test-output/RobotRelated/robot_screenshot_" + timestamp + ".png");
			ImageIO.write(mage,"png",file);
			
		}finally {
			 driver.quit(); 
		}
	}

}
