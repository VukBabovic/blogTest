package cubes.pages.post;
//STO SE TICE EDIT STRANE, HOCU DA ZNAS DA SAM RAZMATRAO I DA NAPRAVIM JEDNU STRANU SA NASLEDJIVANJEM ZA ADD I POST ALI MISLIM DA JE NAMA KAO POCETNICIMA IPAK NAJBITNIJE DA VEZBAMO KUCANJE
//TOKOM RADA SAM VIDEO DA SE XPATH I DRUGI LOKATORI NAJBOLJE UCE KAD SE PISU I ZATO SAM PRAVIO DVE STRANE
//TAKODJE SAM POKUSAO DA U RADU VEZBAM I PISANJE LOKATORA I U RADU SAM MISLIM ISKORISTIO SVIH 8 TIPOVA
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cubes.helper.MyWebDriver;

public class PostEditPage {

	private WebDriver driver;
	
	private WebElement editTitleWebElement;
	private WebElement editDescriptionWebElement;
	private WebElement editRadioWebElement;
	private WebElement editTag1WebElement;
	private WebElement editPhotoWebElement;
	private WebElement saveButtonWebElement;
	private WebElement cancelButtonWebElement;
	private WebElement deletePhotoWebElement;
	private WebElement editTag2WebElement;
	private WebElement postLinkWebElement;
	private WebElement editRadio1WebElement;
	private WebElement editTag3WebElement;

	public PostEditPage(WebDriver driver) {
		
	this.driver = driver;
	
	this.cancelButtonWebElement = driver.findElement(By.cssSelector(".btn.btn-outline-secondary"));
	this.deletePhotoWebElement = driver.findElement(By.xpath("//button[@type='button']"));
	this.editDescriptionWebElement = driver.findElement(By.name("description"));
	this.editTitleWebElement = driver.findElement(By.name("title"));
	this.editRadioWebElement = driver.findElement(By.name("important"));
	this.editRadio1WebElement = driver.findElement(By.xpath("//label[@for='set-as-unimportant']"));
	this.editTag1WebElement = driver.findElement(By.xpath("//label[text()='Vuk']"));
	this.editTag2WebElement = driver.findElement(By.xpath("//label[text()='eos']"));
	this.editTag3WebElement = driver.findElement(By.xpath("//label[text()='sit']"));
	this.editPhotoWebElement = driver.findElement(By.xpath("//input[@name='photo']"));
	this.postLinkWebElement = driver.findElement(By.linkText("Post"));
	this.saveButtonWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	public boolean isOnEditPage(String editPost) {
		WebElement editPostWebElement = driver.findElement(By.xpath("//h1[contains(text(),'Edit Post')]"));
		return editPostWebElement.getText().equalsIgnoreCase(editPost);
	}
	
	public void clickOnSave() {
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		MyWebDriver.scroolToWebElement(driver, element);
		saveButtonWebElement.click();
	}
	
	public void clickOnCancel() {
		WebElement element = driver.findElement(By.cssSelector(".btn.btn-outline-secondary"));;
		MyWebDriver.scroolToWebElement(driver, element);
		cancelButtonWebElement.click();
	}
	
	public void clickOnPostLink() {
		postLinkWebElement.click();
	}
	
	public void selectCategory(String categoryName) {
		WebElement categoryWebElement = driver.findElement(By.name("post_category_id"));
		Select category = new Select(categoryWebElement);
		category.selectByVisibleText(categoryName);	
	}
	
	public void clickOnTag() {
		editTag1WebElement.click();
	}
	
	public void unclickTag() {
		editTag1WebElement.click();
	}
	
	public void clickOnTags() {
		editTag1WebElement.click();
		editTag2WebElement.click();
	}
	
	public void clickOnThirdTag() {
		editTag3WebElement.click();
	}
	
	public void clearTags() {
		editTag1WebElement.click();
		editTag2WebElement.click();
		editTag3WebElement.click();
	}
	
	public void changeTag() {
		editTag1WebElement.click();
		editTag2WebElement.click();
	}
	
	public void unclickChangedTag() {
		editTag2WebElement.click();
	}
	
	public void clickOnImportant() {
		editRadioWebElement.click();
	}
	
	public void clickOnUnimportant() {
		editRadio1WebElement.click();
	}
	
	public void editTitle(String title) {
		editTitleWebElement.clear();
		editTitleWebElement.sendKeys(title);
	}
	
	public String getTitle() {
	return editTitleWebElement.getAttribute("value");
	}
	
	public void editDescription(String description) {
		editDescriptionWebElement.clear();
		editDescriptionWebElement.sendKeys(description);
	}
	
	public void clickOnDeletePhoto() {
		deletePhotoWebElement.click();
	}
	
	public void uploadJPGSPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizS.jpg");
	}
	public void uploadJPGMPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizM.jpg");
	}
	public void uploadJPGLPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGHorizL.jpg");
	}
	public void uploadJPGVPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\JPGVert.jpeg");
	}
	public void uploadPNGSPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizS.png");
	}
	public void uploadPNGMPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizM.png");
	}
	public void uploadPNGLPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGHorizL.png");
	}
	public void uploadPNGVPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\PNGVert.png");	
	}
	public void uploadTIFSPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFS.tif");
	}
	public void uploadTIFMPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFM.tif");
	}
	public void uploadTIFLPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\TIFL.tiff");
	}
	public void uploadAVIFPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\AVIF.avif");
	}
	public void uploadGIFSPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\GIFBig.gif");
	}
	public void uploadGIFLPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\GIFSmall.gif");
	}
	public void uploadVideo() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\Video.mp4");
	} 
	public void uploadWebPSPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPS.webp");
	}
	public void uploadWebPMPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPM.webp");
	}
	public void uploadWebPLPhoto() {
	editPhotoWebElement.sendKeys("C:\\Users\\vukba\\OneDrive\\Radna površina\\workspace\\FinalProject\\FinalProject\\FPSlike\\WebPL.webp");
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
		WebElement photoErrorWebElement = driver.findElement(By.xpath("//div[contains(text(),'The photo must be an image.')]"));
		return photoErrorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isConentInserted(String error) {
		WebElement contentErrorWebElement = driver.findElement(By.xpath("//div[contains(text(),'The content field is required.')]"));
		return contentErrorWebElement.getText().equalsIgnoreCase(error);
	}
	
	
	
}