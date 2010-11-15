package com.podio.crunchbaseapi;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Image {

	private List<ImageSize> availableSizes;

	private String attribution;

	@JsonProperty("available_sizes")
	public List<ImageSize> getAvailableSizes() {
		return availableSizes;
	}

	@JsonProperty("available_sizes")
	// @JsonDeserialize(contentAs = ImageSize.class)
	public void setAvailableSizes(List<ImageSize> availableSizes) {
		this.availableSizes = availableSizes;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
}
