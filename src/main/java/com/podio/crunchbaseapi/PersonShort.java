package com.podio.crunchbaseapi;

import org.codehaus.jackson.annotate.JsonProperty;

public class PersonShort extends BaseObjectShort {

	private String firstName;
	
	private String lastName;


	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
