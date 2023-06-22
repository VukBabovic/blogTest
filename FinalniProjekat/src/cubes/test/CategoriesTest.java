package cubes.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.categories.CategoriesAddPage;
import cubes.pages.categories.CategoriesListPage;

public class CategoriesTest {
	
	private static WebDriver driver;
	private String longName = RandomStringUtils.randomAlphanumeric(256);
	private String longDescription = RandomStringUtils.randomAlphanumeric(501);
	private String categoryName = "VukCategory";
	private String categoryName1 = "VukCategory1";
	private String categoryDescription = "Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01";
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
//add new category, empty name & description, click save
	@Test
	public void tc01() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	assertTrue("Insert Description error", categoriesAddPage.isDivErrorOnPage("This field is required."));
	}
//add new category, empty name & description, click cancel
	@Test
	public void tc02() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, empty name & description, click link Post Categories
	@Test
	public void tc03() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, empty name & less than 50 characters in description click Save
	@Test
	public void tc04() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	assertTrue("Insert description error", categoriesAddPage.isDescriptionTooShort("The description must be at least 50 characters."));
	}
//add new category, empty name & less than 50 characters in description click Cancel
	@Test
	public void tc05() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, empty name & less than 50 characters in description click link Post Categories
	@Test
	public void tc06() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, empty name & requested no. of characters in description, click Save
	@Test
	public void tc07() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	}
//add new category, empty name & requested no. of characters in description, click Cancel
	@Test
	public void tc08() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, empty name & requested no. of characters in description, click Post Categories
	@Test
	public void tc09() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
	
//add new category, insert name & leave description empty. click Save
	@Test
	public void tc10() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert Description error", categoriesAddPage.isDivErrorOnPage("This field is required."));
	}
//add new category, insert name & leave description empty. click Cancel
	@Test
	public void tc11() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, insert name & leave description empty. click Post Categories
	@Test
	public void tc12() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, insert name & less than 50 characters in description click Save
	@Test
	public void tc13() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert description error", categoriesAddPage.isDescriptionTooShort("The description must be at least 50 characters."));
	}
//add new category, insert name & less than 50 characters in description click Cancel
	@Test
	public void tc14() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, insert name & less than 50 characters in description click Post Categories
	@Test
	public void tc15() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, insert name & requested number of characters click Cancel
	@Test
	public void tc16() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());	
	}
//add new category, insert name & requested number of characters click Post Categories
	@Test
	public void tc17() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());	
	}
//add new category, insert name & requested number of characters click Save
	@Test
	public void tc18() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	assertTrue("New Category missing!", categoriesListPage.isCategoryNameElementOnPage(categoryName));
	assertTrue("Description missing!", categoriesListPage.isCategoryDescriptionElementOnPage(categoryDescription, categoryName));
	}
//add new category with the existing name click Cancel
	@Test
	public void tc19() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}	
//add new category with the existing name click Save
	@Test
	public void tc20() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Taken name error missing!", categoriesAddPage.isNameTaken("The name has already been taken."));
	}
//add new category, insert correct name & description too long click Save
	@Test
	public void tc21() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Description error missing!", categoriesAddPage.isDescriptionTooLong("Please enter no more than 500 characters."));
	}
//add new category, insert correct name & description too long click Cancel
	@Test
	public void tc22() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnCancel();
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//add new category, insert name & description too long click Save
	@Test
	public void tc23() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(longName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnSave();
	assertTrue("Name error missing!", categoriesAddPage.isErrorOnPage("Please enter no more than 255 characters."));
	assertTrue("Description error missing!", categoriesAddPage.isDescriptionTooLong("Please enter no more than 500 characters."));
	}
//add new category, insert name & description too long click Cancel
	@Test
	public void tc24() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnAddNewCategory();
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	categoriesAddPage.insertName(longName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnCancel();
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category with empty name & description click Save
	@Test
	public void tc25() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnSave();
	categoriesAddPage.clickOnSave();
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	assertTrue("Insert Description error", categoriesAddPage.isDivErrorOnPage("This field is required."));
	}
//edit category, empty name & description, click cancel
	@Test
	public void tc26() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, empty name & description, click link Post Categories
	@Test
	public void tc27() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, empty name & less than 50 characters in description click Save
	@Test
	public void tc28() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnSave();
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	assertTrue("Insert description error", categoriesAddPage.isDescriptionTooShort("The description must be at least 50 characters."));
	}
//edit category, empty name & less than 50 characters in description click Cancel
	@Test
	public void tc29() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, empty name & less than 50 characters in description click link Post Categories
	@Test
	public void tc30() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01");	
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, empty name & requested no. of characters in description, click Save
	@Test
	public void tc31() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Insert Name error", categoriesAddPage.isErrorOnPage("This field is required."));
	}
//edit category, empty name & requested no. of characters in description, click Cancel
	@Test
	public void tc32() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, empty name & requested no. of characters in description, click Post Categories
	@Test
	public void tc33() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName("");
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert name & leave description empty. click Save
	@Test
	public void tc34() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnSave();
	assertTrue("Insert Description error", categoriesAddPage.isDivErrorOnPage("This field is required."));
	}
//edit category, insert name & leave description empty. click Cancel
	@Test
	public void tc35() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert name & leave description empty. click Post Categories
	@Test
	public void tc36() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert name & less than 50 characters in description click Save
	@Test
	public void tc37() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesAddPage.isOnPage());
	assertTrue("Insert description error", categoriesAddPage.isDescriptionTooShort("The description must be at least 50 characters."));
	}
//edit category, insert name & less than 50 characters in description click Cancel
	@Test
	public void tc38() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert name & less than 50 characters in description click Post Categories
	@Test
	public void tc39() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription("Test01");
	categoriesAddPage.clickOnCategoryLink();
	categoriesAddPage.clickOnNavLink();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert correct name & description too long click Save
	@Test
	public void tc40() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnSave();
	assertTrue("Description error missing!", categoriesAddPage.isDescriptionTooLong("Please enter no more than 500 characters."));
	}
//edit category, insert correct name & description too long click Cancel
	@Test
	public void tc41() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnCancel();
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert name & description too long click Save
	@Test
	public void tc42() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(longName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnSave();
	assertTrue("Name error missing!", categoriesAddPage.isErrorOnPage("Please enter no more than 255 characters."));
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	assertTrue("Description error missing!", categoriesAddPage.isDescriptionTooLong("Please enter no more than 500 characters."));
	}
//edit category, insert name & description too long click Cancel
	@Test
	public void tc43() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(longName);
	categoriesAddPage.insertDescription(longDescription);
	categoriesAddPage.clickOnCancel();
	categoriesAddPage.clickOnCancel();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	}
//edit category, insert new name & requested number of characters click Save
	@Test
	public void tc44() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickonEditCategory(categoryName);
	CategoriesAddPage categoriesAddPage = new CategoriesAddPage(driver);
	assertTrue("Wrong Category name!", categoryName.equalsIgnoreCase(categoriesAddPage.getName()));
	categoriesAddPage.insertName(categoryName1);
	categoriesAddPage.insertDescription("Test01Test01Test01Test01Test01Test01Test01Test01Test01Test01");
	categoriesAddPage.clickOnSave();
	assertTrue("Requested page doesn't open", categoriesListPage.isOnPage());
	assertTrue("New Category missing!", categoriesListPage.isCategoryNameElementOnPage(categoryName1));
	}	
//click on delete category button click cancel
	@Test
	public void tc45() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnDeleteCategory(categoryName1);
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	categoriesListPage.clickOnDialogCancelButton();
	
	}
//click on delete category button click close
	@Test
	public void tc46() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnDeleteCategory(categoryName1);
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	categoriesListPage.clickOnDialogCloseButton();
	
	}
//click on delete category button click close
	@Test
	public void tc47() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnDeleteCategory(categoryName1);
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	categoriesListPage.clickOnDialogDeleteButton();
	
	}
//logout
	@Test
	public void tc48() {
	CategoriesListPage categoriesListPage = new CategoriesListPage(driver);
	categoriesListPage.clickOnLogoutIcon();
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	categoriesListPage.clickOnLoguout();
	}
}


