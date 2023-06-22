package cubes.test.post;

import static org.junit.Assert.*;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.post.PostAddPage;
import cubes.pages.post.PostEditPage;
import cubes.pages.post.PostListPage;

public class EditPostTest {
	
	private static WebDriver driver;
	private String postTitle = "Title 01, Title 01, Title 01";
	private String newPostTitle = "Testing001Testing0001";
	private String editTitle1 = "Test02Test002Test0002";
	
	private String longTitle = RandomStringUtils.randomAlphanumeric(256);
	private String longDescription = RandomStringUtils.randomAlphanumeric(501);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getDriver("chrome");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
//MORAO SAM DA KORISTIM TRY_CATCH U SVIM TESTOVIMA JER SAM DOBIJAO 'STALE ELEMENT REFERENCE' BEZ TOGA. 
//POKUSAO SAM I WAIT('element to be visible', pre toga sam probao 'element to be clickable' ali nije radilo). 
//ALI NISTA NE RADI JER ELEMENT NIJE DEO DOM U TOM TRENUTKU.(stackowerflow: element is removed from the dom structure). Sabio sam try/catch u dva reda da bi zauzimalo manje mesta u kodu
//go to edit post page, don't make any changes, click Cancel
	@Test
	public void tc01() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));	
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
//go to edit post page, don't make any changes, click Save
	@Test
	public void tc02() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));	
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
//edit post, change image, clear other fields, click Save
	@Test
	public void tc03() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle("");
	postEditPage.editDescription("");
	postEditPage.unclickTag();
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, change image, clear other fields, click Cancel
	@Test
	public void tc04() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle("");
	postEditPage.editDescription("");
	postEditPage.unclickTag();
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, change image, clear other fields, click Post
	@Test
	public void tc05() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle("");
	postEditPage.editDescription("");
	postEditPage.unclickTag();
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, title too short, change image, clear other fields, Save
	@Test
	public void tc06() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle("Test01Test02");
	postEditPage.editDescription("");
	postEditPage.unclickTag();
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}	
	
//edit post, insert title too short, change image, clear other fields, Cancel
	@Test
	public void tc07() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle("Test01Test02");
	postEditPage.editDescription("");
	postEditPage.unclickTag();
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, change image, description too short, no tag & content, Save
	@Test
	public void tc08() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("");
	postEditPage.editDescription("Test01Test02");
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, change image, description too short, no tag & content, Cancel
	@Test
	public void tc09() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("");
	postEditPage.editDescription("Test01Test02");
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload image, title & description too short, no tag & content, Save
	@Test
	public void tc10() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("Testing01");
	postEditPage.editDescription("Test01Test02");
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, upload image, title & description too short, no tag & content, Cancel
	@Test
	public void tc11() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("Testing01");
	postEditPage.editDescription("Test01Test02");
	postEditPage.uploadJPGSPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload image, title too long, description too short, no tag, no picture, no content, Save
	@Test
	public void tc12() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription("Test01Test02");
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, title too long, description too short, no tag, no picture, no content, Cancel
	@Test
	public void tc13() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription("Test01Test02");
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, title too short, description too long, no tag, no picture, no content, Save
	@Test
	public void tc14() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("Testing01");
	postEditPage.editDescription(longDescription);
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, title too short, description too long, no tag, no picture, no content, Cancel
	@Test
	public void tc15() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle("Testing01");
	postEditPage.editDescription(longDescription);
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, title & description too long, no tag, no picture, no content, Save
	@Test
	public void tc16() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription(longDescription);
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, title & description too long, no tag, no picture, no content, Cancel
	@Test
	public void tc17() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription(longDescription);
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload video, title required length, description too long, no tag & content, Save
	@Test
	public void tc18() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription(longDescription);
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Description error not displayed!", postEditPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postEditPage.isTagChosen("This field is required."));
	assertTrue("Photo error not displayed!", postEditPage.isPhotoValid("The photo must be an image."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
	//edit post, upload video, title required length, description too long, no tag & content, Cancel
	@Test
	public void tc19() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickTag();
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription(longDescription);
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload video, title too long, description required length, leave tag, Save
	@Test
	public void tc20() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Title error not displayed!", postEditPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Photo error not displayed!", postEditPage.isPhotoValid("The photo must be an image."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, upload video, title too long, description required length, leave tag, Cancel
	@Test
	public void tc21() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(longTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload video, title & description required length, leave tag, Save
	@Test
	public void tc22() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Photo error not displayed!", postEditPage.isPhotoValid("The photo must be an image."));
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, upload video, title & description required length, leave tag, Cancel
	@Test
	public void tc23() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadVideo();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload picture, title & description required length, leave tag, empty Content, Save
	@Test
	public void tc24() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadJPGMPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnSave();
	assertTrue("Content error not displayed", postEditPage.isConentInserted("The content field is required."));
	}
	
//edit post, upload picture, title & description required length, leave tag, empty Content, Cancel
	@Test
	public void tc25() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadJPGMPhoto();
	postEditPage.insertContent("");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload picture, title & description required length, leave tag, add Content, Cancel
	@Test
	public void tc26() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadJPGMPhoto();
	postEditPage.insertContent("PostEditTest");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, upload picture, title & description required length, leave tag, add Content, Save
	@Test
	public void tc27() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(newPostTitle);
	postEditPage.editDescription("Test Test Test Test Test Test Test Test Test Test Test");
	postEditPage.uploadJPGMPhoto();
	postEditPage.insertContent("PostEditTest");
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(newPostTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(newPostTitle, "Vuk"));
	}
	
//edit post with existing title, don't edit other fields, click Cancel
	@Test
	public void tc28() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(newPostTitle);
	try {postListPage.clickOnEditPost(newPostTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(newPostTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(editTitle1);
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(newPostTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(newPostTitle, "Vuk"));
	}
	
//edit post with existing title, don't edit other fields, click Save
	@Test
	public void tc29() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(newPostTitle);
	try {postListPage.clickOnEditPost(newPostTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(newPostTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(editTitle1);
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(editTitle1, "Vuk"));
	}
	
//edit post, upload small TIF image, don't edit other fields, click Cancel
	@Test
	public void tc30() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFSPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(editTitle1));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(editTitle1, "Vuk"));
	}
	
//edit post, upload small TIF image, don't edit other fields, click Save
	@Test
	public void tc31() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFSPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post edit error!", postListPage.isPostOnPage(postTitle));
	assertTrue("Tag edit error!", postListPage.isTagOnPage(postTitle, "Vuk"));
	}
	
//edit post, upload medium TIF image, don't edit other fields, click Cancel
	@Test
	public void tc32() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFMPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, upload medium TIF image, don't edit other fields, click Save
	@Test
	public void tc33() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFMPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, upload large TIF image, don't edit other fields, Cancel
	@Test
	public void tc34() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFLPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, upload large TIF image, don't edit other fields, Save
	@Test
	public void tc35() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadTIFLPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, upload AVIF image, don't edit other fields, Cancel
	@Test
	public void tc36() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadAVIFPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, upload AVIF image, don't edit other fields, Save
	@Test
	public void tc37() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadAVIFPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, select category, change tag, don't edit other fields, Cancel
	@Test
	public void tc38() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.selectCategory("VukTestCat");
	postEditPage.changeTag();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, select category, change tag, don't edit other fields, Save
	@Test
	public void tc39() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.selectCategory("VukTestCat");
	postEditPage.changeTag();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, change category, change to previous title, change edited description, Cancel
	@Test
	public void tc40() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(postTitle);
	postEditPage.editDescription("Final description change 4 Final Project. Edit Description done!");
	postEditPage.selectCategory("Clarkstad");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}
	
//edit post, change category, change to previous title, change edited description, click Post
	@Test
	public void tc41() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(postTitle);
	postEditPage.editDescription("Final description change 4 Final Project. Edit Description done!");
	postEditPage.selectCategory("Clarkstad");
	postEditPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(editTitle1));
	}	
	
//edit post, change category, change to previous title, change edited description, click Save
	@Test
	public void tc42() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(editTitle1);
	try {postListPage.clickOnEditPost(editTitle1);} 
	catch (Exception e) {postListPage.clickOnEditPost(editTitle1);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.editTitle(postTitle);
	postEditPage.editDescription("Final description change 4 Final Project. Edit Description done!");
	postEditPage.selectCategory("Clarkstad");
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}	
	
//edit post, change importance, insert small WebP image don't edit other fields, Cancel
	@Test
	public void tc43() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	try {
		Thread.sleep(2500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	postEditPage.clickOnImportant();
	postEditPage.uploadWebPSPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}	
	
//edit post, change importance, insert small WebP image don't edit other fields, Save
	@Test
	public void tc44() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	try {
		Thread.sleep(2500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	postEditPage.clickOnImportant();
	postEditPage.uploadWebPSPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}	
	
//edit post, edit edited content, insert medium WebP image, Cancel
	@Test
	public void tc45() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadWebPMPhoto();
	postEditPage.insertContent("Final Project Final Edit Test 4 Content");
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}	
	
//edit post, edit edited content, insert medium WebP image, Save
	@Test
	public void tc46() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadWebPMPhoto();
	postEditPage.insertContent("Final Project Final Edit Test 4 Content");
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, insert Vertical JPG image, don't edit other fields, click Cancel
	@Test
	public void tc47() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadJPGVPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, insert Vertical JPG image, don't edit other fields, click Save
	@Test
	public void tc48() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadJPGVPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, insert Vertical PNG image, don't edit other fields, click Cancel
	@Test
	public void tc49() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadPNGVPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, insert Vertical PNG image, don't edit other fields, click Save
	@Test
	public void tc50() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadPNGVPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, change picture, don't edit other fields, click Cancel
	@Test
	public void tc51() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadPNGMPhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, change picture, don't edit other fields, click Save
	@Test
	public void tc52() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.uploadPNGMPhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, select two tags, don't edit other fields, Cancel
	@Test
	public void tc53() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickChangedTag();
	postEditPage.clickOnTags();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, select two tags, don't edit other fields, Save
	@Test
	public void tc54() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.unclickChangedTag();
	postEditPage.clickOnTags();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
//edit post, select third tag, don't edit other fields, Cancel
	@Test
	public void tc55() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.clickOnThirdTag();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
		
//edit post, select third tag, don't edit other fields, Save
	@Test
	public void tc56() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.clickOnThirdTag();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
	
//edit post, click 'Delete Photo', Cancel
	@Test
	public void tc57() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.clickOnDeletePhoto();
	postEditPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
//edit post, click 'Delete Photo', Save
	@Test
	public void tc58() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {postListPage.clickOnEditPost(postTitle);} 
	catch (Exception e) {postListPage.clickOnEditPost(postTitle);}
	PostEditPage postEditPage = new PostEditPage(driver);
	assertTrue("Edit page doesn't open!", postEditPage.isOnEditPage("Edit Post"));
	postEditPage.clickOnDeletePhoto();
	postEditPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("Post isn't edited!", postListPage.isPostOnPage(postTitle));
	}
}
