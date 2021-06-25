package GitHubProject;

import Utility.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class groupStudy {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    //@Test
    public void CreateAccount(){
    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        Faker email=new Faker();
        driver.findElement(By.id("email_create")).sendKeys(email.internet().emailAddress());
        driver.findElement(By.xpath("(//button/span)[2]")).click();
    }

    @Test //Ferhat
    public void LoginFunctionality() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Actions action=new Actions(driver);

        WebElement womanTab=driver.findElement(By.linkText("Women"));
        action.moveToElement(womanTab).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//li/a)[1]")).click();

        WebElement secondItem=driver.findElement(By.xpath("//img[@alt='Blouse']"));
        action.moveToElement(secondItem).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[.='More'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span/i)[6]")).click();

        WebElement sizeDropdown=driver.findElement(By.id("group_1"));
        Select sizeDrop=new Select(sizeDropdown);
        sizeDrop.selectByValue("3");
        driver.findElement(By.xpath("//a[@title='White']")).click();
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')])[2]")).click();

    }




}
