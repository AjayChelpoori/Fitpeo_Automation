package fit_Automation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Fit_Automation_Test {

	public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AJAY\\eclipse-workspace\\Fitpeo_Automation\\src\\browsers\\chromedriver.exe");

	        // Initialize ChromeDriver
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");  // Open browser maximized
	        WebDriver driver = new ChromeDriver(options);

	        // Create an explicit wait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        try {
	            // Step 1: Navigate to FitPeo Homepage
	            driver.get("https://fitpeo.com");
	            driver.manage().window().maximize();
	            
	            // Step 2: Navigate to the Revenue Calculator Page
	            driver.get("https://fitpeo.com/revenue-calculator");
	            driver.manage().window().maximize();
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	    		js.executeScript("window.scrollBy(0, 150)");
	    		
	            // Step 3: Scroll Down to the Slider section
	    		WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]/input"));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(slider).perform();
	            Thread.sleep(500);

	            // TestCase-4 Adjust the Slider
	    		js.executeScript("window.scrollBy(0, 100)");
	    		actions.dragAndDropBy(slider, 94, 0).perform();
	    		js.executeScript("window.scrollBy(0, 100)");
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys("820");
	    		String fieldText = driver.findElement(By.id(":R57alklff9da:")).getAttribute("value");
	    		System.out.println("Slider is moved Text Field Value is : "+ fieldText);

	    	    // TestCase-5 Update the Text Field
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	    		Thread.sleep(200);
	    		int intialSliderX = slider.getLocation().getX();
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys("560");
	    		String updatedfieldText = driver.findElement(By.id(":R57alklff9da:")).getAttribute("value");
	    		System.out.println("Updated Text Field to : "+ updatedfieldText);



	    		// TestCase-6 Validate Slider Value
	    		int afterSliderX = slider.getLocation().getX();
	    		if (intialSliderX < afterSliderX) {
	    			System.out.println("slider is  change the according value");
	    		} else {
	    			System.out.println("slider is not  change the according value");
	    		}

	    		           //value updated to 820
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	    		driver.findElement(By.id(":R57alklff9da:")).sendKeys("820");
	    		
	    	    // TestCase-7 Select CPT Codes 
	    		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
	    		System.out.println("Select the CheckBox - CPT-99091");

	    		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
	    		System.out.println("Select the CheckBox - CPT-99453");

	    		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
	    		System.out.println("Select the CheckBox - CPT-99454");

	    		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();
	    		System.out.println("Select the CheckBox - CPT-99474");


	    		// TestCase-8 shows the value $110700.
	    		String Expected_shows_value = "$110700" ;
	    		String  TotalIndividualPatient_Month = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[2]")).getText();
	    		System.out.println("Total Individual Patient/Month : " + TotalIndividualPatient_Month);
	    		if (Expected_shows_value.equals(TotalIndividualPatient_Month)) {
	    			System.out.println("Total Recurring Reimbursement for all Patients Per Month  is Equals");
	    		} else {
	    			System.out.println("Total Recurring Reimbursement for all Patients Per Month  is Not�Equals");
	    		}
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}

