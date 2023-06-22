package cubes.pages.tag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;

public class TagsListPage {

	private String url;
	private WebDriver driver;
	
	private WebElement addNewTagWebElement;
	
	public TagsListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewTagWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnAddNewTag() {
		addNewTagWebElement.click();
	}
	
	public void clickOnUpdateTag(String tagName) {
		WebElement updateWebElement = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr/td[5]/div[1]/a[2]"));
		MyWebDriver.scroolToWebElement(driver, updateWebElement);
		updateWebElement.click();
	}
	
	public void clickOnDeleteTag(String tagName) {
		WebElement deleteWebElement = driver.findElement(By.xpath("//strong[text()='"+tagName+"']//ancestor::tr/td[5]/div[1]/button[1]"));
		MyWebDriver.scroolToWebElement(driver, deleteWebElement);
		deleteWebElement.click();
	}
	
	public void clickOnDeleteDialogCancelButton() {
		WebElement cancelWebElement = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelWebElement.click();
	}
	
	public void clickOnDeleteDialogCloseButton() {
		WebElement closeWebElement = driver.findElement(By.xpath("//button[@class='close']"));
		closeWebElement.click();
	}
	
	public void clickOnDeleteDialogDeleteButton() {
		WebElement deleteWebElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteWebElement.click();
	}
	public boolean isTagNameElementOnPage(String tagName) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='"+tagName+"']"));
		return webElements.size()>0;
	}
	
	public void clickOnLogoutIcon() {
	WebElement logoutIconWebElement = driver.findElement(By.xpath("//i[@class='far fa-user']"));
	logoutIconWebElement.click();
	}
	
	public void clickOnLoguout() {
	WebElement logoutWebElement = driver.findElement(By.xpath("//a[@href='https://testblog.kurs-qa.cubes.edu.rs/logout']"));
	logoutWebElement.click();
	}
}
