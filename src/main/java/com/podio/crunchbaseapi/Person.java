package com.podio.crunchbaseapi;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

public class Person extends BaseObject {

	private String firstName;

	private String lastName;

	private String birthplace;

	private String affiliationName;

	private Integer bornYear;

	private Integer bornMonth;

	private Integer bornDay;

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

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@JsonProperty("affiliation_name")
	public String getAffiliationName() {
		return affiliationName;
	}

	@JsonProperty("affiliation_name")
	public void setAffiliationName(String affiliationName) {
		this.affiliationName = affiliationName;
	}

	public LocalDate getBorn() {
		if (bornYear != null) {
			return new LocalDate(bornYear, bornMonth, bornDay);
		} else {
			return null;
		}
	}

	@JsonProperty("born_year")
	public Integer getBornYear() {
		return bornYear;
	}

	@JsonProperty("born_year")
	public void setBornYear(Integer bornYear) {
		this.bornYear = bornYear;
	}

	@JsonProperty("born_month")
	public Integer getBornMonth() {
		return bornMonth;
	}

	@JsonProperty("born_month")
	public void setBornMonth(Integer bornMonth) {
		this.bornMonth = bornMonth;
	}

	@JsonProperty("born_day")
	public Integer getBornDay() {
		return bornDay;
	}

	@JsonProperty("born_day")
	public void setBornDay(Integer bornDay) {
		this.bornDay = bornDay;
	}
}
