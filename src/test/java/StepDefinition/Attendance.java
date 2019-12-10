package StepDefinition;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.util.Strings;

import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Attendance {
	double no_hours = 0;
	
	@Given("^att$")
	public void att() throws Throwable {
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
		
		d.findElement(By.id("NjEw")).click();
		
		
		
		WebElement table = d.findElement(By.xpath("//table[@class='fc-border-separate']"));

		//Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		System.out.print("check");
		for (WebElement row : allRows) {
		 List<WebElement> cells = row.findElements(By.tagName("td"));
		 for (WebElement cell : cells) {
			 
			System.out.println(cell.getText());
		 // And so on */ 
		 }
		 
		 
		/* List <WebElement> days = d.findElements(By.xpath("//*[@class='fc-event-inner fc-event-skin']"));
		System.out.println(days.size());
		for(WebElement ty : days )
		{
			String fr = ty.findElement(By.xpath("//span[@class='fc-event-time']")).getText();
			System.out.println(fr);
			
		} */
		
		List <WebElement> days = d.findElements(By.xpath("//*[@class='fc-event-title']"));
		System.out.println(days.size());
		double tot =0;
		for(WebElement ty : days )
		{
			String fr = ty.getText();
			System.out.println(fr);
			double hr = convertToHours(fr);
			tot=tot + hr;
			
		}
		System.out.println("Total hours :"+tot);
		System.out.println("Number of hours :"+no_hours);
	}


	}
	private double convertToHours(String inputTime) {
		// inputTime = " 1 hour 30 mins 20 secs";
		double hours=0;
		//double no_hours = 0;
		List<String> timeList = Arrays.asList(inputTime.split(" "));
		ListIterator<String> iterator = timeList.listIterator();
		String time = null;
		String previous = null;
		while (iterator.hasNext()) {
		int prevIndex = iterator.previousIndex();
		time = (String) iterator.next();

		if (!time.isEmpty() && time != null) {

		if (time.contains("hours") || time.contains("hrs") || time.contains("hr") || time.contains("hour")) {
		// time = time.substring(0, time.indexOf('h'));
		previous = timeList.get(prevIndex);

		hours = hours + Double.parseDouble(previous.trim());
	//	no_hours=no_hours+1;
		}

		if (time.contains("minutes") || time.contains("mins") || time.contains("min")) {
		//time = time.substring(0, time.indexOf('m'));
		previous = timeList.get(prevIndex);
		hours = hours + Double.parseDouble(previous) / 60;
		}

		if (time.contains("secs") || time.contains("sec") || time.contains("scs")) {
		//time = time.substring(0, time.indexOf('s'));
		previous = timeList.get(prevIndex);
		hours = hours + Double.parseDouble(previous) / 3600;
		}
		}
		}
		System.out.println("Hours :"+hours);
		
		//tot_hours
		
	//	System.out.println("Total hours :"+tot_hours);
		return hours;
		
		

		}
	
}
