package StepDefiniton;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver;

	@Given("^Abrir Chrome$")
	public void abrir_Chrome() throws Throwable {
		System.setProperty ("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/BancoPlatinum/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	// login ok
	
	@When("^Ingresa correctamente Username \"([^\"]*)\" y Password \"([^\"]*)\"$")
	public void ingresa_correctamente_Username_y_Password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg1);
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Then("^Validar que el title sea Welcome$")
	public void validar_que_el_title_sea_Welcome() throws Throwable {
		assertEquals(driver.getTitle(), "Welcome");
	}

	// login error (vacio)
	
	
	@When("^Ingresa nada en Username \"([^\"]*)\" y Password \"([^\"]*)\"$")
	public void ingresa_nada_en_Username_y_Password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg1);
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	// login error
	
	@When("^Ingresa erroneamente Username \"([^\"]*)\" y Password \"([^\"]*)\"$")
	public void ingresa_erroneamente_Username_y_Password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg1);
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Then("^Validar que el title sea Error$")
	public void validar_que_el_title_sea_Error() throws Throwable {
		assertEquals(driver.getTitle(), "Error");
	}
}
