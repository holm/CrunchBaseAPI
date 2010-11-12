package com.podio.crunchbaseapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

@Consumes({ MediaType.APPLICATION_JSON, "text/json", "text/javascript",
		"application/x-javascript" })
public class CustomJacksonJsonProvider extends JacksonJsonProvider {

	public CustomJacksonJsonProvider(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	protected boolean isJsonType(MediaType mediaType) {
		if (super.isJsonType(mediaType)) {
			return true;
		}

		return mediaType != null
				&& (mediaType.getType().equalsIgnoreCase("text") && mediaType
						.getSubtype().equals("javascript"))
				|| (mediaType.getType().equalsIgnoreCase("application") && mediaType
						.getSubtype().equals("x-javascript"));
	}

}
