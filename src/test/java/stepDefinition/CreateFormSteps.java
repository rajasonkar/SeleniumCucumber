package stepDefinition;

import io.cucumber.java.en.When;
import pages.CreateForm;

public class CreateFormSteps {

	CreateForm createForm = new CreateForm();
	
	@When("^I enter first (.*) and last name (.*)$")
	public void i_enter_first_and_last_name(String firstName , String lName) {
	    createForm.enterFirstName(firstName);
	    createForm.enterLastName(lName);
	}

	@When("^I enter email ID (.*)$")
	public void i_enter_email_id(String mail) {
	    createForm.enterEmailId(mail);
	}

	@When("I select gender from radio button")
	public void i_select_gender_from_radio_button() {
	    createForm.radioButton();
	}

	@When("^I enter mobile number (.*)$")
	public void i_enter_mobile_number(String number) {
	 createForm.enterNumber(number);    
	}

	@When("I enter date of birth and subject")
	public void i_enter_date_of_birth_and_subject() {
	createForm.enterDoB();    
	createForm.enterSubject("English");
	}

	@When("I select the hobbies from checkbox")
	public void i_select_the_hobbies_from_checkbox() {
	 createForm.setHobby(); 
	}

	@When("I uplaod a picture")
	public void i_uplaod_a_picture() {
     createForm.uploadImage();
	}

	@When("I enter the address")
	public void i_enter_the_address() {
	createForm.enterAddress("124 uyd 1265  whb");    
	}

	@When("^I select State (.*) from the dropdown$")
	public void i_select_state_from_the_dropdown(String state) {
		createForm.selectStateDropdown(state);
		
	}
	@When("^I select city (.*) from the dropdown$")
	public void i_select_city_from_the_dropdown(String city) {
		createForm.selectCityDropdown(city);
		}

	@When("I click on Submit button in form page")
	public void i_click_on_submit_button() {
		createForm.clickSubmit();    
	}

}
