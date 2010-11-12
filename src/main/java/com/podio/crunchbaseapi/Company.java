package com.podio.crunchbaseapi;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

public class Company extends BaseCompany {

	private String categoryCode;

	private Integer deadpooledYear;

	private Integer deadpooledMonth;

	private Integer deadpooledDay;

	private String deadpooledUrl;

	@JsonProperty("category_code")
	public String getCategoryCode() {
		return categoryCode;
	}

	@JsonProperty("category_code")
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public LocalDate getDeadpooled() {
		if (deadpooledYear != null) {
			return new LocalDate(deadpooledYear, deadpooledMonth, deadpooledDay);
		} else {
			return null;
		}
	}

	@JsonProperty("deadpooled_year")
	public Integer getDeadpooledYear() {
		return deadpooledYear;
	}

	@JsonProperty("deadpooled_year")
	public void setDeadpooledYear(Integer deadpooledYear) {
		this.deadpooledYear = deadpooledYear;
	}

	@JsonProperty("deadpooled_month")
	public Integer getDeadpooledMonth() {
		return deadpooledMonth;
	}

	@JsonProperty("deadpooled_month")
	public void setDeadpooledMonth(Integer deadpooledMonth) {
		this.deadpooledMonth = deadpooledMonth;
	}

	@JsonProperty("deadpooled_day")
	public Integer getDeadpooledDay() {
		return deadpooledDay;
	}

	@JsonProperty("deadpooled_day")
	public void setDeadpooledDay(Integer deadpooledDay) {
		this.deadpooledDay = deadpooledDay;
	}

	@JsonProperty("deadpooled_url")
	public String getDeadpooledUrl() {
		return deadpooledUrl;
	}

	@JsonProperty("deadpooled_url")
	public void setDeadpooledUrl(String deadpooledUrl) {
		this.deadpooledUrl = deadpooledUrl;
	}
}
