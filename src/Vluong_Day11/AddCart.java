package Vluong_Day11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCart {
	public WebDriver driver;
	
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
	public void VerifyAddtocartProductSuccess() {
		String Alert = "Product added";
		WebElement clickbtnproduct = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']//a[text()='Samsung galaxy s6']"));
		clickbtnproduct.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement clickbtnAddtoCart = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
		clickbtnAddtoCart.click();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Alert alertSuccesAdd = driver.switchTo().alert();
		String alertMess = alertSuccesAdd.getText();		
		Assert.assertEquals(alertMess, Alert);
		alertSuccesAdd.accept();
		
		WebElement linkCart = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Cart']"));
		linkCart.click();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		WebElement TitleProduct = driver.findElement(By.xpath("//tr[@class='success']//td[text()=\"Samsung galaxy s6\"]"));
		String Product = TitleProduct.getText();
		String Title = "Samsung galaxy s6";
		Assert.assertEquals(Product, Title);
			
	
	}
	
	@Test
	public void VerifyOrderProductSuccess() {
		String Alert = "Product added";
		WebElement clickbtnproduct = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']//a[text()='Samsung galaxy s6']"));
		clickbtnproduct.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement clickbtnAddtoCart = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
		clickbtnAddtoCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Alert alertSuccesAdd = driver.switchTo().alert();
		String alertMess = alertSuccesAdd.getText();		
		Assert.assertEquals(alertMess, Alert);
		alertSuccesAdd.accept();
		
		WebElement linkCart = driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='Cart']"));
		linkCart.click();
		
		WebElement btnOrder = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		btnOrder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
		inputName.sendKeys("VuLuong");
		
		WebElement inputCountry = driver.findElement(By.xpath("//input[@id='country']"));
		inputCountry.sendKeys("VN");
		
		WebElement inputCity = driver.findElement(By.xpath("//input[@id='city']"));
		inputCity.sendKeys("HCM");
		
		WebElement inputCard = driver.findElement(By.xpath("//input[@id='card']"));
		inputCard.sendKeys("123321123");
		
		WebElement inputMonth = driver.findElement(By.xpath("//input[@id='month']"));
		inputMonth.sendKeys("12/24");
		
		WebElement inputYear = driver.findElement(By.xpath("//input[@id='year']"));
		inputYear.sendKeys("2014");
		
		WebElement btnPurchase = driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']"));
		btnPurchase.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement MessSuccess = driver.findElement(By.xpath("(//h2)[3]"));
		String Mess = MessSuccess.getText();
		String ExpectMess = "Thank you for your purchase!";
		Assert.assertEquals(Mess, ExpectMess);
		
	}
	
	
	
	@AfterMethod
	public void AfterRun() {
		driver.quit();
	}

}
