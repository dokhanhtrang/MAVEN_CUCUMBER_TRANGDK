package stepDenfinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginPageGuruSteps {
	WebDriver driver;

	@Given("^I open to live guru site$")
	public void i_open_to_live_guru_site() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^I open to my account page$")
	public void i_open_to_my_account_page() {
		driver.findElement(By.xpath("//div[@class ='footer']//a[text() ='My Account']")).click();

	}

	@When("^I input to username textbox is \"([^\"]*)\"$")
	public void i_input_to_username_textbox_is_something(String userName) {
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys(userName);
	}

	@And("^I input to password textbox is \"([^\"]*)\"$")
	public void i_input_to_password_textbox_is_something(String password) {
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(password);
	}

	@And("^I click to login button$")
	public void i_click_to_login_button() {
		driver.findElement(By.xpath("//button[@id='send2']")).click();
	}

	@Then("^I verify homepage display$")
	public void i_verify_homepage_display() {
		assertTrue(driver.findElement(By.xpath("//h1[contains(.,'My Dashboard')]")).isDisplayed());
	}

	@When("^I click to Account Link$")
	public void i_click_to_account_link() {
		driver.findElement(By.xpath("//*[@id='header']//span[text()='Account']")).click();
	}

	@And("^I click to logout link$")
	public void i_click_to_logout_link() {
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	}

}
