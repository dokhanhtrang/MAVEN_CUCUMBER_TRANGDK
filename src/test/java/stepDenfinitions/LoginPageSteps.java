package stepDenfinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	WebDriver driver;
	WebDriverWait wait;

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
		driver.findElement(By.xpath("//a[text() ='here']")).click();

	}

	@When("^I click to here link$")
	public void i_click_to_here_link() {

	}

	@When("^I input to email textbox$")
	public void i_input_to_email_textbox() {

	}

	@When("^I click to submit button$")
	public void i_click_to_submit_button() {

	}

	@Then("^I get to usernam information$")
	public void i_get_to_usernam_information() {

	}

	@Then("^I get to password information$")
	public void i_get_to_password_information() {

	}

	@Then("^I open login page$")
	public void i_open_login_page() {

	}

	@Then("^I input to password textbox$")
	public void i_input_to_password_textbox() {

	}

	@Then("^I submit button$")
	public void i_submit_button() {

	}

	@Then("^I verify homepage welcome message displayed$")
	public void i_verify_homepage_welcome_message_displayed() {

	}
	public void waitForElementVisible (WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
