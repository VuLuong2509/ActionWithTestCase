package Vluong_Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.debugger.Debugger.ExecuteWasmEvaluatorResponse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Information_Product extends CommonService{
	
	@Test
	public void TC_010InforItemWomen() {
		Data excel = new Data();
		
		//Xpath
		String xpathLinkProduct = "//a[@href='#Women']";
		String xpathDressWM = "//a[@href='/category_products/1']";
		String xpathProD1 = "//a[@href='/product_details/3']";
		String URL = "https://automationexercise.com/";
		String xpathNameProduct = "(//h2)[3]";
		String xpathCateProduct = "(//p)[3]";
		String xpathPriceProduct = "(//span)[12]/span";
		String xpathAvailabilityProduct = "//div[@class='product-information']/p[2]";
		String xpathConditionProduct = "//div[@class='product-information']/p[3]";
		String xpathBrandProduct = "//div[@class='product-information']/p[4]";
		driver.get(URL);
		
		WebElement clkLickPro = driver.findElement(By.xpath(xpathLinkProduct));
		clkLickPro.click();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clkDress = driver.findElement(By.xpath(xpathDressWM));
		clkDress.click();
		
		
		// handel ad google
		String url_ads = "https://automationexercise.com/#google_vignette";
		String current_URL = driver.getCurrentUrl();
		if (current_URL.equalsIgnoreCase(url_ads)) {
			WebElement ifr_ads = driver.findElement(By.xpath("//iframe[contains(@id,'aswift_5')]"));
			driver.switchTo().frame(ifr_ads);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement close_ads = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
			close_ads.click();
			driver.switchTo().defaultContent();			
		}
		
		WebElement clkProD1 = driver.findElement(By.xpath(xpathProD1));
		clkProD1.click();
		
		String readdata = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 1);
		System.out.println("data is " + readdata);
		WebElement VrfNameProduct =  driver.findElement(By.xpath(xpathNameProduct));
		String Name = VrfNameProduct.getText();
		Assert.assertEquals(Name, readdata);
		System.out.println("Verify Name Product");
		
		String readdata1 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 2);
		System.out.println("data is " + readdata1);
		WebElement VrfCateProduct = driver.findElement(By.xpath(xpathCateProduct));
		String Cata = VrfCateProduct.getText();
		Assert.assertEquals(Cata, readdata1);
		System.out.println("Verify Category Product");
		
		String readdata2 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 3);
		System.out.println("data is " + readdata2);
		WebElement VrfPriceProdct = driver.findElement(By.xpath(xpathPriceProduct));
		String Price = VrfPriceProdct.getText();
		Assert.assertEquals(Price, readdata2);
		System.out.println("Verify Price Product");
		
		String readdata3 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 4);
		System.out.println("data is " + readdata3);
		WebElement VrfAvailabilityProduct = driver.findElement(By.xpath(xpathAvailabilityProduct));
		String Availability = VrfAvailabilityProduct.getText();
		Assert.assertEquals(Availability, readdata3);
		System.out.println("Verify Availability Product");
		
		String readdata4 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 5);
		System.out.println("data is " + readdata4);
		WebElement VrfConditionProduct = driver.findElement(By.xpath(xpathConditionProduct));
		String Condition = VrfConditionProduct.getText();
		Assert.assertEquals(Condition, readdata4);
		System.out.println("Verify Condition Product");
		
		String readdata5 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 6);
		System.out.println("data is " + readdata5);
		WebElement VrfBrandProduct = driver.findElement(By.xpath(xpathBrandProduct));
		String Brand = VrfBrandProduct.getText();
		Assert.assertEquals(Brand, readdata5);
		System.out.println("Verify Brand Product");
		
	}
}
