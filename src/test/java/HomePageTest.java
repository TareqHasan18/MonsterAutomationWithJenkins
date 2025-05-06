import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HomePageTest {

    public static WebDriver driver;
    public static Properties properties;
    public HomePageTest(){

        try{
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\tareq\\IdeaProjects\\BuildAutomationWithJenkins\\src\\test\\java\\secret.properties");
            properties.load(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @BeforeMethod
    public static void setUp() {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tareq\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equals("FF")){
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\tareq\\Downloads\\chromedriver-win64\\chromedriver-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get(properties.getProperty("url"));

    }

    @Test
    public void FindJobsLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[1]/a")).click();

    }

    @Test
    public void SalaryToolsLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[2]/a")).click();
    }

    @Test
    public void CareerAdviceLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[3]/a")).click();
    }

    @Test
    public void ResumeHelpLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[4]/a")).click();
    }

    @Test
    public void UploadResumeLinkTest(){
        driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div[4]/nav/div/div[2]/ul/li[5]/a")).click();
    }


    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }
}
