package GitHubProject;

import Utility.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    @Test
    public void TestCase2() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        Faker info=new Faker();

        String email=info.internet().emailAddress();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.xpath("(//button/span)[2]")).click();
        Thread.sleep(2000);

        String name=info.name().firstName();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);

        String surname=info.name().firstName();
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);

        String password=info.internet().password();
        driver.findElement(By.id("passwd")).sendKeys(password);

        driver.findElement(By.id("firstname")).sendKeys(name);
        driver.findElement(By.id("lastname")).sendKeys(surname);

        driver.findElement(By.id("address1")).sendKeys(info.address().streetAddress());
        driver.findElement(By.id("city")).sendKeys(info.address().city());

        WebElement stateDropdown=driver.findElement(By.id("id_state"));
        Select stateDrop=new Select(stateDropdown);
        stateDrop.selectByValue("1");

        driver.findElement(By.id("postcode")).sendKeys("12345");

        WebElement countryDropdown=driver.findElement(By.id("id_country"));
        Select countryDrop=new Select(countryDropdown);
        countryDrop.selectByValue("21");

        driver.findElement(By.id("phone_mobile")).sendKeys(info.phoneNumber().cellPhone());
        driver.findElement(By.id("alias")).sendKeys(info.name().username());
        driver.findElement(By.xpath("//span[.='Register']")).click();

        String myAccount=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(myAccount,"MY ACCOUNT");

    }

    @Test
    public void testCase1() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector(".login")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("mickey.parisian@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("ymb395rph");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        Thread.sleep(2000);
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
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']/span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']/span")).click();
        driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        String orderConfirmation=driver.findElement(By.xpath("//*[@id='center_column']/p[1]")).getText();
        Assert.assertEquals(orderConfirmation,"Your order on My Store is complete.");
    }




}
