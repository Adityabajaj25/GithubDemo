import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestclass extends BaseClass {
    @Test(dataProvider = "ExcelCred")
    public void login(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public void login_ExcelData(String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
}
