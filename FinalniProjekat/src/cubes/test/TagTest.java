package cubes.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.tag.TagsAddPage;
import cubes.pages.tag.TagsListPage;

public class TagTest {
	
	private static WebDriver driver; 
	private String tagNameUpdate = "Vuk2";
	private String tagNameUpdate2 = "Vuk3";
	private String longTagName = RandomStringUtils.randomAlphanumeric(256);

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

//leave tag name empty and click save
	@Test
	public void tc01() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName("");	
	tagsAddPage.clickOnSave();
	assertTrue("Tags name error problem!", tagsAddPage.isErrorOnPage("This field is required."));
	}
	
//leave tag name empty and click cancel
	@Test
	public void tc02() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName("");
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//leave tag name empty and click link tags
	@Test
	public void tc03() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName("");
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert tag name Vuk1 for tag name and click cancel
	@Test
	public void tc04() {
	TagsListPage tagsListPage = new TagsListPage(driver);	
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName("Vuk1");
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert tag name Vuk1 for tag name and click tags link
	@Test
	public void tc05() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName("Vuk1");
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert tag name Vuk2 for tag name and click save
	@Test
	public void tc06() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(tagNameUpdate);
	tagsAddPage.clickOnSave();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));
	}
	
//insert existing tag name Vuk2 for tag name and click Cancel
	@Test
	public void tc07() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(tagNameUpdate);
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert existing tag name Vuk2 for tag name and click save
	@Test
	public void tc08() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(tagNameUpdate);
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert existing tag name Vuk2 for tag name and click save
	@Test
	public void tc09() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(tagNameUpdate);
	tagsAddPage.clickOnSave();
	assertTrue("Problem with TagsAddPage isOpenPage",tagsAddPage.isOnPage());
	assertTrue("Missing field required error message", tagsAddPage.isDivErrorOnPage("The name has already been taken."));
	}
	
//insert tag name too long for tag name and click Cancel
	@Test
	public void tc10() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(longTagName);
	tagsAddPage.clickOnCancel();
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert tag name too long for tag name and click Tags link
	@Test
	public void tc11() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(longTagName);
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	}
	
//insert tag name too long for tag name and click Save
	@Test
	public void tc12() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnAddNewTag();
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Add page doesn't open!", tagsAddPage.isOnPage());
	tagsAddPage.insertName(longTagName);
	tagsAddPage.clickOnSave();
	assertTrue("Add page doesn't open!",tagsAddPage.isOnPage());
	assertTrue("Missing length error message", tagsAddPage.isTagNameTooLong("Please enter no more than 255 characters."));
	}
	
//edit tagNameUpdate, leave text click cancel
	@Test
	public void tc13() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnUpdateTag(tagNameUpdate);
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Wrong text name in web element",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));	
	}
	
//edit tagNameUpdate, leave text click Tags link
	@Test
	public void tc14() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnUpdateTag(tagNameUpdate);
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Wrong text name in web element",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));	
	}
	
//edit tagNameUpdate, insert empty tag name click cancel
	@Test
	public void tc15() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnUpdateTag(tagNameUpdate);
	TagsAddPage tagsAddPage = new TagsAddPage(driver);
	assertTrue("Wrong text name in web element",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));
	tagsAddPage.insertName("");
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));	
	}
	
//edit tagNameUpdate, insert empty tag name click Save
	@Test
	public void tc16() {
	TagsListPage tagsListPage = new TagsListPage(driver);				
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong tag name",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));	
	tagsAddPage.insertName("");
	tagsAddPage.clickOnSave();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));	
	}
	
//edit tagNameUpdate, insert empty tag name click Tags Link
	@Test
	public void tc17() {
	TagsListPage tagsListPage = new TagsListPage(driver);				
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong tag name",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));	
	tagsAddPage.insertName("");
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));	
	}
	
//edit tagNameUpdate, insert name too long, click Cancel
	public void tc18() {
	TagsListPage tagsListPage = new TagsListPage(driver);				
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong tag name",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));	
	tagsAddPage.insertName(longTagName);
	tagsAddPage.clickOnCancel();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));
	}
	
//edit tagNameUpdate, insert name too long, click Tags link
	public void tc19() {
	TagsListPage tagsListPage = new TagsListPage(driver);				
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong tag name",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));	
	tagsAddPage.insertName(longTagName);
	tagsAddPage.clickOnLinkTag();
	tagsAddPage.clickOnNavLink();
	assertTrue("Tags list page doesn't open!",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate));
	}
	
//edit tagNameUpdate, insert name too long, click Save
	public void tc20() {
	TagsListPage tagsListPage = new TagsListPage(driver);				
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong tag name",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));	
	tagsAddPage.insertName(longTagName);
	assertTrue("Add page doesn't open!",tagsAddPage.isOnPage());
	assertTrue("Missing length error message", tagsAddPage.isTagNameTooLong("Please enter no more than 255 characters."));
	}
	
//edit Test tag name 123, insert new tag name click save
	@Test
	public void tc21() {
	TagsListPage tagsListPage = new TagsListPage(driver);			
	tagsListPage.clickOnUpdateTag(tagNameUpdate);	
	TagsAddPage tagsAddPage = new TagsAddPage(driver);	
	assertTrue("Wrong text name in web element",tagNameUpdate.equalsIgnoreCase(tagsAddPage.getName()));
	tagsAddPage.insertName(tagNameUpdate2);
	tagsAddPage.clickOnSave();
	assertTrue("Tags list open page problem.",tagsListPage.isOnPage());
	assertTrue("New tag name missing!", tagsListPage.isTagNameElementOnPage(tagNameUpdate2));
	}
	
//delete tag, click on cancel
	@Test
	public void tc22() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnDeleteTag(tagNameUpdate2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	tagsListPage.clickOnDeleteDialogCancelButton();
	assertTrue("Tags list open page problem.",tagsListPage.isOnPage());
	assertTrue("Dialog box won't open!", tagsListPage.isTagNameElementOnPage(tagNameUpdate2));
	}

//delete tag, click on close button
	@Test
	public void tc23() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnDeleteTag(tagNameUpdate2);	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}	
	tagsListPage.clickOnDeleteDialogCloseButton();
	assertTrue("Tags list open page problem.",tagsListPage.isOnPage());
	assertTrue("Dialog box won't open!", tagsListPage.isTagNameElementOnPage(tagNameUpdate2));
	}
	
//delete tag, click on delete button
	@Test
	public void tc24() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnDeleteTag(tagNameUpdate2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	tagsListPage.clickOnDeleteDialogDeleteButton();	
	assertTrue("Tags list open page problem.",tagsListPage.isOnPage());
	assertTrue("Tag isn't deleted!", !tagsListPage.isTagNameElementOnPage(tagNameUpdate2));
	}
//logout
	@Test
	public void tc25() {
	TagsListPage tagsListPage = new TagsListPage(driver);
	tagsListPage.clickOnLogoutIcon();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	tagsListPage.clickOnLoguout();
	}
}
