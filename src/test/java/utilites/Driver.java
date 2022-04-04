package utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
 private Driver(){

   }
   public static WebDriver driver;
   //driver e başka class lardan sadece Driver class ismiyle çağırabilmek
   // için STATİC yaptık.

   public static WebDriver getDriver(){
      if (driver==null) {
         switch (ConfigReader.getProperty("browser")) {
            case "chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
            case "firefox":
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;
            case "opera":
               WebDriverManager.operadriver().setup();
               driver = new OperaDriver();
               break;
            case "edge":
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
               break;
            default:
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
         }

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      }
      return driver;
   }
   public static void closeDriver(){
      if (driver!=null){
         driver.quit();
         // Burada yeniden null değeri atamamızın nedeni, bir sonraki getDriver method u çağrışımızda
         // yeni değer atayabilme isteğimizdir.
      }
driver=null;
   }

}
