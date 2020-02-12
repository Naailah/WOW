package selenium.Wow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class AppTest {

	
	WebDriver driver;
	String b = "firefox";
	String url= "https://fr.wowhead.com/";
	
	@Before
	public void setUp() {
		System.out.println("\n@Before");
		choisirNavigateur(b);
		driver.manage().deleteAllCookies();
	}
	
	//@After
	public void tearDown(){
		System.out.println("\n@After");
		//driver.close();
	}
	
	@Test
	
	public void test() throws InterruptedException{
		
		driver.get(url);	
		WelcomePage welcome_page = PageFactory.initElements(driver, WelcomePage.class);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		welcome_page.acceptCookies();
		
		SearchResultPage search_result_page = welcome_page.search(driver, "Lardeur");
		Thread.sleep(5000);
		BossPage boss_page = search_result_page.clickOnBoss(driver);
	}
	

	
	
	@Ignore
	public void interactionBasique() throws Exception {	
		
		
	}

	
	public void choisirNavigateur(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("browser mal renseigné");
		}
	}
	
	public void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
}