package bookshelfAutomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;


public class base 
{
	
	 protected static WebDriver driver;
	 static String projectPath = System.getProperty("user.dir");
	
	 public static WebDriver driver (String browser) 
 		{	
		 	if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		 	}
		 	
			else if (browser.equalsIgnoreCase("firefox")) 
			{
			System.setProperty("webdriver.gecko.driver", projectPath + "\\driver\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			}
			else
			{
			Reporter.log("Browsers Not Found");
			}

			driver.manage().window().maximize();

			return driver;
         }
	
	 public static Properties setProperties() throws IOException
	{
			Properties prop = new Properties();
			FileInputStream file = null;
			file = new FileInputStream(projectPath+"\\Properties\\config.properties");
			prop.load(file);
			
			return prop;
			
	}
		
	public void screenshot()
	{
		
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try 
			{
				FileHandler.copy(screenshot,
				new File(System.getProperty("user.dir")+"\\screenshots\\image.png"));
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}		
	} 
	
	public void closeDriver()
	{
		driver.close();
	}
		
}
	
	

