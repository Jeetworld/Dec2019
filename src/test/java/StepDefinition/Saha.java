package StepDefinition;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Saha {
	
	@Given("^Simply like all the status.$")
	public void fcfgfg() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // System.out.println("sds");
	    WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		/* d.get("https://gmail.com");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		d.findElement(By.id("identifierId")).sendKeys("Singhkamaljit64");
		d.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();
		//*[@id="identifierNext"]/span/span
		d.findElement(By.xpath("//*[@aria-label='Enter your password']")).sendKeys("singhkamal");
		//d.findElement(By.xpath("//*[@id='passwordNext']")).click();
		//*[@id="passwordNext"]/span/span
		//*[@id="passwordNext"]/span/span
		 JavascriptExecutor jse = ((JavascriptExecutor)d);
         jse.executeScript("document.getElementById('passwordNext').click();"); */
		
		d.get("https://sahayog.uknowva.com/");
		d.findElement(By.id("username")).sendKeys("2726");
		d.findElement(By.id("password")).sendKeys("Mango@1234");
		d.findElement(By.xpath("//button[@class='button']")).click();
		
		d.findElement(By.linkText("SKIP")).click();
		//shifts to profile
		d.findElement(By.xpath("//div[@class='user_avatar']")).click();
		
		d.findElement(By.xpath("//*[@id='MjEz']")).click();
		
	//like the posts
		/* int number_of_likes= d.findElements(By.xpath("//*[@href='#like']")).size();
		System.out.println(number_of_likes);
		d.manage().timeouts().implicitlyWait(15000,TimeUnit.SECONDS);
		 for(int i = 1 ; i <= number_of_likes ; i++)
		{
		
			System.out.println("one times");
		d.findElement(By.xpath("//*[@href='#like']")).click();
		} */
		
		
		List<WebElement> aa=  d.findElements(By.xpath("//*[@href='#like']"));
		int likes_size= aa.size();
		System.out.println(likes_size);
		
		for(int i= 0 ; i < likes_size ; i++)
		{
			aa.get(i).click();
			
		}	
	
		
	}

}
