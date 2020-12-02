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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private ChatPage chat;
	private LoginPage login;
	private SignupPage signup;
	private static TestUser testUser;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		testUser= new TestUser(
				"Firstname",
				"Lastname",
				"Username",
				"Password");
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@Test
	public void signupTest() throws InterruptedException {
		driver.get("http://localhost:" + port + "/signup");
		signup = new SignupPage(driver);
		signup.setFirstName(testUser.getFirstname());
		signup.setLastName(testUser.getLastname());
		signup.setUsername(testUser.getUsername());
		signup.setPassword(testUser.getPassword());
		signup.clickSubmitButton();
		Thread.sleep(2000);
		signup.clickLoginLink();
		loginTest();
	}

	@Test
	public void loginTest() throws InterruptedException {
		login = new LoginPage(driver);
		login.setUsername(testUser.getUsername());
		login.setPassword(testUser.getPassword());
		login.clickLoginButton();
		Thread.sleep(2000);
		chatTest();

	}

	@Test
	public void chatTest() throws InterruptedException {
		chat = new ChatPage(driver);
		String testMessage ="Test Message";
		chat.setMessageText(testMessage);
		chat.clickSubmitButton();
		Thread.sleep(1000);
		assertEquals(testMessage, chat.getMessageText());
		assertEquals(testUser.getUsername(), chat.getUsername());

	}




}
