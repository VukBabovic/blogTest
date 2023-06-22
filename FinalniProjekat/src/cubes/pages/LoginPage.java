package cubes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private String url;
	private WebDriver driver;
	//Web elements
	private WebElement emailWebElement;
	private WebElement passwordWebElement;
	private WebElement loginButtonWebElement;
	//napravim konstruktor u kojem inicijalizujem elemente a onda pravim metode koje predstavljaju funkcionalnost ove stranice
	public LoginPage(WebDriver driver) {
		this.url = "http://testblog.kurs-qa.cubes.edu.rs/login";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.emailWebElement = this.driver.findElement(By.name("email"));
		this.passwordWebElement = this.driver.findElement(By.name("password"));
		this.loginButtonWebElement = this.driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	public void openPage() {
		this.driver.get(url);
	}
	//metodi kazem da ubaci email, metoda trazi email koji zelim da ubacim. u web element ubacim taj email
	public void insertEmail(String email) {
		emailWebElement.clear();
		emailWebElement.sendKeys(email);
	}
	//metodi kazem da ubaci password, metoda trazi password koji zelim da ubacim.  uweb element ubacim taj password
	public void insertPassword(String password) {
		passwordWebElement.clear();
		passwordWebElement.sendKeys(password);
	}
	
	public void clickOnLogin() {
		loginButtonWebElement.click();
	}
	
	public boolean checkEmailError(String emailError) {
		//metoda prosledjujem string koji treba da predstavlja tekst poruke koji ce biti ispisan u email erroru. u metodi kazem da mi pronadje Web Element koji treba da predstavlja error i dobicu ga.
		//kad pronadjem email error uzmi tekst i proveri da li je tekst ono sto sam prosledio.
		WebElement emailErrorElement = driver.findElement(By.id("email-error"));
		
		return emailErrorElement.getText().equalsIgnoreCase(emailError);
	}
	
	
	public boolean checkPasswordError(String passwordError) {
		WebElement passwordErrorElement = driver.findElement(By.id("password-error"));
		
		return passwordErrorElement.getText().equalsIgnoreCase(passwordError);
	}
	
	public boolean checkMessageError(String massage) {
		WebElement massageErrorElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/strong[1]"));

		return massageErrorElement.getText().equalsIgnoreCase(massage);
	}
	
	public void login(String email, String password) {
		insertEmail(email);
		insertPassword(password);
		clickOnLogin();
	}
	//uspesno me uloguj da ne pamtim. ide u sve Before class delove
	public void loginSuccess() {
		login("kursqa@cubes.edu.rs", "cubesqa");
	}
}
