package cubes.pages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesAddPage {
	
	private String url;
	private WebDriver driver;
	
	private WebElement categoryNameWebElement;
	private WebElement categoryDescriptionWebElement;
	private WebElement saveButtonWebElement;
	private WebElement cancelButtonWebElement;
	private WebElement categoryLinkWebElement;
	private WebElement navLinkWebElement1;
	
	public CategoriesAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
		this.driver = driver;
		
		this.categoryNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
		this.categoryDescriptionWebElement = driver.findElement(By.xpath("//textarea[@name='description']"));
		this.saveButtonWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.cancelButtonWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
		this.categoryLinkWebElement = driver.findElement(By.partialLinkText("Post Cat"));
		this.navLinkWebElement1 = driver.findElement(By.xpath("//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories']"));
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
	
	public void clickOnCategoryLink() {
		categoryLinkWebElement.click();
	}
	
	public void clickOnNavLink() {
		navLinkWebElement1.click();
	}
	
	public void insertName(String name) {
		categoryNameWebElement.clear();
		categoryNameWebElement.sendKeys(name);
	}
	
	public void insertDescription(String description) {
		categoryDescriptionWebElement.clear();
		categoryDescriptionWebElement.sendKeys(description);
	}
	
	public String getName() {
		return categoryNameWebElement.getAttribute("value");
	}
	
	public boolean isErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isDivErrorOnPage(String error) {
		WebElement divErrorWebElement = driver.findElement(By.id("description-error"));
		
		return divErrorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDescriptionTooShort(String error) {
		WebElement fewerCharactersInDescription = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return fewerCharactersInDescription.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDescriptionTooLong(String error) {
		WebElement descriptionTooLong = driver.findElement(By.xpath("//span[@class='error text-danger']"));
		
		return descriptionTooLong.getText().equalsIgnoreCase(error);
	}
	
	public boolean isNameTaken(String error) {
		WebElement takenName = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return takenName.getText().equalsIgnoreCase(error);
	}

	
}
