package com.student.management.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.env.AbstractEnvironment;

import com.student.management.StudentManagementApplication;

public class ApplicationConstants {
	static Properties prop = new Properties();
	static {
		try {
			prop.load(StudentManagementApplication.class.getClassLoader().getResourceAsStream("constant.properties"));
		} catch (IOException ex) {
		}
	}

	static Properties properties = new Properties();

	static {
		try {
			properties.load(StudentManagementApplication.class.getClassLoader()
					/**
					 * .getResourceAsStream("config/application-" + "dev" + ".properties"));
					 */
					.getResourceAsStream("config/application-"
							+ System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME) + ".properties"));
		} catch (IOException ex) {
		}
	}
	public static final String HEADER_USERID = prop.getProperty("HEADER_USERID");

	public static final String AUDITABLE_ADMIN_USER = prop.getProperty("AUDITABLE_ADMIN_USER");

	public static final String CREATE_RECORD_SUCESS = prop.getProperty("CREATE_RECORD_SUCESS");

	public static final String DCO = prop.getProperty("DCO");

	public static final String UPDATE_RECORD_SUCESS = prop.getProperty("UPDATE_RECORD_SUCESS");

	public static final String DELETE_RECORD_SUCESS = prop.getProperty("DELETE_RECORD_SUCESS");

	public static final String FETCH_RECORD_SUCESS = prop.getProperty("FETCH_RECORD_SUCESS");

	public static final String CREATE_RECORD_FAILED = prop.getProperty("CREATE_RECORD_FAILED");

	public static final String UPDATE_RECORD_FAILED = prop.getProperty("UPDATE_RECORD_FAILED");

	public static final String DELETE_RECORD_FAILED = prop.getProperty("DELETE_RECORD_FAILED");

	public static final String FETCH_RECORD_FAILED = prop.getProperty("FETCH_RECORD_FAILED");

	public static final String EXCEPTION_OCCURED = prop.getProperty("EXCEPTION_OCCURED");

	public static final String SERVER_ERROR = prop.getProperty("SERVER_ERROR");

	public static final String BAD_REQUEST = prop.getProperty("BAD_REQUEST");

	public static final String HEADER_AUTH = prop.getProperty("HEADER_AUTH");

	public static final String UNAUTHRIZED_USER_MSG = prop.getProperty("UNAUTHRIZED_USER_MSG");

	public static final String RES_STATUS_SUCCESS = prop.getProperty("RES_STATUS_SUCCESS");

	public static final String RES_STATUS_ERROR = prop.getProperty("RES_STATUS_ERROR");

	public static final Integer ACTIVE = Integer.parseInt(prop.getProperty("ACTIVE"));

	public static final Integer IN_ACTIVE = Integer.parseInt(prop.getProperty("IN_ACTIVE"));

	public static final Integer ZERO = Integer.parseInt(prop.getProperty("ZERO"));

	public static final String NO_PARENT_RECORD = prop.getProperty("NO_PARENT_RECORD");

	public static final String ACTIVE_STATUS = prop.getProperty("ACTIVE_STATUS");

	public static final String IN_ACTIVE_STATUS = prop.getProperty("IN_ACTIVE_STATUS");

	public static final String YES = prop.getProperty("YES");

	public static final String NO = prop.getProperty("NO");

	public static final String NA = prop.getProperty("NA");

	public static final String EMAIL_ALREADY_EXISTS = prop.getProperty("EMAIL_ALREADY_EXISTS");

	public static final String USER_ALREADY_EXISTS = prop.getProperty("USER_ALREADY_EXISTS");

	public static final String MOBILE_NUMBER_ALREADY_EXISTS = prop.getProperty("MOBILE_NUMBER_ALREADY_EXISTS");

	public static final String USER_NOT_VALID = prop.getProperty("USER_NOT_VALID");

	public static final String OTP_NOT_VALID = prop.getProperty("OTP_NOT_VALID");

	public static final String USER_VALID = prop.getProperty("USER_VALID");

	public static final String ROLE_ALREADY_EXISTS = prop.getProperty("ROLE_ALREADY_EXISTS");

	public static final Boolean TRUE = Boolean.parseBoolean(prop.getProperty("TRUE"));

	public static final Boolean FALSE = Boolean.parseBoolean(prop.getProperty("FALSE"));

	public static final Integer SUCCESS_STATUS = Integer.parseInt(prop.getProperty("SUCCESS_STATUS"));

	public static final Integer FAIL_STATUS = Integer.parseInt(prop.getProperty("FAIL_STATUS"));

	public static final String NAME_PATTERN_FOR_ORGANIZATIONS = prop.getProperty("NAME_PATTERN_FOR_ORGANIZATIONS");

	public static final String NAME_PATTERN = prop.getProperty("NAME_PATTERN");

	public static final String MOBILE_PATTERN = prop.getProperty("MOBILE_PATTERN");

	public static final String SHORT_CODE_PATTERN = prop.getProperty("SHORT_CODE_PATTERN");

	public static final String EMAIL_PATTERN = prop.getProperty("EMAIL_PATTERN");

	public static final String RBI_CODE_PATTERN = prop.getProperty("RBI_CODE_PATTERN");

	public static final String SYLLABUS = prop.getProperty("SYLLABUS");

	public static final String SYLLABUS_EXIST = prop.getProperty("SYLLABUS_EXIST");

}