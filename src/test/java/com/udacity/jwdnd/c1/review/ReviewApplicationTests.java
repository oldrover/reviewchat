package com.udacity.jwdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private ChatPage chat;
	private LoginPage login;
	private SignupPage signup;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@Test
	public void signupTest() throws InterruptedException {
		driver.get("http://localhost:" + port + "/signup");
		signup = new SignupPage(driver);
		signup.setFirstName("firstname");
		signup.setLastName("lastname");
		signup.setUsername("username");
		signup.setPassword("password");
		signup.clickSubmitButton();
		Thread.sleep(2000);
		signup.clickLoginLink();
		loginTest();
	}

	@Test
	public void loginTest() {
		login = new LoginPage(driver);


	}




}
