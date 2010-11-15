package com.podio.crunchbaseapi;

import org.codehaus.jackson.annotate.JsonProperty;

public class Relationship {

	private boolean isPast;

	private String title;

	private PersonShort person;

	@JsonProperty("is_past")
	public boolean isPast() {
		return isPast;
	}

	@JsonProperty("is_past")
	public void setPast(boolean isPast) {
		this.isPast = isPast;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PersonShort getPerson() {
		return person;
	}

	public void setPerson(PersonShort person) {
		this.person = person;
	}

}
