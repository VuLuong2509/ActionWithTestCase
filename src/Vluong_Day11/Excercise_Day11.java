package Vluong_Day11;



import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Excercise_Day11 {
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
	
	//@Test
	public void Userregister(){		
		Random ran = new Random();
		Integer Ranuser = ran.nextInt(1000);		
		WebElement clickbtnSignUp = driver.findElement(By.xpath("//a[@id='signin2']"));
		clickbtnSignUp.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement EntUser = driver.findElement(By.xpath("//input[@id='sign-username']"));
		EntUser.sendKeys("toivaot" + Ranuser);
		
		WebElement EntPass = driver.findElement(By.xpath("//input[@id='sign-password']"));
		EntPass.sendKeys("auto1047");
		
		WebElement ClickbtnRegister = driver.findElement(By.xpath("//button[@onclick='register()']"));
		ClickbtnRegister.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alertDialog = driver.switchTo().alert();		
		String alertText = alertDialog.getText();		
		String Alert = "Sign up successful.";
		Assert.assertEquals(alertText, Alert);
		alertDialog.accept();
		
	}
	
	//@Test 
	public void VerifyTheErrorBlankUserAndPass(){	
		String Alert = "Please fill out Username and Password.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);		
	}
	
	@Test 
	public void VerifyTheErrorBlankPass(){
		//xpath
		String xpathLogin = "//a[@id='login2']";
		String xpathinputUser = "//input[@id='loginusername']";
		String xpathinputPass = "//input[@id='loginpassword']";
		String xpathbtnLogin = "//button[@onclick='logIn()']";
		String Alert = "Please fill out Username and Password.";		
		WebElement linkLogin = driver.findElement(By.xpath(xpathLogin));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath(xpathinputUser));
		inputUser.sendKeys("Toivaot");		
		WebElement inputPass = driver.findElement(By.xpath(xpathinputPass));
		inputPass.sendKeys("");		
		WebElement btnLogin = driver.findElement(By.xpath(xpathbtnLogin));
		btnLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);				
	}
	
//	@Test 
	public void VerifyTheErrorBlankUser(){
		//xpath
//		String xpathLogin = "//a[@id='login2']";
//		String xpathinputUser = "//input[@id='loginusername']";
//		String xpathinputPass = "//input[@id='loginpassword']";
//		String xpathbtnLogin = "//button[@onclick='logIn()']";	
		String Alert = "Please fill out Username and Password.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("8438126");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);				
	}
	
//	@Test 
	public void VerifyTheErrorIncorrectUser(){
		//xpath
//		String xpathLogin = "//a[@id='login2']";
//		String xpathinputUser = "//input[@id='loginusername']";
//		String xpathinputPass = "//input[@id='loginpassword']";
//		String xpathbtnLogin = "//button[@onclick='logIn()']";	
		String Alert = "Wrong password.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("Hello");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("8438126");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);				
	}
	
//	@Test 
	public void VerifyTheErrorIncorrectPass(){
		//xpath
//		String xpathLogin = "//a[@id='login2']";
//		String xpathinputUser = "//input[@id='loginusername']";
//		String xpathinputPass = "//input[@id='loginpassword']";
//		String xpathbtnLogin = "//button[@onclick='logIn()']";
//		
		String Alert = "Wrong password.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("Hello");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("8438126");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);				
	}
	
//	@Test 
	public void VerifyTheUserNotexist(){
		//xpath
//		String xpathLogin = "//a[@id='login2']";
//		String xpathinputUser = "//input[@id='loginusername']";
//		String xpathinputPass = "//input[@id='loginpassword']";
//		String xpathbtnLogin = "//button[@onclick='logIn()']";		
		String Alert = "User does not exist.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("sdfgajkshd");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("8438126");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alertDialogBlankvalue = driver.switchTo().alert();
		String alertMess = alertDialogBlankvalue.getText();		
		Assert.assertEquals(Alert, alertMess);				
	}
	
//	@Test 
	public void VerifyTheuserLoginsuccessful(){
		//xpath
//		String xpathLogin = "//a[@id='login2']";
//		String xpathinputUser = "//input[@id='loginusername']";
//		String xpathinputPass = "//input[@id='loginpassword']";
//		String xpathbtnLogin = "//button[@onclick='logIn()']";		
		String Alert = "User does not exist.";		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@id='login2']"));
		linkLogin.click();		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement inputUser = driver.findElement(By.xpath("//input[@id='loginusername']"));
		inputUser.sendKeys("toivaot");		
		WebElement inputPass = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		inputPass.sendKeys("8438126");		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
		btnLogin.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement eleWellcome = driver.findElement(By.xpath("//a[@id='nameofuser']"));
		String MessWelcome = eleWellcome.getText();
		String Messlogin = "Welcome toivaot";
		Assert.assertEquals(Messlogin, MessWelcome);
		
		
		
	}
	

	
	@AfterMethod
	public void AfterRun() {
		driver.quit();
	}

}
