package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Leaves {
	
	@Given("^Know the leave balance$")
	public void know_the_leave_balance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 WebDriverManager.chromedriver().setup();
			WebDriver d= new ChromeDriver();
			
			d.get("https://sahayog.uknowva.com/");
			d.findElement(By.id("username")).sendKeys("2726");
			d.findElement(By.id("password")).sendKeys("Mango@1234");
			d.findElement(By.xpath("//button[@class='button']")).click();
			
			d.findElement(By.linkText("SKIP")).click();
			//shifts to profile
			d.findElement(By.xpath("//div[@class='user_avatar']")).click();
			
			d.findElement(By.xpath("//*[@id='MjEz']")).click();
			d.findElement(By.id("NjA5")).click();
			
			
			
			d.findElement(By.id("NjA0")).click();
			
			
			//List <WebElement> iframes = d.findElements(By.id("sbox-window"));
			//System.out.println("Wao"+iframes.size());
			
			//d.findElement(By.id("sbox-window")).click();
						
			List <WebElement> iframes = d.findElements(By.tagName("iframe"));
			System.out.println("Wao"+iframes.size());
			
			
			System.out.println("lol"+d.findElement(By.xpath("//*[@class='componentheading']")).getText());
			d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/my-leaves/my-leave-balance?tmpl=component']")));
			d.switchTo().frame(d.findElement(By.xpath("//*[@id='sbox-content']/iframe")));
			//List<WebElement> tt =   d.findElements(By.tagName("iframe"));
			System.out.println("No of framess are ");
			
			WebElement a = d.findElement(By.tagName("iframe"));
			//String handle= d.getWindowHandle();
			//d.switchTo().window(handle);
			
			
			
			d.switchTo().frame(a);
			
			WebElement table_element = d.findElement(By.xpath("//*[@class='table_blue']"));
		    ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		    for (WebElement row : rows) {
		        ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("//td"));
		        for (WebElement cell : cells) {
		            System.out.println(cell.getText());
		        }
		    }
		    
		    
			
		/*	String handle= d.getWindowHandle();
			d.switchTo().window(handle);
			System.out.println("Shubhams try");
			d.findElement(By.xpath("//*[@class='componentheading']")).click();
			System.out.println("Shubhams try2");
			WebElement table = d.findElement(By.xpath("//table[@class='table_blue']"));

			//Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			// And iterate over them, getting the cells
			for (WebElement row : allRows) {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) {
				 
				System.out.println(cell.getText());
			 // And so on */ 
			 }
			
	

}
