package stepdefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Home;

public class Steps {
	
	String chromedriver="C:/Woolworths/ProjectAutomation/src/test/java/Drivers/chromedriver.exe";
	String appurl="https://www.ebay.com.au";
	WebDriver driver;
	Home objPage;
	
	@Before 
	public void setUp(){ 
		System.out.println("Start:beforeMethod 123");
		
		System.setProperty("webdriver.chrome.driver", chromedriver);
		driver=new ChromeDriver();
		objPage=new Home(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appurl);
		System.out.println("End:beforeMethod 123");
	} 
	 
	@Given("^user is already at home page$")
	public void user_is_already_at_home_page() {
		System.out.println("user is already at home page");
	}

	@When("^user Enters the text in search box$")
	public void user_Enters_the_text_in_search_box() {
		  objPage.enterSearchText("books");
	}

	@When("^user clicks on search button$")
	public void user_clicks_on_search_button()  {
		  objPage.clickSearchButton();
	}

	@When("^user opens fist link of the book$")
	public void user_opens_fist_link_of_the_book() {
		  objPage.clickFirstBook();
	}

	@When("^user clicks on add to cart button$")
	public void user_clicks_on_add_to_cart_button()  {
		  objPage.clickAddtoCart();
	}

	@When("^user clicks on go to cart button$")
	public void user_clicks_on_go_to_cart_button()  {
		objPage.clickGoToCart();
	}

	@Then("^user verifies book is added in the cart$")
	public void user_verifies_book_is_added_in_the_cart()  {
		objPage.verifyItemsPresentInCart();    										//Assertion
	}

	@Given("^user has already added item in the cart$")
	public void user_has_already_added_item_in_the_cart()  {
		System.out.println("user has already added item in the cart");
	}

	@When("^user clicks remove button$")
	public void user_clicks_remove_button()  {
		objPage.clickRemoveButton();
	}

	@Then("^user verifies book is removed from the cart$")
	public void user_verifies_book_is_removed_from_the_cart() {
		 objPage.verifyItemsNotPresentInCart();   									//Assertion
	}
	
	@After
    public void afterScenario(){
       objPage=null;
       driver.close();
    }

}
