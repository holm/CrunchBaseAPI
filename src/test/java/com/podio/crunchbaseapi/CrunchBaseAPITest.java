package com.podio.crunchbaseapi;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class CrunchBaseAPITest {

	private CrunchBaseAPI getAPI() {
		return new CrunchBaseAPI();
	}

	@Test
	public void getCompanies() {
		List<CompanyShort> companies = getAPI().getCompanies();

		Assert.assertTrue(companies.size() > 50000);
		Assert.assertNotNull(companies.get(0).getName());
		Assert.assertNotNull(companies.get(0).getPermalink());
	}

	@Test
	public void getCompany() {
		Company company = getAPI().getCompany("facebook");

		Assert.assertEquals(company.getName(), "Facebook");
		Assert.assertEquals(company.getPermalink(), "facebook");
		Assert.assertEquals(company.getCrunchbaseUrl(),
				"http://www.crunchbase.com/company/facebook");
		Assert.assertEquals(company.getHomepageUrl(), "http://facebook.com");
		Assert.assertEquals(company.getBlogUrl(), "http://blog.facebook.com");
		Assert.assertEquals(company.getBlogFeedUrl(),
				"http://blog.facebook.com/atom.php");
		Assert.assertEquals(company.getTwitterUsername(), "facebook");
		Assert.assertEquals(company.getCategoryCode(), "web");
		Assert.assertEquals(company.getNumberOfEmployees().intValue(), 1000);
		Assert.assertEquals(company.getFounded(), new LocalDate(2004, 2, 1));
		Assert.assertEquals(company.getDeadpooled(), null);
		Assert.assertEquals(company.getDeadpooledUrl(), null);
		Assert.assertEquals(company.getTags().size(), 7);
		Assert.assertEquals(company.getAliases().size(), 0);
		Assert.assertEquals(company.getEmailAddress(), null);
		Assert.assertEquals(company.getPhoneNumber(), null);
		Assert.assertEquals(company.getDescription(), "Social network");
		Assert.assertEquals(company.getCreatedAt(), new DateTime(2007, 5, 25,
				21, 22, 15, 0, DateTimeZone.UTC));
		Assert.assertEquals(company.getUpdatedAt(), new DateTime(2010, 11, 4,
				6, 20, 5, 0, DateTimeZone.UTC));
		Assert.assertEquals(company.getImage().getAvailableSizes().size(), 3);
	}

	@Test
	public void getFinancialOrganizations() {
		List<FinancialOrganizationShort> financialOrganizations = getAPI()
				.getFinancialOrganizations();

		Assert.assertTrue(financialOrganizations.size() > 5000);
		Assert.assertNotNull(financialOrganizations.get(0).getName());
		Assert.assertNotNull(financialOrganizations.get(0).getPermalink());
	}

	@Test
	public void getFinancialOrganization() {
		FinancialOrganization financialOrganization = getAPI()
				.getFinancialOrganization("accel-partners");

		Assert.assertEquals(financialOrganization.getName(), "Accel Partners");
		Assert.assertEquals(financialOrganization.getPermalink(),
				"accel-partners");
		Assert.assertEquals(financialOrganization.getCrunchbaseUrl(),
				"http://www.crunchbase.com/financial-organization/accel-partners");
		Assert.assertEquals(financialOrganization.getHomepageUrl(),
				"http://www.accel.com");
		Assert.assertEquals(financialOrganization.getBlogUrl(), null);
		Assert.assertEquals(financialOrganization.getBlogFeedUrl(), null);
		Assert.assertEquals(financialOrganization.getTwitterUsername(), null);
		Assert.assertEquals(financialOrganization.getNumberOfEmployees(), null);
		Assert.assertEquals(financialOrganization.getFounded(), null);
		Assert.assertEquals(financialOrganization.getTags().size(), 3);
		Assert.assertEquals(financialOrganization.getTags().get(0), "accel");
		Assert.assertEquals(financialOrganization.getTags().get(1),
				"venture-capital");
		Assert.assertEquals(financialOrganization.getTags().get(2), "newfund");
		Assert.assertEquals(financialOrganization.getAliases().size(), 1);
		Assert.assertEquals(financialOrganization.getEmailAddress(),
				"siliconvalley@accel.com");
		Assert.assertEquals(financialOrganization.getPhoneNumber(),
				"(650) 614-4800");
		Assert.assertEquals(financialOrganization.getDescription(), null);
		Assert.assertEquals(financialOrganization.getCreatedAt(), new DateTime(
				2007, 5, 26, 13, 27, 39, 0, DateTimeZone.UTC));
		Assert.assertEquals(financialOrganization.getUpdatedAt(), new DateTime(
				2010, 3, 26, 4, 2, 20, 0, DateTimeZone.UTC));
	}

	@Test
	public void getPerson() {
		Person person = getAPI().getPerson("brad-fitzpatrick");

		Assert.assertEquals(person.getFirstName(), "Brad");
		Assert.assertEquals(person.getLastName(), "Fitzpatrick");
		Assert.assertEquals(person.getPermalink(), "brad-fitzpatrick");
		Assert.assertEquals(person.getCrunchbaseUrl(),
				"http://www.crunchbase.com/person/brad-fitzpatrick");
		Assert.assertEquals(person.getHomepageUrl(), "http://bradfitz.com");
		Assert.assertEquals(person.getBirthplace(), "Iowa");
		Assert.assertEquals(person.getTwitterUsername(), null);
		Assert.assertEquals(person.getBlogUrl(), "http://brad.livejournal.com");
		Assert.assertEquals(person.getBlogFeedUrl(),
				"http://brad.livejournal.com/data/rss");
		Assert.assertEquals(person.getAffiliationName(), "LiveJournal");
		Assert.assertEquals(person.getBorn(), new LocalDate(1980, 2, 5));
		Assert.assertEquals(person.getTags().size(), 0);
		Assert.assertEquals(person.getAliases().size(), 0);
		Assert.assertEquals(person.getCreatedAt(), new DateTime(2007, 12, 9,
				14, 29, 2, 0, DateTimeZone.UTC));
		Assert.assertEquals(person.getUpdatedAt(), new DateTime(2010, 3, 16, 7,
				0, 19, 0, DateTimeZone.UTC));
	}

	@Test
	public void getPersons() {
		List<PersonShort> persons = getAPI().getPersons();

		Assert.assertTrue(persons.size() > 50000);
		Assert.assertNotNull(persons.get(0).getFirstName());
		Assert.assertNotNull(persons.get(0).getLastName());
		Assert.assertNotNull(persons.get(0).getPermalink());
	}
}
