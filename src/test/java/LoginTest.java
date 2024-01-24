import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// testNG framework
public class LoginTest {
    private WebDriver driver = new ChromeDriver();
    @Test
    public void testLoginPage() {
        String url = "https://practicetestautomation.com/practice-test-login/";
        navigateAndWaitForElements(url, "username", "password", "submit");
        String usernameData = "student";
        String userPassword = "Password123";
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        username.sendKeys(usernameData);
        password.sendKeys(userPassword);
        submitButton.click();
        WebElement successTextOnPage = driver.findElement(By.cssSelector("h1.post-title"));
        String actualResult = successTextOnPage.getText();
        String expectedResult = "Logged In Successfully";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @AfterTest
    public void closeChrome() {
        driver.quit();
    }

    private void navigateAndWaitForElements(String url, String...elementsID) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        for (String elementID: elementsID) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementID)));
        }
    }
}
