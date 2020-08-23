package com.employeeapi.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String authorName()
	{
		String generateString=RandomStringUtils.randomAlphabetic(1);
		return ("Ramana"+generateString);
	}
	public static String titleBook()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return ("Book"+generateString);
	}

}
