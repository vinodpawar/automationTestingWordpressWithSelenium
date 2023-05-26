package wordpress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class NewTest {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void beforeTest() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

	}

	public void sleep(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void f() {
		
		driver.get("http://localhost/wordpress/wp-login.php");
		
		WebElement username = driver.findElement(By.xpath("//*[@id='user_login']"));
		username.sendKeys("admin");

		
		WebElement password = driver.findElement(By.xpath("//*[@id='user_pass']"));
		password.sendKeys("Admin@123");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='wp-submit']"));
		loginButton.click();

		//*[@id='menu-pages']/a/div[3]
		WebElement pageMenuElement = driver.findElement(By.xpath("//*[@id='menu-pages']/a/div[3]"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(pageMenuElement);
		sleep(3);
		//*[@id='menu-pages']/ul/li[3]/a
		WebElement subMenuAddPage = driver.findElement(By.xpath("//*[@id='menu-pages']/ul/li[3]/a"));
		actions.moveToElement(subMenuAddPage);
		
		actions.click().build().perform();
		sleep(4);
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();

	}

}
