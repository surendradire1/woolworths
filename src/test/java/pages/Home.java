package pages;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Home {
	
	   private WebDriver driver;
	   WebDriverWait wait;

	   By txtBooks = By.id("gh-ac");
	   By btnSearch = By.id("gh-btn");
	   By lstBooks = By.xpath("//li[starts-with(@id,'srp-river-results-listing')]"); 
	   By lstFirstBook = By.id("gh-btn"); // totalbooks.get(0).findElement(By.className("s-item__link")).click();
	   By lnkAddtoCart = By.id("atcRedesignId_btn");
	   By lnkGoToCart = By.linkText("Go to cart");
	   By txtItemInCart = By.xpath("//h1[text()='Shopping cart (1 item)']"); 
	   By lnkRemove = By.xpath("//*[contains(text(),'Remov')]"); 
	   By txtEmptyCart = By.xpath("//*[contains(text(),'You don')]"); 
	   
	
	   public Home(WebDriver driver){
	       this.driver=driver;
	   }

	   public void enterSearchText(String books){
		   WebElement txtBooks1 = (new WebDriverWait(driver, 20))
				   .until(ExpectedConditions.presenceOfElementLocated(txtBooks));
		   txtBooks1.sendKeys(books);
	   }
	   
	   public void clickSearchButton(){
		   driver.findElement(btnSearch).click();
	   }

	   public void clickFirstBook(){
		   List<WebElement> totalbooks= driver.findElements(By.xpath("//li[starts-with(@id,'srp-river-results-listing')]"));
		   System.out.println("total books count : " + totalbooks.size());
		   totalbooks.get(0).findElement(By.className("s-item__link")).click();
	   }
	   
	   public void clickAddtoCart(){
		   driver.findElement(lnkAddtoCart).click();
	   }
	   
	   public void clickGoToCart(){
		   driver.findElement(lnkGoToCart).click();
	   }
	   
	   public void clickRemoveButton(){
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("arguments[0].click();", driver.findElement(lnkRemove));
	   }
	   
	   public void verifyItemsPresentInCart(){
		   assertTrue(driver.findElement(txtItemInCart).getText().contains("1 item"));
	   }
	   
	   public void verifyItemsNotPresentInCart(){
		   assertTrue(driver.findElement(txtEmptyCart).getText().contains("You don't have any items in your cart"));
	   }
	   
	 
	   


}
