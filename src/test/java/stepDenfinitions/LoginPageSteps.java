package stepDenfinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	WebDriver driver;
	WebDriverWait wait;
	String username, password, loginUrl;

	@Given("^I open browser$")
	public void i_open_browser() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("^I get login url$")
	public void i_get_login_url() {
		driver.get("http://demo.guru99.com/v4/");
		loginUrl = driver.getCurrentUrl();
	}

	@When("^I click to here link$")
	public void i_click_to_here_link() {
		driver.findElement(By.xpath("//a[text() ='here']")).click();
	}

	@When("^I input to email textbox$")
	public void i_input_to_email_textbox() {
		WebElement emailTxtBox = driver.findElement(By.xpath("//input[@name='emailid']"));
		waitForElementVisible(emailTxtBox);
		emailTxtBox.sendKeys("trangdk" + random() + "@gmail.com");
	}

	@When("^I click to submit button$")
	public void i_click_to_submit_button() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@When("^I get to username information$")
	public void i_get_to_username_information() {
		WebElement userName = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td"));
		username = userName.getText();
	}

	@When("^I get to password information$")
	public void i_get_to_password_information() {
		WebElement passwordtxt = driver
				.findElement(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td"));
		password = passwordtxt.getText();
	}

	@When("^I open login page$")
	public void i_open_login_page() {
		driver.get(loginUrl);
	}

	@When("^I input to username textbox$")
	public void i_input_to_username_textbox() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
	}

	@When("^I input to password textbox$")
	public void i_input_to_password_textbox() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("^I submit button$")
	public void i_submit_button() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I verify homepage welcome message displayed$")
	public void i_verify_homepage_welcome_message_displayed() {
		WebElement homePage = driver.findElement(By.xpath("//marquee"));
		assertTrue(homePage.isDisplayed());
	}

	@And("^I click to New Customer Page$")
	public void i_click_to_new_customer_page() {
		driver.findElement(By.xpath("//a[(text()='New Customer')]")).click();
	}

	@And("^I input all information in this page$")
	public void i_input_all_information_in_this_page(DataTable table) {
		WebElement customerName = driver.findElement(By.xpath("//input[@name='name']"));
		WebElement gender = driver.findElement(By.xpath("//input[@value='f']"));
		WebElement DOB = driver.findElement(By.xpath("//input[@name='dob']"));
		WebElement add = driver.findElement(By.xpath("//textarea[@name='addr']"));
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		WebElement pin = driver.findElement(By.xpath("//input[@name='pinno']"));
		WebElement phoneNo = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		WebElement mail = driver.findElement(By.xpath("//input[@name='emailid']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		customerName.sendKeys(customer.get(0).get("Customer"));
		gender.click();
		DOB.sendKeys(customer.get(0).get("DateOfBirth"));
		add.sendKeys(customer.get(0).get("Address"));
		city.sendKeys(customer.get(0).get("City"));
		state.sendKeys(customer.get(0).get("State"));
		pin.sendKeys(customer.get(0).get("PIN"));
		phoneNo.sendKeys(customer.get(0).get("Phone"));
		mail.sendKeys(customer.get(0).get("Email") + random() + "@gmail.com");
		password.sendKeys(customer.get(0).get("Password"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^I click sub button$")
	public void i_click_sub_button() {
		driver.findElement(By.xpath("//input[@name='sub']"));
	}

	@Then("^I close browser$")
	public void i_close_browser() {
		driver.close();
	}

	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementForVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public int random() {
		Random random = new Random();
		int number = random.nextInt(9999999);
		return number;
	}

}
