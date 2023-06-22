package cubes.pages.tag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagsAddPage {

	private String url;
	private WebDriver driver;
	
	
	private WebElement tagNameWebElement;
	private WebElement saveButtonWebElement;
	private WebElement cancelButtonWebElement;
	private WebElement tagLinkWebElement;
	private WebElement navLinkwebElement;
	
	public TagsAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add";
		this.driver = driver;
		
		this.tagNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
		this.saveButtonWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.cancelButtonWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
		this.tagLinkWebElement = driver.findElement(By.linkText("Tags"));
		this.navLinkwebElement = driver.findElement(By.xpath("//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/tags']"));
	}
	
	public void openPage() {
		this.driver.get(url);
	}
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnSave() {
		saveButtonWebElement.click();
	}
	
	public void clickOnCancel() {
		cancelButtonWebElement.click();
	}
	
	public void clickOnLinkTag() {
		tagLinkWebElement.click();
	}
	
	public void clickOnNavLink() {
		navLinkwebElement.click();
	}
	
	public void insertName(String name) {
		tagNameWebElement.clear();
		tagNameWebElement.sendKeys(name);
	}
	
	public String getName() {
		return tagNameWebElement.getAttribute("value");
	}

	public boolean isErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDivErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isTagNameTooLong(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//span[@class='error text-danger']"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
}
