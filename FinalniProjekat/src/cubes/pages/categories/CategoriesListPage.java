package cubes.pages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;

public class CategoriesListPage {
	private String url;
	private WebDriver driver;
	
	private WebElement addNewCategoryWebElement;
	
	public CategoriesListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewCategoryWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}

	public void clickOnAddNewCategory() {
		addNewCategoryWebElement.click();
	}
	
	public void clickonEditCategory(String categoryName) {
	WebElement editWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/a[2]"));
	MyWebDriver.scroolToWebElement(driver, editWebElement);
	editWebElement.click();
	}
	
	public void clickOnDeleteCategory(String categoryName) {
	WebElement deleteWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/button[1]"));
	MyWebDriver.scroolToWebElement(driver, deleteWebElement);
	deleteWebElement.click();
	}
	
	public void clickOnDialogDeleteButton() {
	WebElement deleteButtonWebElement = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	deleteButtonWebElement.click();
	}
	
	public void clickOnDialogCancelButton() {
	WebElement cancelButtonWebElement = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	cancelButtonWebElement.click();
	}
	
	public void clickOnDialogCloseButton() {
	WebElement closeButtonWebElement = driver.findElement(By.xpath("//button[@class='close']"));
	closeButtonWebElement.click();
	}
	
	public boolean isCategoryNameElementOnPage(String categoryName) {
		WebElement webElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));
		
		return webElement.getText().equalsIgnoreCase(categoryName);
	}
	
	public boolean isCategoryDescriptionElementOnPage(String categoryDescription, String categoryName) {
		WebElement descriptionWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[3]"));
		
		String descriptionString = descriptionWebElement.getText().replace("...", "");
		
		return categoryDescription.contains(descriptionString);
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
