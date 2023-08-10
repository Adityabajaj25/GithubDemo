import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {

    public static WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Aditya\\test\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @DataProvider(name = "Credentials")
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "admin";
        data[0][1] = "admin123";

        data[1][0] = "admin1";
        data[1][1] = "admin123";

        data[2][0] = "admin";
        data[2][1] = "admin1234";

        return data;
    }

    @DataProvider(name = "ExcelCred")
    public Object[][] getDataFromExcel() throws Exception {
        ExcelLibrary lib = new ExcelLibrary("D:\\Aditya\\test\\IntelliJ\\DataDrivenFramework\\TestData\\LoginData.xlsx");
        Object[][] data = lib.readExcelData("Credentials");
        return data;
    }


}
