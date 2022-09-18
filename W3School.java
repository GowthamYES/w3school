package leaning1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3School {

	public static void main(String[] args) throws IOException {
		
		
		
		
	WebDriverManager.edgedriver().setup();
	EdgeDriver	driver=new EdgeDriver();
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
//to click the try it button this button within the iframe so firts switch to the 1frame then only we can access the button within that
// click the button alert pop up is displayed
//then we switch to alert function  and enter the text by send keys
//to print entered text in console get text function is used
	
		
	driver.switchTo().frame("iframeResult");
	
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("baji");
		alert.accept();
		
		 String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		
		if(text.contains("baji")){
		
System.out.println("success");
		}
else {
	System.out.println("fail");
}
		
		
		
		
		
		
File source = driver.getScreenshotAs(OutputType.FILE);
		
		File destination =new File("./screenshort.png");
		
		FileUtils.copyFile(source, destination);

	}

	

}
