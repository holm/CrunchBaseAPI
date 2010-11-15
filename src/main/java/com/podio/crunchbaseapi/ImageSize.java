package com.podio.crunchbaseapi;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(using = ImageSizeDeserializer.class)
public class ImageSize implements Comparable<ImageSize> {

	private final int width;

	private final int height;

	private final String location;

	public ImageSize(int width, int height, String location) {
		super();
		this.width = width;
		this.height = height;
		this.location = location;
	}

	@Override
	public int compareTo(ImageSize o) {
		return Integer.valueOf(width).compareTo(Integer.valueOf(o.width));
	}

	@Override
	public String toString() {
		return "ImageSingle [width=" + width + ", height=" + height
				+ ", location=" + location + "]";
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getLocation() {
		return location;
	}
}
