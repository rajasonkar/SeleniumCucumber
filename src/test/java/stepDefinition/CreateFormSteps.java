package stepDefinition;

import helper.ActionHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateForm;

public class CreateFormSteps {

	CreateForm createForm = new CreateForm();
	
	@When("I enter first and last name")
	public void i_enter_first_and_last_name() {
	    createForm.enterFirstName("Abcd dhj");
	    createForm.enterLastName("sdjhej wejwe kejrf");
	}

	@When("I enter email ID")
	public void i_enter_email_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select gender from radio button")
	public void i_select_gender_from_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter mobile number")
	public void i_enter_mobile_number() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter date of birth and subject")
	public void i_enter_date_of_birth_and_subject() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select the hobbies from checkbox")
	public void i_select_the_hobbies_from_checkbox() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I uplaod a picture")
	public void i_uplaod_a_picture() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter the address")
	public void i_enter_the_address() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify city dropdown as disabled")
	public void i_verify_city_dropdown_as_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select State from the dropdown")
	public void i_select_state_from_the_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify city dropdown got enabled")
	public void i_verify_city_dropdown_got_enabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select city from the dropdown")
	public void i_select_city_from_the_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Submit button")
	public void i_click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
