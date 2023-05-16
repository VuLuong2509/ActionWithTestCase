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
import org.openqa.selenium.JavascriptExecutor;


public class RegisterUser extends CommonService{
	@Test
	public void TC_001RegisterNewUser() {
		//Xpath Element
		String xpathLogin = "//a[@href='/login']";
		String xpathName = "//input[@name='name']"; // Name Element on "New User SignUp!" Table
		String xpathEmail = "//input[@data-qa='signup-email']"; // Email Element on "New User SignUp!" Table
		String xpathBtnSignUp = "//button[@data-qa='signup-button']"; // SignUp Element on "New User SignUp!" Table
		// Element on "ENTER ACCOUNT INFORMATION" page
		String xpathTileInfor = "//input[@id=\"id_gender1\"]"; 
		String xpathNameInfor = "//input[@id=\"name\"]";
		String xpathEmailInfor = "//input[@id=\"email\"]";
		String xpathPassInfor = "//input[@id=\"password\"]";
		String xpathDayInfor = "//select[@id='days']";
		String xpathMonthInfo = "//select[@id='months']";
		String xpathYearInfo = "//select[@id='years']";
		String xpathNewsletInfor = "//input[@id='newsletter']";
		String xpathSpecialInfor = "//input[@id='optin']";
		// ADDRESS INFORMATION
		String xpathFistNinfor = "//input[@id='first_name']";
		String xpathLastNinfor = "//input[@id='last_name']";
		String xpathCompanyInfor = "//input[@id='company']";
		String xpathAddress1Infor = "//input[@id='address1']";
		String xpathAddress2Infor = "//input[@id='address2']";
		String xpathCountryInfor = "//select[@id='country']";
		String xpathStateInfor = "//input[@id='state']";
		String xpathCityInfor = "//input[@id='city']";
		String xpathZipInfor = "//input[@id='zipcode']";
		String xpathphoneNumInfor = "//input[@id='mobile_number']";
		String xpathBtnCreate = "//button[@data-qa='create-account']";
		String xpathMesstitle = "//h2[@class='title text-center']";
		String ExpectMessCreate = "ACCOUNT CREATED!";
		//URL
		String URL = "https://automationexercise.com/";
		driver.get(URL);
		// Random
		Random Ran = new Random();
		Integer RanInt = Ran.nextInt(1000);		
		//javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		// Teststep
		WebElement btnlogin = driver.findElement(By.xpath(xpathLogin));
		btnlogin.click();
		WebElement inputName = driver.findElement(By.xpath(xpathName));
		inputName.sendKeys("Toivaot" + RanInt);
		String Name1 = inputName.getText(); //GetText for compare with "ENTER ACCOUNT INFORMATION" page
		WebElement inputEmail = driver.findElement(By.xpath(xpathEmail));
		inputEmail.sendKeys("Toivaot" + RanInt + "@gmail.com");
		String Email1 = inputEmail.getText();
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();		
		WebElement RaTitle = driver.findElement(By.xpath(xpathTileInfor));
		RaTitle.click();
		// Compare Name from "New User SignUp!" Table with "ENTER ACCOUNT INFORMATION" page
		WebElement getName2 = driver.findElement(By.xpath(xpathNameInfor));
		String Name2 = getName2.getText();
		Assert.assertEquals(Name2, Name1);
		WebElement getEmail2 = driver.findElement(By.xpath(xpathEmailInfor));
		String Email2 = getEmail2.getText();
		Assert.assertEquals(Email2, Email1);
		// Continue Teststep
		WebElement inputPass = driver.findElement(By.xpath(xpathPassInfor));
		inputPass.sendKeys("Abc123456");
		WebElement EleDay = driver.findElement(By.xpath(xpathDayInfor));
		Select seDay = new Select(EleDay);
		seDay.selectByVisibleText("25");
		WebElement EleMonth = driver.findElement(By.xpath(xpathMonthInfo));
		Select seMonth = new Select(EleMonth);
		seMonth.selectByVisibleText("September");
		WebElement EleYear = driver.findElement(By.xpath(xpathYearInfo));
		Select seYear = new Select(EleYear);
		seYear.selectByVisibleText("1993");
		WebElement handleClickNewslet = driver.findElement(By.xpath(xpathNewsletInfor));
		handleClickNewslet.click();
		WebElement handleClickSpecial = driver.findElement(By.xpath(xpathSpecialInfor));
		handleClickSpecial.click();
		WebElement setFistName = driver.findElement(By.xpath(xpathFistNinfor));
		setFistName.sendKeys("Luong");
		WebElement setLastName = driver.findElement(By.xpath(xpathLastNinfor));
		setLastName.sendKeys("Vu");
		WebElement setCompany = driver.findElement(By.xpath(xpathCompanyInfor));
		setCompany.sendKeys("AutoLearn");
		WebElement setAddress1 = driver.findElement(By.xpath(xpathAddress1Infor));
		setAddress1.sendKeys("1st Wesminter");
		WebElement setAddress2 = driver.findElement(By.xpath(xpathAddress2Infor));
		setAddress2.sendKeys("2nd Wesminter");
		Random Ran2 = new Random();
		Integer ranCountry = Ran2.nextInt(6);
		WebElement eleCountry = driver.findElement(By.xpath(xpathCountryInfor));
		Select seCountry = new Select(eleCountry);
		seCountry.selectByIndex(ranCountry);
		WebElement setState =  driver.findElement(By.xpath(xpathStateInfor));
		setState.sendKeys("Something");
		WebElement setCity = driver.findElement(By.xpath(xpathCityInfor));
		setCity.sendKeys("HCM");
		WebElement setZip = driver.findElement(By.xpath(xpathZipInfor));
		setZip.sendKeys("70000");
		WebElement setMobileNumber = driver.findElement(By.xpath(xpathphoneNumInfor));
		setMobileNumber.sendKeys("090762" + RanInt);
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
	
	@Test
	public void TC_002RegisterNewUserWithExistingEmail() {
		//Xpath Element
		String xpathLogin = "//a[@href='/login']";
		String xpathName = "//input[@name='name']"; // Name Element on "New User SignUp!" Table
		String xpathEmail = "//input[@data-qa='signup-email']"; // Email Element on "New User SignUp!" Table
		String xpathBtnSignUp = "//button[@data-qa='signup-button']"; // SignUp Element on "New User SignUp!" Table
		String xpathMess = "//p[@style='color: red;']";
		
		String expectMess = "Email Address already exist!";
		//URL
		String URL = "https://automationexercise.com/";
		driver.get(URL);
		
		WebElement btnlogin = driver.findElement(By.xpath(xpathLogin));
		btnlogin.click();
		WebElement inputName = driver.findElement(By.xpath(xpathName));
		inputName.sendKeys("Toivaot");
		WebElement inputEmail = driver.findElement(By.xpath(xpathEmail));
		inputEmail.sendKeys("Toi@gmail.com");
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
		WebElement getMEss= driver.findElement(By.xpath(xpathMess));
		String AcutalMess = getMEss.getText();
		Assert.assertEquals(AcutalMess, expectMess);
		
	}

	


	
	
}
