package cubes.pages.post;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.helper.MyWebDriver;

public class PostAddPage {

	private String url;
	private WebDriver driver;
	
	private WebElement postTitleWebElement;
	private WebElement postDescriptionWebElement;
	private WebElement saveButtonWebElement;
	private WebElement cancelButtonWebElement;
	private WebElement postTagWebElement;
	private WebElement postLinkWebElement;
	private WebElement radio1WebElement;
	private WebElement postPhotoWebElement;
	private WebElement radioWebElement;
	private WebElement postTagWebElement1;
	private WebElement postTagWebElement2;
	
	
	public PostAddPage(WebDriver driver) {
		
	this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add";
	this.driver = driver;
	
	
	this.postPhotoWebElement = driver.findElement(By.xpath("//input[@name='photo']"));
	this.postDescriptionWebElement = driver.findElement(By.name("description"));
	this.postTitleWebElement = driver.findElement(By.name("title"));
	this.postLinkWebElement = driver.findElement(By.linkText("Post"));
	this.postTagWebElement = driver.findElement(By.xpath("//label[text()='eos']"));
	this.postTagWebElement1 = driver.findElement(By.xpath("//label[text()='Vuk']"));
	this.postTagWebElement2 = driver.findElement(By.xpath("//label[text()='sit']"));
	this.saveButtonWebElement = driver.findElement(By.xpath("//button[@type ='submit']"));
	this.cancelButtonWebElement = driver.findElement(By.xpath("//a[@class ='btn btn-outline-secondary']"));
	}
	
	public void openPage() {
	this.driver.get(url);
	}
	
	public boolean isOnPage() {
	return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnSave() {
	WebElement element = driver.findElement(By.xpath("//button[@type ='submit']"));
	MyWebDriver.scroolToWebElement(driver, element);
	saveButtonWebElement.click();
	}
	
	public void clickOnCancel() {
	WebElement element = driver.findElement(By.xpath("//a[@class ='btn btn-outline-secondary']"));
	MyWebDriver.scroolToWebElement(driver, element);
	cancelButtonWebElement.click();
	}
	
	public void clickOnPostLink() {
	WebElement element = driver.findElement(By.linkText("Post"));
	MyWebDriver.scroolToWebElement(driver, element);
	postLinkWebElement.click();
	}
	
	public void selectCategory(String categoryName) {
	WebElement categoryWebElement = driver.findElement(By.name("post_category_id"));
	Select category = new Select(categoryWebElement);
	category.selectByVisibleText(categoryName);
	}
	
	public void clickOnTag() {
	postTagWebElement1.click();
	}
	
	public void clickOnTags() {
	postTagWebElement.click();
	postTagWebElement1.click();
	}
	
	public void clickOnTagGroup() {
	postTagWebElement.click();
	postTagWebElement1.click();
	postTagWebElement2.click();
	}
	
	public void clickOnImportant() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement radio1WebElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='set-as-important']")));
	radio1WebElement.click();
	
	}
	
	public void clickOnUnimportant() {
	radioWebElement.click();	
	}
	
	public void insertTitle(String title) {
	postTitleWebElement.clear();
	postTitleWebElement.sendKeys(title);
	}
	
	public String getTitle() {
	return postTitleWebElement.getAttribute("value");
	}
	
	public void insertDescription(String description) {
	postDescriptionWebElement.clear();	
	postDescriptionWebElement.sendKeys(description);
	}
	
	public void uploadJPGSPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizS.jpg");
		}
		public void uploadJPGMPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizM.jpg");
		}
		public void uploadJPGLPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizL.jpg");
		}
		public void uploadJPGVPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGVert.jpeg");
		}
		public void uploadPNGSPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizS.png");
		}
		public void uploadPNGMPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizM.png");
		}
		public void uploadPNGLPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizL.png");
		}
		public void uploadPNGVPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGVert.png");	
		}
		public void uploadTIFSPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFS.tif");
		}
		public void uploadTIFMPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFM.tif");
		}
		public void uploadTIFLPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFL.tiff");
		}
		public void uploadAVIFPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\AVIF.avif");
		}
		public void uploadGIFSPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\GIFBig.gif");
		}
		public void uploadGIFLPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\GIFSmall.gif");
		}
		public void uploadVideo() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\Video.mp4");
		} 
		public void uploadWebPSPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPS.webp");
		}
		public void uploadWebPMPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPM.webp");
		}
		public void uploadWebPLPhoto() {
		postPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPL.webp");
		}
		
	public void insertContent(String content) {
	driver.switchTo().frame(0);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.tagName("p")));
	try {
		Thread.sleep(1500);
	} catch (Exception e) {
		// TODO: handle exception
	}
	driver.findElement(By.tagName("p")).clear();
	driver.findElement(By.tagName("p")).sendKeys(content);
	driver.switchTo().defaultContent();
	}
	
	public boolean isTitleInserted(String error) {
	WebElement errorWebElement = driver.findElement(By.id("title-error"));
	return errorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isDescriptionInserted(String error) {
	WebElement descWebElement = driver.findElement(By.id("description-error"));
	return descWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isTagChosen(String error) {
	WebElement tagErrorWebElement = driver.findElement(By.id("tag_id[]-error"));
	return tagErrorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isPhotoValid(String error) {
	WebElement invalidPhotoWebElement = driver.findElement(By.xpath("//div[contains(text(),'The photo must be an image.')]"));
	return invalidPhotoWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isConentInserted(String error) {
	WebElement contentErrorWebElement = driver.findElement(By.xpath("//div[contains(text(),'The content field is required.')]"));
	return contentErrorWebElement.getText().equalsIgnoreCase(error);
	}
	

}
