package steps2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdef02 {
	WebDriver driver;

	@Given("User Launches Chrome Browser")
	public void user_launches_chrome_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Then("User Enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("User enters a Credentials")
	public void user_enters_a_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		String username = dataTable.cell(0, 0);
		String password = dataTable.cell(0, 1);
		
		// Login
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--medium oxd-button')]")).click();
		Thread.sleep(2000);
	}

	@Then("user clicks a admin button")
	public void user_clicks_a_admin_button() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
	}

	@Then("user clicks a Nationality button")
	public void user_clicks_a_nationality_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Nationalities']")).click();
		Thread.sleep(2000);
	}

	@Then("it Goes to nationality page")
	public void it_goes_to_nationality_page() throws InterruptedException {
//		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
//		Thread.sleep(2000);
	}

	@Then("user enters nationality records")
	public void user_enters_nationality_records(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<List<String>> NationData = dataTable.cells();
		
		for(int i=0;i<NationData.size();i++) {
			String Nationname = NationData.get(i).get(0); 
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[starts-with(@class,'oxd-input')])[2]")).sendKeys(Nationname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(2000);
		}
		
	}

}
