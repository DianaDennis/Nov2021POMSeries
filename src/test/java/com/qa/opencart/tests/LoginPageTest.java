package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - 100 : Design Login page for Open Cart Application.....")
@Story("US - 101: Login Page Features")
public class LoginPageTest extends BaseTest {

	@Description("login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(enabled = true)//false to skip execution
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
//TC_01 indicates test case number..
	@Description("TC_01: login page url test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageURLTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("Login page url : " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("this is testing forgot pwd link on login page")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkTest() {
		//Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		Assert.assertTrue(false);//bug
	}
	
	@Description("positive test case for login with correct credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(description = "login test with correct username and password")//test NG annotation for description
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	

}



