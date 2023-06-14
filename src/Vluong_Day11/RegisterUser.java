package Vluong_Day11;



import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonService;
import baseObjects.Page_Register;

import org.openqa.selenium.JavascriptExecutor;


public class RegisterUser extends CommonService{
	Page_Register Pregis;
	@BeforeMethod
	public void initdata() {
		Pregis = new Page_Register(driver);
	}
	
	@Test
	public void TC_001RegisterNewUser() {
		test = extent.createTest("TC_001RegisterNewUser");
		String xpathBtnCreate = "//button[@data-qa='create-account']";
		String xpathMesstitle = "//h2[@class='title text-center']";
		String ExpectMessCreate = "ACCOUNT CREATED!";		
		// Random
		Random Ran = new Random();
		Integer RanInt = Ran.nextInt(1000);		
		//javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		// Teststep
		Pregis.access_Page(test);		
		
		Pregis.click_linkLogin(test);
//		WebElement inputName = driver.findElement(By.xpath(xpathName));
		Pregis.input_Name(test, "Toivat" + RanInt);
//		String Name1 = inputName.getText(); //GetText for compare with "ENTER ACCOUNT INFORMATION" page
//		WebElement inputEmail = driver.findElement(By.xpath(xpathEmail));		
		
		Pregis.input_Email(test,  "Toivaot" + RanInt + "@gmail.com");
//		String Email1 = inputEmail.getText();
		Pregis.click_btnSignUp(test);
		Pregis.click_RaTitle(test);
		test.info("Click Title");
		// Compare Name from "New User SignUp!" Table with "ENTER ACCOUNT INFORMATION" page
//		WebElement getName2 = driver.findElement(By.xpath(xpathNameInfor));
//		String Name2 = getName2.getText();
//		test.info("Get Name" + Name2);
//		Assert.assertEquals(Name2, Name1);
//		WebElement getEmail2 = driver.findElement(By.xpath(xpathEmailInfor));
//		String Email2 = getEmail2.getText();
//		test.info("Get Email" + Email2);
//		Assert.assertEquals(Email2, Email1);
		// Continue Teststep
		Pregis.input_Passinfor(test, "Abc123456");		
		Pregis.select_Inforday(test);
		Pregis.click_Special(test);
		Pregis.input_FistN(test, "Luong");
		Pregis.input_LastN(test, "Vu");
		Pregis.input_Company(test, "AutoLearn");
		Pregis.input_Address1(test, "1st Wesminter");
		Pregis.input_Address2(test, "2nd Wesminter");
		Pregis.select_Country(test);		
		Pregis.input_State(test, "Something");
		Pregis.input_City(test, "HCM");
		Pregis.input_Zip(test, "70000");
		Pregis.input_Number(test, "090762" + RanInt);
		
		WebElement handleClickCreate = driver.findElement(By.xpath(xpathBtnCreate));
		js.executeScript("arguments[0].click();", handleClickCreate);		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		WebElement eleMess = driver.findElement(By.xpath(xpathMesstitle));
		String ActualMess = eleMess.getText();
		Assert.assertEquals(ActualMess, ExpectMessCreate);
		
	}
	
//	@Test
//	public void TC_002RegisterNewUserWithExistingEmail() {
//		test = extent.createTest("TC_002RegisterNewUserWithExistingEmail");
//		//Xpath Element
//		String xpathLogin = "//a[@href='/login']";
//		String xpathName = "//input[@name='name']"; // Name Element on "New User SignUp!" Table
//		String xpathEmail = "//input[@data-qa='signup-email']"; // Email Element on "New User SignUp!" Table
//		String xpathBtnSignUp = "//button[@data-qa='signup-button']"; // SignUp Element on "New User SignUp!" Table
//		String xpathMess = "//p[@style='color: red;']";
//		
//		String expectMess = "Email Address already exist!";
//		//URL
//		String URL = "https://automationexercise.com/";
//		driver.get(URL);
//		
//		WebElement btnlogin = driver.findElement(By.xpath(xpathLogin));
//		btnlogin.click();
//		WebElement inputName = driver.findElement(By.xpath(xpathName));
//		inputName.sendKeys("Toivaot");
//		test.info("Enter Name" + inputName.getAttribute("value"));
//		WebElement inputEmail = driver.findElement(By.xpath(xpathEmail));
//		inputEmail.sendKeys("Toi@gmail.com");
//		test.info("Enter Email" + inputEmail.getAttribute("value"));
//		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
//		btnSignUp.click();
//		WebElement getMEss= driver.findElement(By.xpath(xpathMess));
//		String AcutalMess = getMEss.getText();
//		Assert.assertEquals(AcutalMess, expectMess);
//		test.info("Enter Compare Mess");
//		
//	}

	


	
	
}
