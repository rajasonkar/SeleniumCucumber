package pages;

import org.openqa.selenium.By;

import helper.ActionHelper;
import utils.TestBase;

public class CreateForm extends TestBase{
	
	private By firstName = By.cssSelector("input#firstName");

	private By lastName = By.cssSelector("input#lastName");
	private By emailId = By.cssSelector("input#userEmail");
	private By maleRadioButton = By.xpath("//label[text()='Male']");
	private By mobileNumber = By.cssSelector("input#userNumber");
	private By dob = By.cssSelector("input#dateOfBirthInput");
	private By hobbySports = By.xpath("//label[text()='Sports']");
	private By hobbyReading = By.xpath("//label[text()='Reading']");
	private By uploadPicture = By.cssSelector("input#uploadPicture");
	private By address = By.xpath("//textarea[@class='form-control']");
	private By selectState = By.xpath("//div[text()='Select State']");
	private By selectCity = By.xpath("//div[@id ='city']");
	private By submitButton = By.cssSelector("button#submit");
	//private By subject = By.cssSelector("div#subjectsContainer");
	private By yearDropdown = By.cssSelector("select.react-datepicker__year-select");
	private By selectDate = By.xpath("//div[text()='20']");
	private String stateCity = "//div[text()='%s']";
	ActionHelper actionHelper = new ActionHelper();
	public void enterFirstName (String name) 
	{ 
		actionHelper.scrollToElement(firstName);
		actionHelper.setText(firstName, name);
	}
	public void enterLastName (String name) 
	{
		actionHelper.setText(lastName, name);
	}

	public void enterEmailId(String mailId) 
	{
		actionHelper.setText(emailId, mailId);
	}
	public void radioButton() 
	{
		actionHelper.click(maleRadioButton);
	}
	public void enterNumber(String number) 
	{
		actionHelper.setText(mobileNumber, number);
	}
	public void enterDoB() 
	{
		actionHelper.click(dob);
		actionHelper.selectValueFromDropDown(yearDropdown, "2030");
		actionHelper.click(selectDate);
		actionHelper.elementAvailability("invisible", yearDropdown);
	}
	public void setHobby() 
	{
		actionHelper.click(hobbyReading);
		actionHelper.click(hobbySports);
	}
	public void uploadImage() 
	{
		actionHelper.uploadFile("src\\test\\resources\\dummy.jpg",uploadPicture);
	}
	public void enterAddress(String add) 
	{
		actionHelper.setText(address, add);
	}
	public void selectStateDropdown(String value) 
	{
		actionHelper.click(selectState);
		TestBase.driver.findElement(By.xpath(String.format(stateCity, "NCR"))).click();
	}
	public boolean checkIsEnabled() 
	{
		String str= actionHelper.getTextByAttribute("input",selectCity);
		return str.contains("disabled");
	}
	public void selectCityDropdown(String value) 
	{
		actionHelper.click(selectCity);
		TestBase.driver.findElement(By.xpath(String.format(stateCity, "Delhi"))).click();
	}
	public void clickSubmit() 
	{
		actionHelper.click(submitButton);
	}
	
	public void enterSubject(String sub) 
	{
		//actionHelper.elementAvailability("clickable", subject);

		//actionHelper.click(subject);
		//actionHelper.setText(subject, sub);
	}
}
