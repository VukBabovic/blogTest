package cubes.test.post;
//IAKO SI KAZAO DA NE RADIMO TO PROBAO SAM I MUCIO SE PAR DANA OKO TOGA DA NADJEM PSEUDO-ELEMENTE KOJI SU LOKATORI ZA STRELICE NA TABELI I NISAM USPEO. NAPISAO SAM TE TESTOVE U MANUELNOM DELU. 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.post.PostListPage;

public class PostListTest {

	private String postTitle = "Title 01, Title 01, Title 01";
	
	private static WebDriver driver;
	
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
//test functionality of search field
	@Test
	public void tc01() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement("Title 01, Title 01, Title 01");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//test functionality of search by author field
	@Test
	public void tc02() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchByAuthor("Polaznik Kursa");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//test functionality of search by category field
	@Test
	public void tc03() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchByCategory("VukTestCat");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//test functionality of search by importance field
	@Test
	public void tc04() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchByImportance("yes");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//test functionality of search by status field
	@Test
	public void tc05() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchByStatus("enabled");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//disable post
	@Test
	public void tc06() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.searchWebElement(postTitle);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	postListPage.clickOnDisable("Title 01, Title 01, Title 01");
	}
//enable post
	@Test
	public void tc07() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnEnable("Title 01, Title 01, Title 01");
	}
//mark post as unimportant
	@Test
	public void tc08() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnUnmportant("Title 01, Title 01, Title 01");
	}
//mark post as important
	@Test
	public void tc09() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnEnable("Title 01, Title 01, Title 01");
	}
//test functionality of show entries field, choose 25 entries
	@Test
	public void tc11() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.showEntries("25");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//test functionality of show entries field, choose 50 entries
	@Test
	public void tc12() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.showEntries("50");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	//delete post
	@Test
	public void tc13() {
	PostListPage postListPage = new PostListPage(driver);
	postListPage.clickOnDeletePost("Title 01, Title 01, Title 01");
	postListPage.clickOnDeleteDialogDeleteButton();
	}
//MNOGO SAM SE ZAINATIO BIO DA NADJEM OVE PSEUDO ELEMENTE I MNOGO SAM VREMENA POTROSIO. NISAM STIGAO DA NAPISEM AUTOMATSKE TESTOVE PAR METODA AKO BUDE POTREBNO ZA NAJVISU OCENU POSLACU JOS JEDAN FILE SA TIM METODAMA
}
