import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterLogin {
@Test

public void RegisterTest(){

// OpenUrl

    String url = "https://parabank.parasoft.com/parabank/index.htm";
    WebDriver driver = new EdgeDriver();
    driver.get(url);
    driver.manage().window().maximize();



    //REGISTER


WebElement registerUser = driver.findElement(By.linkText("Register"));
registerUser.click();

    WebElement firstName = driver.findElement(By.name("customer.firstName"));
    firstName.sendKeys("test123");

    WebElement lastName = driver.findElement(By.name("customer.lastName"));
    lastName.sendKeys("test");

    WebElement address = driver.findElement(By.id("customer.address.street"));
    address.sendKeys("District 1");

    WebElement city = driver.findElement(By.name("customer.address.city"));
    city.sendKeys("Freljord");

    WebElement state = driver.findElement(By.id("customer.address.state"));
    state.sendKeys("state1");

    WebElement zipCode = driver.findElement(By.name("customer.address.zipCode"));
    zipCode.sendKeys("3412412");

    WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
    phoneNumber.sendKeys("0752123289");

    WebElement socialNumber = driver.findElement(By.name("customer.ssn"));
    socialNumber.sendKeys("8881881");

    WebElement username = driver.findElement(By.name("customer.username"));
    username.sendKeys("testUsername14");

    WebElement password = driver.findElement(By.name("customer.password"));
    password.sendKeys("password123");

    WebElement confirmPassword = driver.findElement(By.name("repeatedPassword"));
    confirmPassword.sendKeys("password123");

    WebElement finishRegister = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
finishRegister.click();


    //Check landing url

    String expectedURL = "https://parabank.parasoft.com/parabank/register.htm";
    String actualURL = driver.getCurrentUrl();
    Assert.assertEquals(expectedURL, actualURL);

    //Check succes register message

    WebElement succesAllert = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
    String expectedMessage = "Your account was created successfully. You are now logged in.";
    String actualMessage = succesAllert.getText();
    Assert.assertTrue(actualMessage.contains(expectedMessage));

    //LOG OUT
    WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
Assert.assertTrue(logoutButton.isDisplayed());
logoutButton.click();

driver.close();

}
@Test(priority = 2)
public void LogIn(){

    String url = "https://parabank.parasoft.com/parabank/index.htm";
    WebDriver driver = new EdgeDriver();
    driver.get(url);
    driver.manage().window().maximize();

    //LOGIN

    WebElement usernameInput = driver.findElement(By.name("username"));
    usernameInput.sendKeys("testUsername14");
    WebElement passwordInput = driver.findElement(By.name("password"));
    passwordInput.sendKeys("password123");

    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
    loginButton.click();

    driver.close();


}

}

