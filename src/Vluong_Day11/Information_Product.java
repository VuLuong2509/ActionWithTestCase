package Vluong_Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Information_Product {
	public WebDriver driver;
	public String product ="//div[@class='col-lg-4 col-md-6 mb-4']//a[text()='%s']";
	@BeforeMethod
	public void BeforeRun() {
		String url = "https://www.demoblaze.com/index.html";
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);	
//		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void InformationSSgalaxys6() {
		WebElement clickbtnproduct = driver.findElement(By.xpath(String.format(product, "Samsung galaxy s6")));
		clickbtnproduct.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textName = driver.findElement(By.xpath("//h2[@class='name']"));
		String Name = textName.getText();
		String expectName = "Samsung galaxy s6";
		Assert.assertEquals(Name, expectName);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textPrice = driver.findElement(By.xpath("//h3"));
		String Price = textPrice.getText();
		String expectPrice = "$360 *includes tax";
		Assert.assertEquals(Price, expectPrice);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textInforProduct = driver.findElement(By.xpath("(//p)[4]"));
		String Infor = textInforProduct.getText();
		String expectInfor = "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.";
		Assert.assertEquals(Infor, expectInfor);
		
	}
	
	@Test
	public void InformationSonyvaioi5() {
		
		WebElement linklaptop = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Laptops']"));
		linklaptop.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement clickbtnProductLaptop = driver.findElement(By.xpath("//div[@class='card-block']//a[text()='Sony vaio i5']"));
		clickbtnProductLaptop.click();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textName = driver.findElement(By.xpath("//h2[@class='name']"));
		String Name = textName.getText();
		String expectName = "Sony vaio i5";
		Assert.assertEquals(Name, expectName);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textPrice = driver.findElement(By.xpath("//h3"));
		String Price = textPrice.getText();
		String expectPrice = "$790 *includes tax";
		Assert.assertEquals(Price, expectPrice);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textInforProduct = driver.findElement(By.xpath("(//p)[4]"));
		String Infor = textInforProduct.getText();
		String expectInfor = "Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight.";
		Assert.assertEquals(Infor, expectInfor);
		
	}
	
	@Test
	public void InformationApplemonitor24() {
		
		WebElement linklaptop = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Monitors']"));
		linklaptop.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement clickbtnProductLaptop = driver.findElement(By.xpath("//div[@class='card-block']//a[text()='Apple monitor 24']"));
		clickbtnProductLaptop.click();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textName = driver.findElement(By.xpath("//h2[@class='name']"));
		String Name = textName.getText();
		String expectName = "Apple monitor 24";
		Assert.assertEquals(Name, expectName);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textPrice = driver.findElement(By.xpath("//h3"));
		String Price = textPrice.getText();
		String expectPrice = "$400 *includes tax";
		Assert.assertEquals(Price, expectPrice);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement textInforProduct = driver.findElement(By.xpath("(//p)[4]"));
		String Infor = textInforProduct.getText();
		String expectInfor = "LED Cinema Display features a 27-inch glossy LED-backlit TFT active-matrix LCD display with IPS technology and an optimum resolution of 2560x1440. It has a 178 degree horizontal and vertical viewing angle, a \"typical\" brightness of 375 cd/m2, contrast ratio of 1000:1, and a 12 ms response time.";
		Assert.assertEquals(Infor, expectInfor);
		
	}
	
	@AfterMethod
	public void AfterRun() {
		driver.quit();
	}

}
