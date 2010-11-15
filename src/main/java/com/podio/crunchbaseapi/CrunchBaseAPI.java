package com.podio.crunchbaseapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.joda.time.DateTime;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CrunchBaseAPI {

	private final WebResource resource;

	public CrunchBaseAPI() {
		this("api.crunchbase.com", 80);
	}

	public CrunchBaseAPI(String hostname, int port) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		Client client = Client.create(config);
		client.setReadTimeout(30 * 1000);

		URI uri;
		try {
			uri = new URI("http", null, hostname, port, null, null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

		this.resource = client.resource(uri).path("/v/1/");
	}

	private JacksonJsonProvider getJsonProvider() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		CustomDeserializerFactory deserializerFactory = new CustomDeserializerFactory();
		deserializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeDeserializer());
		deserializerFactory.addSpecificMapping(String.class,
				new StringDeserializer());
		mapper.setDeserializerProvider(new StdDeserializerProvider(
				deserializerFactory));

		return new CustomJacksonJsonProvider(mapper);
	}

	public List<CompanyShort> getCompanies() {
		return resource.path("companies.js").get(
				new GenericType<List<CompanyShort>>() {
				});
	}

	public Company getCompany(String permalink) {
		return resource.path("company/" + permalink + ".js").get(Company.class);
	}

	public List<FinancialOrganizationShort> getFinancialOrganizations() {
		return resource.path("financial-organizations.js").get(
				new GenericType<List<FinancialOrganizationShort>>() {
				});
	}

	public FinancialOrganization getFinancialOrganization(String permalink) {
		return resource.path("financial-organization/" + permalink + ".js")
				.get(FinancialOrganization.class);
	}

	public Person getPerson(String permalink) {
		return resource.path("person/" + permalink + ".js").get(Person.class);
	}

	public List<PersonShort> getPersons() {
		return resource.path("people.js").get(
				new GenericType<List<PersonShort>>() {
				});
	}
}
