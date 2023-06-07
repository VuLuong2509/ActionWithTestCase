package Vluong_Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUser extends CommonService{
	String xpathLogin = "//a[@href='/login']";
	String eleEmail = "//input[@data-qa='login-email']";
	String elePass = "//input[@data-qa='login-password']";
	String btnLogin= "//button[@data-qa='login-button']";
	String URL  = "https://automationexercise.com/";
	
	//handel HTML5 Validation by javascript
	//Research from https://vntesters.com/java-webdriver-14-kiem-tra-html5-validation-message/
	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// declare javascript
		return (String) js.executeScript("return arguments[0].validationMessage;", element);
		}

	
	@Test
	public void TC_003LoginWithWrongFormatEmail(){
		test = extent.createTest("TC_003LoginWithWrongFormatEmail");		
		//xpath
		String Expectalert = "Your email or password is incorrect!";		
		driver.get(URL);	
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("Toi.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
 		setPass.sendKeys("8438126");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn:" + clickBtnLogin.getAttribute("textContent"));
		String EmailWrongFormat = getHtml5ValidationMessage(driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailWrongFormat, "Please include an '@' in the email address. 'Toi.com' is missing an '@'.");
		test.info("Compare validation");
	}
	
	@Test
	public void TC_004LoginWithEmtyEmail(){
		test = extent.createTest("TC_004LoginWithEmtyEmail");
		//xpath
		String Expectalert = "Your email or password is incorrect!";		
		driver.get(URL);	
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("8438126");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn:" + clickBtnLogin.getAttribute("textContent"));
		String EmailEmtyMess = getHtml5ValidationMessage(driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailEmtyMess, "Please fill out this field.");
		test.info("Compare validation");
	}
	
	@Test
	public void TC_005LoginWithEmtyPass(){
		test = extent.createTest("TC_005LoginWithEmtyPass");
		//xpath
		String Expectalert = "Your email or password is incorrect!";		
		driver.get(URL);	
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("Toi@gmail.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn:" + clickBtnLogin.getAttribute("textContent"));
		String EmailEmtyPass = getHtml5ValidationMessage(driver.findElement(By.xpath(elePass)));
		Assert.assertEquals(EmailEmtyPass, "Please fill out this field.");
		test.info("Compare validation");
	}
	
	@Test
	public void TC_006LoginWithWrongEmail(){
		test = extent.createTest("TC_006LoginWithWrongEmail");
		//xpath
		String xpathlMess = "//p[@style='color: red;']";
		String Expectalert = "Your email or password is incorrect!";		
		driver.get(URL);		
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("lqhv@gmail.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("848126");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn login");
		WebElement getMess= driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		test.info("Compare validation");
	}
	
	@Test
	public void TC_007LoginWithWrongPass(){
		test = extent.createTest("TC_007LoginWithWrongPass");
		//xpath
		String xpathlMess = "//p[@style='color: red;']";
		String Expectalert = "Your email or password is incorrect!";		
		driver.get(URL);		
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("Toi@gmail.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("234234");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn login");
		WebElement getMess= driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		test.info("Compare validation");
		
	}
	
	@Test
	public void TC_008LoginSuccessfuly(){
		test = extent.createTest("TC_008LoginSuccessfuly");
		//xpath 
		String xpathMess= "(//ul[@class='nav navbar-nav'])/li[10]/a";
		String Expectalert = "Your email or password is incorrect!";
		String ExpectMess = "Logged in as toivaot";
		driver.get(URL);		
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("Toi@gmail.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("8438126");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		test.info("click btn login");
		WebElement getMess = driver.findElement(By.xpath(xpathMess));
		String ActualMess = getMess.getText();
		Assert.assertEquals(ActualMess, ExpectMess);
		test.info("Compare validation");
	}
	 
	@Test
	public void TC_009UserCanLogout(){
		test = extent.createTest("TC_009UserCanLogout");
		//xpath
		String xpathLogout = "//a[@href='/logout']";
		String ExpectURL = "https://automationexercise.com/login";
		driver.get(URL);
		WebElement clickLogout = driver.findElement(By.xpath(xpathLogout));
		clickLogout.click();
		test.info("Click link Logout");
		WebElement clicklogin = driver.findElement(By.xpath(xpathLogin));
		clicklogin.click();	
		test.info("Click link Login");
		WebElement setEmail = driver.findElement(By.xpath(eleEmail));
		setEmail.sendKeys("Toi@gmail.com");
		test.info("Enter Email: "+ setEmail.getAttribute("value"));
		WebElement setPass = driver.findElement(By.xpath(elePass));
		setPass.sendKeys("8438126");
		test.info("Enter PASS: "+ setPass.getAttribute("value"));
		WebElement clickBtnLogin = driver.findElement(By.xpath(btnLogin));
		clickBtnLogin.click();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clickLogout2 = driver.findElement(By.xpath(xpathLogout));
		clickLogout2.click();
		test.info("Click link Logout");
		JavascriptExecutor js = (JavascriptExecutor) driver;// declare javascript
		String currentURL = (String) js.executeScript("return window.location.href"); // get current URL
		Assert.assertEquals(currentURL, ExpectURL); // compare URL
		test.info("Compare validation Current");
	}

}
