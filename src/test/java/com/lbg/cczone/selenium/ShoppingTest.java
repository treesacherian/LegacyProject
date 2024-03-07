package com.lbg.cczone.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:CCZone-schema.sql",
		"classpath:CCZone-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ShoppingTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void init() {
		this.driver = new EdgeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	void createCart() {

		this.driver.get("http://localhost:3000/shopping");
		WebElement buyer = this.driver.findElement(By.id("buyer"));
		buyer.sendKeys("Jordan");

		WebElement submit = this.driver
				.findElement(By.cssSelector("body > div > div:nth-child(3) > div:nth-child(1) > div.card > button"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", submit);
		this.driver.executeScript("arguments[0].click();", submit);

		WebElement createdCart = this.driver
				.findElement(By.cssSelector("body > div > div:nth-child(3) > div:nth-child(5) > div > div > div > h3"));
		assertEquals(true, createdCart.getText().contains("Jordan"));
	}

	@Test
	void deleteCart() {
		this.driver.get("http://localhost:3000/shopping");
		WebElement buyer = this.driver.findElement(By.id("buyer"));
		buyer.sendKeys("Pamela");

		WebElement submit = this.driver
				.findElement(By.cssSelector("body > div > div:nth-child(3) > div:nth-child(1) > div.card > button"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", submit);
		this.driver.executeScript("arguments[0].click();", submit);

		WebElement deleteShoppingCart = this.driver.findElement(By.cssSelector(
				"body > div > div:nth-child(3) > div:nth-child(5) > div > div > div > div.card-text > button:nth-child(3)"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", deleteShoppingCart);
		this.driver.executeScript("arguments[0].click();", deleteShoppingCart);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(deleteShoppingCart));
		List<WebElement> carts = this.driver
				.findElements(By.cssSelector("body > div > div:nth-child(3) > div:nth-child(5) > div > div > div"));
		Assertions.assertEquals(0, carts.size());
	}

}
