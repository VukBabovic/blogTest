package cubes.pages.post;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.helper.MyWebDriver;

public class PostListPage {


	private String url;
	private WebDriver driver;
	private WebElement addNewPostWebElement;
	private WebElement nextPageWebElement;
	
	

	public PostListPage(WebDriver driver) {

		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewPostWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		this.nextPageWebElement = driver.findElement(By.xpath("//a[@class='page-link']"));
		
	}
	
	public void openPage() {	
	driver.get(url);
	}
	
	public boolean isOnPage() {
	return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnAddNewPost() {	
	addNewPostWebElement.click();
	}
	
	public void clickOnLogoutIcon() {
	WebElement logoutIconWebElement = driver.findElement(By.xpath("//i[@class='far fa-user']"));
	logoutIconWebElement.click();
	}
	
	public void clickOnLoguout() {
	WebElement logoutWebElement = driver.findElement(By.xpath("//a[@href='https://testblog.kurs-qa.cubes.edu.rs/logout']"));
	logoutWebElement.click();
	}
	
	public void clickOnEditPost(String postTitle) {
	WebElement editButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[1]/a[2]"));
	MyWebDriver.scroolToWebElement(driver, editButton);
	editButton.click();
	}
	
	public void clickOnDeletePost(String postTitle) {
	WebElement deleteButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[1]/button[1]"));
	MyWebDriver.scroolToWebElement(driver, deleteButton);
	deleteButton.click();
	}
	
	public void clickOnDeleteDialogCloseButton() {
	WebElement closeWebElement = driver.findElement(By.xpath("//button[@class='close']"));
	closeWebElement.click();
	}
	
	public void clickOnDeleteDialogCancelButton() {
	WebElement cancelWebElement = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	cancelWebElement.click();
	}
	
	public void clickOnDeleteDialogDeleteButton() {
	WebElement deleteWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
	deleteWebElement.click();
	}
	
	public void clickOnDisable(String postTitle) {
	WebElement disableButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[2]/button[1]"));
	MyWebDriver.scroolToWebElement(driver, disableButton);
	disableButton.click();
	try {Thread.sleep(2000);} 
	catch (InterruptedException e) {e.printStackTrace();}
	WebElement buttonElement = driver.findElement(By.xpath("//button[contains(.,'Disable')]"));
	buttonElement.click();
	}
	
	public void clickOnEnable(String postTitle) {
	WebElement enableButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[2]/button[1]"));
	MyWebDriver.scroolToWebElement(driver, enableButton);
	enableButton.click();
	try {Thread.sleep(2000);} 
	catch (InterruptedException e) {e.printStackTrace();}
	WebElement buttonElement = driver.findElement(By.xpath("//button[contains(.,'Enable')]"));
	buttonElement.click();
	}
	
	public void clickOnImportant(String postTitle) {
	WebElement importantButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[2]/button[2]"));
	MyWebDriver.scroolToWebElement(driver, importantButton);
	importantButton.click();
	try {Thread.sleep(2000);} 
	catch (InterruptedException e) {e.printStackTrace();}
	WebElement importantElement = driver.findElement(By.xpath("//button[contains(.,'Set as Important')]"));
	importantElement.click();
	}
	
	public void clickOnUnmportant(String postTitle) {
	WebElement unimportantButton = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[12]/div[2]/button[2]"));
	MyWebDriver.scroolToWebElement(driver, unimportantButton);
	unimportantButton.click();
	try {Thread.sleep(2000);} 
	catch (InterruptedException e) {e.printStackTrace();}
	WebElement unimportantElement = driver.findElement(By.xpath("//button[contains(.,'Set as Unmportant')]"));
	unimportantElement.click();
	}
	
	public void searchWebElement(String postTitle) {
	WebElement searchPost = driver.findElement(By.xpath("//input[@name='title']"));
	searchPost.sendKeys(postTitle);
	}
	
	public void searchByAuthor(String authorName) {
	WebElement authorWebElement = driver.findElement(By.name("user_id"));
	Select author = new Select(authorWebElement);
	author.selectByVisibleText(authorName);
	}
	
	public void searchByCategory(String categoryName) {
	WebElement categoryWebElement = driver.findElement(By.name("post_category_id"));
	Select category = new Select(categoryWebElement);
	category.selectByVisibleText(categoryName);
	}
	
	public void searchByImportance(String importance) {
	WebElement importanceWebElement = driver.findElement(By.name("important"));
	Select important = new Select(importanceWebElement);
	important.selectByVisibleText(importance);
	}
	
	public void searchByStatus(String status) {
	WebElement statusWebElement = driver.findElement(By.name("status"));
	Select stat = new Select(statusWebElement);
	stat.selectByVisibleText(status);
	}
	
	public void showEntries(String entries) {
	WebElement entriesWebElement = driver.findElement(By.name("entities-list-table_length"));
	Select entry = new Select(entriesWebElement);
	entry.selectByVisibleText(entries);
	}
	
	public boolean isPostOnPage(String postTitle) {
	WebElement postTitleWebElement = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[5]"));
	return postTitleWebElement.getText().equalsIgnoreCase(postTitle);
	}
	
	public boolean isCategoryOnPage(String postTitle, String categoryName) {
	WebElement categoryNamewWebElement = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[7]"));
	
	String categoryString = categoryNamewWebElement.getText();
	
	return categoryName.contains(categoryString);
	}
	
	public boolean isImportanceOnPage(String postTitle, String importanceType) {
	WebElement importanceWebElement = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[3]//span[@class='text-success']"));
	
	String importanceString = importanceWebElement.getText();
	
	return importanceType.contains(importanceString);
	}
	
	public boolean isTagOnPage(String postTitle, String tagName) {
	WebElement tagWebElement = driver.findElement(By.xpath("//td[text()='"+postTitle+"']//ancestor::tr/td[8]"));
	
	String tagNameString = tagWebElement.getText();
	
		return tagName.contains(tagNameString);	
	}
	
	
}
