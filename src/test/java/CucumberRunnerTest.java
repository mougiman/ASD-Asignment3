/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author mougi
 */
public class CucumberRunnerTest {    WebDriver driver;
    
    @Given("^I have opened the browser")
    public void givenStatement() throws InstantiationException, IllegalAccessException{
    
    Class<? extends WebDriver> driverClass = FirefoxDriver.class;
    WebDriverManager.getInstance(driverClass).setup();
    driver = driverClass.newInstance();
    //driver.get("https://asd-backup.herokuapp.com/");
    
    System.out.println("Given statement completed");
    }
    
    @When("^I visit website")
    public void whenStatement(){
        driver.get("https://asd-backup.herokuapp.com/index.jsp");
    }
    @Then("^website reurns content$")
    public void thenStatment(){
        Assert.assertEquals("Home", driver.getTitle());
    }
}
