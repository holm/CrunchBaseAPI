package com.podio.crunchbaseapi;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class DateTimeUtil {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat
			.forPattern("EEE MMM dd HH:mm:ss 'UTC' yyyy")
			.withZone(DateTimeZone.UTC).withLocale(new Locale("en"));

	private DateTimeUtil() {
	}

	public static DateTime parseDateTime(String text) {
		return DATE_TIME_FORMAT.parseDateTime(text);
	}

	public static String formatDateTime(DateTime dateTime) {
		return DATE_TIME_FORMAT.print(dateTime);
	}

	public static void main(String[] args) {
		System.out.println(formatDateTime(new DateTime(2007, 5, 25, 23, 22, 15,
				0)));
		System.out.println(parseDateTime("Fri May 25 21:22:15 UTC 2007"));
	}
}
