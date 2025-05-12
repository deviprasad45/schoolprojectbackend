package com.student.management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonFunctionUtil {

	private static final Logger log = LoggerFactory.getLogger(CommonFunctionUtil.class);

	public static String getCurrentMethodName() {
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[2].getClassName());
		sb.append("::");
		sb.append(Thread.currentThread().getStackTrace()[2].getMethodName());
		return sb.toString();
	}

	/**
	 * @author navya sree.
	 * @usage for Date conversions to long type timestamp .
	 */
	public static Long getTimeStamp() {
		return Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
	}

	public static Long getCurrentDateWithoutTime() {

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);

		return cal.getTimeInMillis();
	}

	/**
	 * @author navya sree.
	 * @usage generate token key by user name,current time .
	 */
	public static String getTokenKey(String email) {
		StringBuilder tokenkey = new StringBuilder();
		tokenkey.append(email);
		tokenkey.append(getTimeStamp());

		return tokenkey.toString();
	}

	public static byte[] convertStringToBlob(String input) {
		byte[] byteConent = null;
		if (null != input) {
			byteConent = input.getBytes();
		}
		return byteConent;
	}

	public static String convertBlobToString(byte[] bdata) {
		String result = null;
		if (null != bdata) {
			result = new String(bdata);
		}
		return result;
	}

	public static Long getTimeByDate(String date) throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormatter.parse(date));
		return cal.getTimeInMillis();
	}

	public static Boolean namePatternForOrganizations(String name) {
		Pattern pattern = Pattern.compile(ApplicationConstants.NAME_PATTERN_FOR_ORGANIZATIONS);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	public static Boolean namePattern(String name) {
		Pattern pattern = Pattern.compile(ApplicationConstants.NAME_PATTERN);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	public static Boolean mobilePattern(String name) {
		Pattern pattern = Pattern.compile(ApplicationConstants.MOBILE_PATTERN);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	public static Boolean shortCodePattern(String code) {
		Pattern pattern = Pattern.compile(ApplicationConstants.SHORT_CODE_PATTERN);
		Matcher matcher = pattern.matcher(code);
		return matcher.find();
	}

	public static Boolean emailPattern(String email) {
		Pattern pattern = Pattern.compile(ApplicationConstants.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	public static Boolean rbiCodePattern(String code) {
		Pattern pattern = Pattern.compile(ApplicationConstants.RBI_CODE_PATTERN);
		Matcher matcher = pattern.matcher(code);
		return matcher.find();
	}

	public static Long getDayStrartByDate(long date) {

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		if (date != 0)
			cal.setTimeInMillis(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTimeInMillis();
	}

	public static Long getDayEndByDate(long date) {

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		if (date != 0)
			cal.setTimeInMillis(date);

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTimeInMillis();
	}

	public static String generateRandomNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		// Generate the first digit to ensure it's not 0
		sb.append(random.nextInt(9) + 1);

		// Generate the rest of the 9 digits
		for (int i = 0; i < 9; i++) {
			sb.append(random.nextInt(10));
		}

		return sb.toString();
	}

}
