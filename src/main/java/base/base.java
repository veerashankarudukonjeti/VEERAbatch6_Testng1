package base;
	import java.sql.Timestamp;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class base {
		public static WebDriver driver;
		@BeforeSuite
		public void timeStamp() {
			Date d=new Date();
			Timestamp ts=new Timestamp(d.getTime());
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(format.format(ts));
		}
		
		@BeforeTest
		public void driverIni() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@BeforeClass
		public void login() {
			driver.get("https://adactinhotelapp.com/");
			driver.findElement(By.id("username")).sendKeys("9908961746");
			driver.findElement(By.id("password")).sendKeys("Veera@225.");
			driver.findElement(By.id("login")).click();
		}
		
		@AfterTest
		public void driverClose() {
			driver.close();
		}
		
		@AfterSuite
		public void timeStamp01() {
			Date d=new Date();
			Timestamp ts=new Timestamp(d.getTime());
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(format.format(ts));
		}

	}

}
