package selenium.Wow;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	  @FindBy(name="q")
	  private WebElement search_field;

	  @FindBy(xpath="//button[@class='as-oil__btn-optin as-js-optin as-oil__btn-initial']")
	  private WebElement accept_button;
	
	  public void acceptCookies() {
  
		  accept_button.click();
	  }
	  
	  public SearchResultPage search(WebDriver driver, String keyword) {
		  System.out.println("searchMethod");
		  Outils.renseignerChamp(search_field, keyword);
		  search_field.sendKeys(Keys.ENTER);
		 
		  return PageFactory.initElements(driver, SearchResultPage.class);
	  }
	  

 
}