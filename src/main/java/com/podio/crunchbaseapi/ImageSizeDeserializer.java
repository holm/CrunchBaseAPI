package com.podio.crunchbaseapi;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class ImageSizeDeserializer extends JsonDeserializer<ImageSize> {

	@Override
	public ImageSize deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// Start array
		jp.nextToken();
		// Width
		jp.nextToken();
		int width = jp.getIntValue();
		// Height
		jp.nextToken();
		int height = jp.getIntValue();
		// End array
		jp.nextToken();
		// Location
		jp.nextToken();
		String location = jp.getText();
		jp.nextToken();

		return new ImageSize(width, height, location);
	}

}
