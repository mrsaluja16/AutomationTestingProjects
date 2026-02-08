package lambda.Example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableLambdaExample {
	
	@Test
	public void getTheWebTableValue() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver dr = new ChromeDriver(chromeOptions);
		
		dr.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		
		WebElement body = dr.findElement(By.xpath("//*[@class='table table-striped mt-3']/tbody"));
		
		List<WebElement> trs = body.findElements(By.tagName("tr"));
		
		trs.forEach( tr -> {
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			tds.forEach( td -> {
				String val = td.getText();
				System.out.println("Table values are: "+val);
			});
		});
		
		
		dr.quit();
		
	}

}
