package selenium.Wow;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {


	  @FindBy(xpath="//td[@class='icon-boss-padded']/a")
	  private WebElement boss_element;

	  
	  public BossPage clickOnBoss(WebDriver driver) {
		 System.out.println("clickOnBossMethod");
		 boss_element.click();
		 return PageFactory.initElements(driver, BossPage.class);
	  }
	  
	
	
}
