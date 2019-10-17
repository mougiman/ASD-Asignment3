/*
 * Test the Login function using selenium and cucumber acceptance testing 
 */
package asd.demo.test;

/**
 *
 * @author Calvin
 */
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewProfileFeature {

    WebDriver driver;

   @Given("^I am on the item page$")
    public void i_am_on_the_item_page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://asd-backup.herokuapp.com/item?id=01"); //GOES TO ITEM PAGE
    }
    @When("^I view other user's profile \"([^\"]*)\"$")
    public void i_view_other_user_profile(String arg1) throws Throwable {
        driver.findElement(By.xpath("//href[@class='sellerprofile']")).click(); //Click on sellerName for view profile
   
    }

    @Then("^I should see user profile \"([^\"]*)\"$")
    public void i_should_see_user_profile(String arg1) throws Throwable {
        driver.navigate().to("https://asd-backup.herokuapp.com/profile?id=340563");
    }
    
    @Then("^Then I should see no items$")
    public void i_should_see_no_items() throws Throwable {
            System.out.print("You must be logged in to User Profile page");
    }
}
