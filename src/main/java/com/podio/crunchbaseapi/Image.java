package com.podio.crunchbaseapi;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Image {

	private List<List<Object>> availableSizes;

	private String attribution;

	@JsonProperty("available_sizes")
	public List<List<Object>> getAvailableSizes() {
		return availableSizes;
	}

	@JsonProperty("available_sizes")
	public void setAvailableSizes(List<List<Object>> availableSizes) {
		this.availableSizes = availableSizes;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	public String getLargest() {
		int max = 0;
		String location = null;

		for (List<Object> object : availableSizes) {
			List<Integer> size = (List<Integer>) object.get(0);
			if (size.get(0) > max) {
				max = size.get(0);
				location = (String) object.get(1);
			}
		}

		return location;
	}
}
