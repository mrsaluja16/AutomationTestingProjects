package org.pages;

import org.basic.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBusPages extends BaseTest {
	
	@FindBy(xpath = "//div[text()='From']")
	private WebElement fromJourney;
	
	@FindBy(xpath = "//div[text()='To']")
	private WebElement toJourney;
	
	@FindBy(xpath = "//div[text()='Date of Journey']")
	private WebElement dateOfJourney;
	
	@FindBy(xpath = "")
	private WebElement a;
	

	public RedBusPages() {
		PageFactory.initElements(driver, this);
	}
	
	public void sendDataInFromJourey(String data) {
		fromJourney.click();
		fromJourney.sendKeys(data);
	}
	
	public void sendDataInToJourey(String data) {
		toJourney.click();
		toJourney.sendKeys(data);
	}
}
