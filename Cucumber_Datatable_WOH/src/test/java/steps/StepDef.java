package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	WebDriver driver;

	@Given("User Launches Chrome Browser")
	public void user_launches_chrome_browser() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		

	}

	@Then("User Enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("user enters the credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		String username = dataTable.cell(0, 0);
		String password = dataTable.cell(0, 1);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--medium oxd-button')]")).click();
	}
	@Then("go to skill page")
	public void go_to_skill_page() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'topbar-body')])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[starts-with(text(),'Skills')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[starts-with(@class,'oxd-button')]")).click();
	}

	@Then("user enters skills records as")
	public void user_enters_skills_records_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<List<String>> SkillsData = dataTable.cells();
		
		for(int i=0;i<SkillsData.size();i++) {   //0<3,1<3,2<3,3<3
			
			String skillname = SkillsData.get(i).get(0);   //3,0
			String skilldescription = SkillsData.get(i).get(1);//2,1
			
		
		
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
		
		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input--active')])[2]")).sendKeys(skillname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[contains(@class,'textarea--resize')]")).sendKeys(skilldescription);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}

	}

	@Then("user clicks logout button")
	public void user_clicks_logout_button() {

	}

	@Then("user close the browser")
	public void user_close_the_browser() {
	    
	}

}
