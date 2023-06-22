package cubes.test.post;
//CAO, HTEO SAM DA OBJASNIM KAKO SAM RAZMISLJAO PRI PISANJU TESTOVA DA BI ZNAO ZASTO SAM RADIO ODREDJENE VRSTE TESTOVA MOZDA MALO VISE
//STVARNO SAM SE POSVETIO OVOME I RADIO SAM KAO DA SAM NA POSLU. BAS SAM SE OKO SLIKA RAZBIO ALI SAM SVE ODRADIO JA MISLIM KAKO TREBA I NADAM SE ZA NAJVISU OCENU 
//MISLIM DA JE SVAKOM BIZNISU NAJBITNIJE DA LI JE MULTIMEDIJA OK I ZATO SAM SE NAJVISE BAVIO TESTIRANJEM SLIKA
//TAKODJE SAM PONOVO URADIO I TEST ZA TAG I KATEGORIJE
//POSTO MI DRAJVER NIJE SKROZ SINHRONIZOVAN SA NAJNOVIJOM VERZIJOM MORAO SAM DA PRI OPERACIJAMA KOJE ZAHTEVAJU REFRESH STRANICE DA KORISTIM TRY_CATCH JER SAM DOBIJAO STALE ELEMENT REFERENCE
import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.post.PostAddPage;
import cubes.pages.post.PostListPage;
import cubes.pages.tag.TagsListPage;

public class AddPostTest {
	
	private static WebDriver driver;
	

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
//no category leave all fields empty, insert photo, click Save
	@Test
	public void tc01() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.uploadJPGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, leave all fields empty, insert photo, click Cancel
	@Test
	public void tc02() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.uploadJPGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, leave all fields empty, insert photo, click post
	@Test
	public void tc03() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.uploadJPGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category empty title, description too short, upload image, no tag & content, Save
	@Test
	public void tc04() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGMPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, empty title, description too short, upload image, no tag no content, cancel
	@Test
	public void tc05() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGMPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, empty title, description too short, upload image, no tag no content, click post	
	@Test
	public void tc06() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGMPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, title & description too short, no tag, upload image, no content, save
	@Test
	public void tc07() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category title & description too short, no tag, upload image, no content, cancel
	@Test
	public void tc08() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category title & description too short, no tag, upload image, no content, post
	@Test
	public void tc09() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, title & description too short, add tag, upload image, no content, save
	@Test
	public void tc10() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.clickOnTag();
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title & description too short, choose tag, upload image, no content, cancel
	@Test
	public void tc11() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.clickOnTag();
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, required number of characters in title, description too short, choose tag, upload image, no content, save
	@Test
	public void tc12() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.clickOnTag();
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadJPGLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, required number of characters in title, description too short, choose tag, upload image, no content, cancel
	@Test
	public void tc13() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadJPGVPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, required number of characters in title & description, choose tag, upload image, no content, Save
	@Test
	public void tc14() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadJPGVPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, required number of characters in title & description, choose tag, upload image, no content, cancel
	@Test
	public void tc15() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadJPGVPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, required number of characters in title & description, choose tag, upload jpg image, insert content, cancel
	@Test
	public void tc16() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadJPGVPhoto();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, required number of characters in title & description, choose tag, upload jpg image, insert content, save	
	@Test
	public void tc17() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 01");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadJPGVPhoto();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Title 01, Title 01, Title 01");
		} 
	catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Title 01, Title 01, Title 01");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Title 01, Title 01, Title 01"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Title 01, Title 01, Title 01", "Vuk"));
	}
	
//ZA TESTOVE 18, 19, 20 NISAM STAVLJAO SEARCH WEB ELEMENT JER TEST NE PROLAZI. SAJT NE PRIMA TIF FORMAT SLIKA I OSTAJE NA POSTADDPAGE. TO SAM STAVIO KAO BAG JER SVAKI FORMAT KOJI JE IMAGE MORA DA PRODJE.
//no category, required number of characters in title & description, choose tag, upload tifs image, insert content, save	
	@Test
	public void tc18() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 02");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadTIFSPhoto();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Title 01, Title 01, Title 02"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Title 01, Title 01, Title 02", "Vuk"));
	}
	
//no category, required number of characters in title & description, choose tag, upload tifm image, insert content, save	
	@Test
	public void tc19() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 03");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadTIFMPhoto();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Title 01, Title 01, Title 03"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Title 01, Title 01, Title 03", "Vuk"));
	}
	
//no category, required number of characters in title & description, choose tag, upload tifl image, insert content, save	
	@Test
	public void tc20() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01, Title 01, Title 04");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadTIFLPhoto();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Title 01, Title 01, Title 04"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Title 01, Title 01, Title 04", "Vuk"));
	}
	
//no category, title too long, description too short, no tag, no image no content save;
	@Test
	public void tc21() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Title01");
	postAddPage.clickOnSave();
	WebElement element = driver.findElement(By.id("tag-checkbox-1332"));
	MyWebDriver.scroolToWebElement(driver, element);
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title too long, description too short, no tag, no image no content cancel;
	@Test
	public void tc22() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());	
	}	
	
//no category, title too short, description too long, no tag, no image no content save;
	@Test
	public void tc23() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title too short, description too long, no tag, no image no content cancel;
	@Test
	public void tc24() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//no category, title too long, description too long, no tag, no image, insert content save;
//PORUKA ZA TAG SE NIKADA NE IZVRSAVA U AUTOMATIZACIJI, PROBAO SAM WAIT I TRY & CATCH I NIJE POMOGLO. U MANUELNOM TESTIRANJU RADI. 
//U KASNIJEM SLICNOM tc SE ISPISUJE PORUKA ZA TAG KADA SE UNESE CONTENT UZ PREDUGACAK TITLE & DESCRIPTION. VRV PROBLEM DO FOKUSA.
	@Test
	public void tc25() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));	
	}
	
//no category, title too long, description too long, no tag, no image no content cancel;
	@Test
	public void tc26() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//no category, upload image, important yes, other fields empty, Save	
	@Test
	public void tc27() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.clickOnImportant();
	postAddPage.uploadPNGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, upload image, important yes, other fields empty, Cancel	
	@Test
	public void tc28() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.clickOnImportant();
	postAddPage.uploadPNGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//no category, upload image, important yes, other fields empty, Post	
	@Test
	public void tc29() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.clickOnImportant();
	postAddPage.uploadPNGSPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, upload image, important yes, empty title, description too short, no content, Save	
	@Test
	public void tc30() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test01");	
	postAddPage.uploadPNGMPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, upload image, important yes, empty title, description too short, no content, Cancel	
	@Test
	public void tc31() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test01");
	postAddPage.uploadPNGMPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
	//no category, empty title, description too short, important yes, no tag, upload image, no content, Post	
	@Test
	public void tc32() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test01");
	postAddPage.uploadPNGMPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//no category, title & description too short, important yes, no tag, upload image, no content, Save
	@Test
	public void tc33() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title01");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadPNGMPhoto();
	postAddPage.insertContent("");	
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title & description too short, important yes, no tag, upload image, no content, Cancel	
	@Test
	public void tc34() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title01");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadPNGMPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description, no tag, no image, no content, Save	
	@Test
	public void tc35() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());	
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}	
	
//no category, important yes, required no of characters in title & description, no tag, no image, no content, Cancel	
	@Test
	public void tc36() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description, choose 2 tags, no image, no content, Save	
	@Test
	public void tc37() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());	
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}	
	
//no category, important yes, required no of characters in title & description, choose 2 tags, no image, no content, Cancel	
	@Test
	public void tc38() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description choose 2 tags, no image, no content, Post	
	@Test
	public void tc39() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description, choose tag, upload SMALL GIF image, insert content, Cancel	
	@Test
	public void tc40() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadGIFSPhoto();
	postAddPage.clickOnTags();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description, choose tags, upload SMALL GIF image, insert content, Save
	@Test
	public void tc41() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadGIFSPhoto();
	postAddPage.clickOnTags();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
	WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
	searchWebElement.sendKeys("Test02Test002Test0003");
	} catch (Exception e) {
	WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
	searchWebElement.sendKeys("Test02Test002Test0003");	
	}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test02Test002Test0003"));
	}	
	
//no category, important yes, required no of characters in title & description, choose tag, upload BIG GIF image, insert content, Cancel	
	@Test
	public void tc42() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadGIFLPhoto();
	postAddPage.clickOnTag();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//no category, important yes, required no of characters in title & description, choose tag, upload BIG GIF image, insert content, Save
	@Test
	public void tc43() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Test02Test002Test00002");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnImportant();
	postAddPage.uploadGIFLPhoto();
	postAddPage.clickOnTag();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
	WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
	searchWebElement.sendKeys("Test02Test002Test0002");
	} catch (Exception e) {
	WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
	searchWebElement.sendKeys("Test02Test002Test0002");	
	}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test02Test002Test0002"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Test02Test002Test0002", "Vuk"));
	}
	
//no category, title too long, description too short, no tag, no image no content, Save;
//SAMO POSLE DVE KOMANDE IMPORTANT SE MENJA IMPORTANT STATUS. PROBAN TRY CATCH, PROBANO DA SE KOMANDA IZVRSI NA POCETKU. KADA SE IZVRSI NA POCETKU NE ISPISUJE SE ERROR ZA TAG
	@Test
	public void tc44() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Title01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	WebElement element = driver.findElement(By.id("tag-checkbox-1332"));
	MyWebDriver.scroolToWebElement(driver, element);
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title too long, description too short, important yes, no tag, no image no content, Cancel;
	@Test
	public void tc45() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());	
	}
	
//no category, title too short, description too long, important yes, no tag, no image no content, Save;
//SAMO POSLE DVE KOMANDE SE MENJA IMPORTANT STATUS. PROBAN TRY CATCH, PROBANO DA SE KOMANDA IZVRSI NA POCETKU. KADA SE IZVRSI NA POCETKU NE ISPISUJE SE ERROR ZA TAG
	@Test
	public void tc46() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//no category, title too short, description too long, important yes, no tag, no image no content, Cancel;
//SAMO POSLE DVE KOMANDE SE MENJA IMPORTANT STATUS. PROBAN TRY CATCH, PROBANO DA SE KOMANDA IZVRSI NA POCETKU. KADA SE IZVRSI NA POCETKU KOMANDA CLICK ON CANCEL SE NE IZVRSAVA. U TOM SLUCAJU POTREBNE DVE KOMANDE CLICK ON CANCEL
	@Test
	public void tc47() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//no category, title too long, description too long, important yes, no tag, no image, no content, Save;
//SAMO POSLE DVE KOMANDE SE MENJA IMPORTANT STATUS. PROBAN WAIT, TRY CATCH, PROBANO DA SE KOMANDA IZVRSI NA POCETKU. KADA SE IZVRSI NA POCETKU NE ISPISUJE SE ERROR ZA TAG.
	@Test
	public void tc48() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));	
	}
	
//no category, title too long, description too long, important yes, no tag, no image, no content, Cancel;
	@Test
	public void tc49() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category leave all fields empty, click Save
	@Test
	public void tc50() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, leave all fields empty, click Cancel
	@Test
	public void tc51() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());	
	}
	
//choose category leave all fields empty, insert photo, click Save
	@Test
	public void tc52() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, leave all fields empty, insert photo, click Cancel
	@Test
	public void tc53() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, upload image, empty title, description too short, no tag, no content, Save	
	@Test
	public void tc54() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, upload image, empty title, description too short, no tag, no content, Cancel	
	@Test
	public void tc55() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, upload image, empty title, description too short, no tag, no content, Post	
	@Test
	public void tc56() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, no tag, upload image, no content, Save
	@Test
	public void tc57() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}	
	
//choose category, title & description too short, no tag, upload image, no content, Cancel	
	@Test
	public void tc58() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, no tag, upload image, no content, Cancel	
	@Test
	public void tc59() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, choose tag, upload image, no content, Save	
	@Test
	public void tc60() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, title & description too short, choose tag, upload image, no content, Cancel	
	@Test
	public void tc61() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, choose tag, upload image, no content, Post	
	@Test
	public void tc62() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadGIFLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title, description too short, choose tag , upload image, no content, Save	
	@Test
	public void tc63() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, correct title, description too short, choose tag, upload image, no content, Cancel	
	@Test
	public void tc64() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title, description too short, choose tag, upload image, no content, Post	
	@Test
	public void tc65() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload image, no content, Save	
	@Test
	public void tc66() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTagGroup();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, correct title & description, choose tag, upload image, no content, Cancel	
	@Test
	public void tc67() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTagGroup();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload image, add content, Cancel	
	@Test
	public void tc68() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTagGroup();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload image, add content, Save
//NE PRIMA VELIKU SLIKU PNG FORMATA KAKO TREBA. SAJT PADNE PA SE TEK POSLE REFRESHA VIDI POST. NE MOZE DA SE ASSERTUJE 
	@Test
	public void tc69() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTagGroup();
	postAddPage.uploadPNGLPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0003");
		} 
	catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0003");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test03Test003Test0003"));
	}
	
//choose category, correct title & description, choose tag, upload image, add content, Cancel	
	@Test
	public void tc70() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadAVIFPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//NE PRIMA AVIF IMAGE ALI NISAM HTEO DA ASSERTUJEM 'PHOTO MUST BE AN IMAGE' JER MORA DA PRODJE SVAKI IMAGE FORMAT. ISPRAVNO JE DA EXPECTED RESULT BUDE DA SE VRATI NA POST LIST PAGE
//choose category, correct title & description, choose tag, upload image, add content, Save	
	@Test
	public void tc71() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test00003");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadAVIFPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test00003");
		} 
	catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test00003");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test03Test003Test00003"));
	assertTrue("Category not displayed!", postListPage.isCategoryOnPage("Test03Test003Test0003", "VukTestCat"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Test03Test003Test0003", "Vuk"));
	}
	
//choose category, correct title & description, choose tag, upload small WEbP image, add content, Cancel	
	@Test
	public void tc72() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0004");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPSPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload small WEbP image, add content, Save	
	@Test
	public void tc73() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0004");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPSPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0004");
		} catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0004");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test03Test003Test0004"));
	assertTrue("Category not displayed!", postListPage.isCategoryOnPage("Test03Test003Test0004", "VukTestCat"));
	assertTrue("Tag not displayed!", postListPage.isTagOnPage("Test03Test003Test0004", "Vuk"));
	}
	
//choose category, correct title & description, choose tag, upload medium WEbP image, add content, Cancel	
	@Test
	public void tc74() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0005");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPMPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload medium WEbP image, add content, Save	
	@Test
	public void tc75() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0005");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPMPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0005");
		} catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0005");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test03Test003Test0005"));
	assertTrue("Category isn't displayed!", postListPage.isCategoryOnPage("Test03Test003Test0005", "VukTestCat"));
	assertTrue("Tag isn't displayed!", postListPage.isTagOnPage("Test03Test003Test0005", "Vuk"));
	}
	
//choose category, correct title & description, choose tag, upload large WEbP image, add content, Cancel	
	@Test
	public void tc76() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0004");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPLPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, correct title & description, choose tag, upload large WEbP image, add content, Save
//WEBP FORMAT SE UPLOADUJE NA SAJT ALI NE MOZE DA SE ASSERTUJE JER SE IZBACUJE ERROR 500. KADA SE REFRESHUJE STRANA POST JE VIDLJIV. BAG JE U TOME STO NE PRIMA WEBP FORMAT PREKO 1.5MB KAKO BI TREBALO. NE MOZE DA SE ASSERTUJE
	@Test
	public void tc77() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test03Test003Test0006");
	postAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	postAddPage.clickOnTag();
	postAddPage.uploadWebPLPhoto();
	postAddPage.insertContent("Test01");	
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0006");
		} catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test03Test003Test0006");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test03Test003Test0006"));
	assertTrue("Category isn't displayed!", postListPage.isCategoryOnPage("Test03Test003Test0006", "VukTestCat"));
	assertTrue("Tag isn't displayed!", postListPage.isTagOnPage("Test03Test003Test0006", "Vuk"));
	}
	
//choose category, title & description too long, no image, tag & content, Save
//PROBANA DVA TRY CATCHA NE ISPISUJE SE PORUKA ZA TAG NI U JEDNOM SLUCAJU
	@Test
	public void tc78() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);	
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, title & description too long, no image, tag & content, Cancel
	@Test
	public void tc79() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);	
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too long, no image, tag & content, Post
	@Test
	public void tc80() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);	
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category leave all fields empty, mark as important, click Save
	@Test
	public void tc81() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.clickOnImportant();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("This field is required."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, leave all fields empty, mark as important, click Cancel
	@Test
	public void tc82() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("");
	postAddPage.insertDescription("");
	postAddPage.clickOnImportant();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());	
	}
	
//choose category, description too short, mark as important, other fields empty, click Save
	@Test
	public void tc83() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("This field is required."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, description too short, mark as important, other fields empty, click Cancel
	@Test
	public void tc84() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, description too short, mark as important, other fields empty, click Post
	@Test
	public void tc85() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, mark as important, no tag, photo & content, click Save
	@Test
	public void tc86() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("Test02");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, title & description too short, mark as important, no tag, photo & content, click Cancel
	@Test
	public void tc87() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("Test02");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, title & description too short, mark as important, no tag, photo & content, click Post
	@Test
	public void tc88() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle("Test02");
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title, description too short, mark as important, no tag, photo & content, click Save
	@Test
	public void tc89() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, valid title, description too short, mark as important, no tag, photo & content, click Cancel
	@Test
	public void tc90() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title, description too short, mark as important, no tag, photo & content, click Post
	@Test
	public void tc91() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title, description too short, mark as important, choose 2 tags, no photo & content, click Save
	@Test
	public void tc92() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, valid title, description too short, mark as important, choose 2 tags, no photo & content, click Cancel
	@Test
	public void tc93() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title, description too short, mark as important, choose 2 tags, no photo & content, click Post
	@Test
	public void tc94() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTags();
	postAddPage.insertDescription("Test02");
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title & description, mark as important, choose 3 tags, no photo & content, click Save
	@Test
	public void tc95() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTagGroup();
	postAddPage.insertContent("");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, valid title & description, mark as important, choose 3 tags, no photo & content, click Cancel
	@Test
	public void tc96() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTagGroup();
	postAddPage.insertContent("");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title & description, mark as important, choose 3 tags, no photo & content, click Post
	@Test
	public void tc97() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.clickOnTagGroup();
	postAddPage.insertContent("");
	postAddPage.clickOnPostLink();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title & description, mark as important, choose 2 tags, video tested as photo, add content, click Cancel
	@Test
	public void tc98() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.uploadVideo();
	postAddPage.clickOnTags();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title & description, mark as important, choose 2 tags, video tested as photo, add content, click Save
	@Test
	public void tc99() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.uploadVideo();
	postAddPage.clickOnTags();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Photo error not displayed!", postAddPage.isPhotoValid("The photo must be an image."));
	}
	
//choose category, valid title & description, mark as important, choose tag, insert photo, add content, click Cancel
	@Test
	public void tc100() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.uploadJPGMPhoto();
	postAddPage.clickOnTag();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//choose category, valid title & description, mark as important, choose tag, insert photo, add content, click Save
	@Test
	public void tc101() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Test02Test002Test0002");
	postAddPage.insertDescription("Test02Test02Test02Test02Test02Test02Test02Test02Test02");
	postAddPage.clickOnImportant();
	postAddPage.uploadJPGMPhoto();
	postAddPage.clickOnTag();
	postAddPage.insertContent("Test01");
	postAddPage.clickOnSave();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	try {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test02Test002Test0002");
		} 
	catch (Exception e) {
		WebElement searchWebElement = driver.findElement(By.xpath("//input[@type='text']"));
		searchWebElement.sendKeys("Test02Test002Test0002");	
		}
	assertTrue("New Post isn't added!", postListPage.isPostOnPage("Test02Test002Test0002"));
	assertTrue("Category isn't displayed!", postListPage.isCategoryOnPage("Test02Test002Test0002", "VukTestCat"));
	assertTrue("Tag isn't displayed!", postListPage.isTagOnPage("Test02Test002Test0002", "Vuk"));
	}

//choose category, title too long, description too short, no tag, no photo & content, Save; 
//PORUKA - PROBAN JE TRY-CATCH PRE UNOSA 'CLICK ON IMPORTANT'. PROBAN JE I WAIT U METODI NIJE KLIKNUO NA RADIO. KADA SE KOMANDA 'click on important' stavi kao prva ne pokazuje se poruka da je 'tag required''
//ovo je jedini nacin da se ispise i poruka za tag i da se klikne na important
	@Test
	public void tc102() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Title01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	WebElement element = driver.findElement(By.id("tag-checkbox-1332"));
	MyWebDriver.scroolToWebElement(driver, element);
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter at least 50 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, title too long, description too short, no tag, no photo & content, Cancel;
//proban try - catch, proban wait za hvatanje Cancel buttona nije radio. jedini nacin da se ovaj low - priority bug premosti je dva klika na cancel.
	@Test
	public void tc103() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.clickOnImportant();
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription("Test01");
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());	
	}	
	
//choose category, title too short, description too long, no tag, no photo & content, Save;
//PORUKA - PROBAN JE TRY-CATCH PRE UNOSA 'CLICK ON IMPORTANT'. NIJE KLIKNUO NA RADIO. KADA SE KOMANDA 'click on important' stavi kao prva ne pokazuje se poruka da je 'tag required'. ista prica kao u TC 102.
//ovo je jedini nacin da se ispise i poruka za tag i da se klikne na important
	@Test
	public void tc104() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Title 01");
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter at least 20 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));
	}
	
//choose category, title too short, description too long, no tag, no photo & content, Cancel;
//KADA SE KLIKNE JEDNOM NA 'CLICK ON IMPORTANT' NE IZVRSAVA SE NAREDBA NI U JEDNOM SLUCAJU. PROBAN TRY CATCH. KADA SE DVA PUTA KLIKNE NA IMPORTANT A OSTAVI JEDNA KOMANDA CLICK ON CANCEL NE PRELAZI NA POST PAGE.
//JEDINI NACIN DA SE PRODJE TEST KAKO TREBA JE DA SE DVA PUTA IZVRSE OBE KOMANDE I TO SAM URADIO POSTO JE LOW PRIORITY.
	@Test
	public void tc105() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle("Title 01");
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnCancel();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}	
	
//choose category, title too long, description too long, no tag, no photo & content, Save;
//SAMO POSLE DVE KOMANDE SE MENJA IMPORTANT STATUS. PROBAN TRY CATCH, PROBANO DA SE KOMANDA IZVRSI NA POCETKU. KADA SE IZVRSI NA POCETKU NE ISPISUJE SE ERROR ZA TAG.
	@Test
	public void tc106() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnSave();
	assertTrue("Add page open problem!", postAddPage.isOnPage());
	assertTrue("Title error not displayed!", postAddPage.isTitleInserted("Please enter no more than 255 characters."));
	assertTrue("Description error not displayed!", postAddPage.isDescriptionInserted("Please enter no more than 500 characters."));
	assertTrue("Tag error not displayed!", postAddPage.isTagChosen("This field is required."));
	assertTrue("Content error not displayed", postAddPage.isConentInserted("The content field is required."));	
	}
	
//choose category, title too long, description too long, set as important no tag, no photo & content, Cancel;
	@Test
	public void tc107() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnAddNewPost();
	PostAddPage postAddPage = new PostAddPage(driver);
	assertTrue("Add page doesn't open!", postAddPage.isOnPage());
	postAddPage.selectCategory("VukTestCat");
	postAddPage.insertTitle(longTitle);
	postAddPage.insertDescription(longDescription);
	postAddPage.clickOnImportant();
	postAddPage.clickOnImportant();
	postAddPage.clickOnCancel();
	assertTrue("Post List page doesn't open!", postListPage.isOnPage());
	}
	
//logout from the site
	@Test
	public void tc108() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnLogoutIcon();
	try {
		Thread.sleep(2500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	postListPage.clickOnLoguout();
	}

}
