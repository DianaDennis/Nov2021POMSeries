package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

    @Epic("EPIC - 100 : Design registration page for Open Cart Application.....")
    @Story("US - 102: Register Page Features")
    public class RegisterPageTest extends BaseTest {

    @Description("Register Page setUp Test")
    @Severity(SeverityLevel.BLOCKER)
	@BeforeClass
	public void regSetUp() {
		regPage = loginPage.goToRegisterPage();
	}
    @Description("rendom password generator for register Page Test")
    @Severity(SeverityLevel.MINOR)
	public String getRandomNumber() {
		Random randomGen = new Random();
		String email = "testautomationNovBatch"+randomGen.nextInt(1000)+"@gmail.com";
		return email;
	}
	@Description("dataProvider test case for register with correct credentials...")
	@Severity(SeverityLevel.CRITICAL)
	@DataProvider
	public Object[][] getRegisterData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	@Description("userRegistration test case for register user credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, 
												String telephone, 
												String password, String subscribe) throws InterruptedException {
		
		Assert.assertTrue(regPage.accountRegistration(firstName, lastName, getRandomNumber(), 
													telephone, password,  subscribe));
		
	}

}



