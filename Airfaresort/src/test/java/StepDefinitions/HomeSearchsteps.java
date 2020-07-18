package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSearchsteps {
	
	WebDriver driver = null;
	
	@Given("the user is on the flight search page")
	public void the_user_is_on_the_flight_search_page() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is" +projectPath);
	   
		System.getProperty("webdriver.chromedriver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
    String url = "https://www.cleartrip.com";
    driver.get(url);
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	

	}

	@When("the user enters  Hyderabad")
	public void the_user_enters_Hyderabad() {
		
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).clear();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Hyderabad, IN - Rajiv Gandhi International (HYD)");
	
		
		//driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/a[text()='Hyderabad, IN - Rajiv Gandhi International (HYD)']")).click();
		


	}

	@And("the user enters  Chennai")
	public void the_user_enters_Chennai() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("//input[@id='ToTag']")).click();
		driver.findElement(By.xpath("//input[@id='ToTag']")).clear();
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Chennai, IN - Chennai Airport (MAA)");
		
	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

	}

	@And("the user selects the travel date")
	public void the_user_selects_the_travel_date() throws InterruptedException, AWTException {
		
		
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys("Mon, 20 Jul, 2020");
		
		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		Thread.sleep(2000);
		
		
		/*String date = "21-Jul-2020";
		String splitter[] = date.split("-");
		String month_year = splitter[0];
		String day = splitter[7];	
		System.out.println(month_year);
		System.out.println(day);*/
	   
	}

	@And("clicks search")
	public void clicks_search() throws InterruptedException {
	    
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(5000);
	}

	@Then("the user is able to navigate to the seach result page")
	public void the_user_is_able_to_navigate_to_the_seach_result_page() {
		
		driver.getPageSource().contains("Flight details");
		
	}

	@Then("the user sorts for cheapest and quickest flight")
	public void the_user_sorts_for_cheapest_and_quickest_flight() {
		
		//Sorting based on duration
		
		String arrow_direction = driver.findElement(By.xpath("//span[contains(text(),'Duration')]")).getAttribute("class");
		if(!arrow_direction.contains("up"))
		driver.findElement(By.xpath("//span[contains(text(),'Duration')]")).click();	
		
		// System retrieves the Cheapest flight by default
		
		//driver.findElement(By.xpath("//div[@class='col-19']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//div[1]")).click();
		
	    
	}

	@Then("the user finds the sorted search")
	public void the_user_finds_the_sorted_search() {
		
		driver.findElement(By.xpath("//div[@class='col-19']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//div[1]")).click();
		
		String quickest = driver.findElement(By.xpath("//h3[@class='fs-3 c-neutral-900 fw-500']")).getText();
		
		System.out.println("Quickest available flight" + quickest);
		
	    
		/* Details of Cheapest flight
		   driver.findElement(By.xpath("//div[@class='col-19']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//div[1]")).click();
           String Cheapest = driver.findElement(By.xpath("//h3[@class='fs-3 c-neutral-900 fw-500']")).getText();
		    System.out.println("Quickest available flight" + Cheapest);*/
		
		
		
	   
	}

	}

	