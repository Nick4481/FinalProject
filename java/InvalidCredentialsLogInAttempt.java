import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvalidCredentialsLogInAttempt {


    @BeforeTest

    public void SetUp() {
//OPEN URL

        String url = "https://parabank.parasoft.com/parabank/index.htm";
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
        // Invalid LogInTest
    @Test(priority = 1)
public void InvalidLogIn(){

        String url = "https://parabank.parasoft.com/parabank/index.htm";
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        // InvalidCredentials

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("incorect");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        loginButton.click();

        //CHECK ERROR


        WebElement errorAlert = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
        String expectedErrorMessage = "The username and password could not be verified.";
        String actualErrorMessage = expectedErrorMessage;
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));

        driver.close();



}



}





