package com.teksystems.schooldatabase.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;


public class EmailValidation {
	
	private static final String EMAIL_FORMAT = "/([a-zA-Z0-9]+)@([a-zA-Z0-9]+).([a-zA-Z]){3}/";
	private static final String PHONE_NUMBER_FORMAT = "/\\d{3}-\\d{3}-\\d{4}/";
	private static final Pattern pattern = Pattern.compile(EMAIL_FORMAT);
	private static final Pattern phonePattern = Pattern.compile(PHONE_NUMBER_FORMAT);
	
	public boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		
		Matcher matcher = pattern.matcher(email);
        return matcher.matches();
		
//		if (StringUtils.isNullOrEmpty(email)) {
//			return false;
//		}
//		
//		if (!email.contains("@"))
//			return false; 
//		
//		if (!email.contains(".")) {
//			return false;
//		}
//		
//		char[] front = email.split("@")[0].toCharArray();
//		
//		for (char c: front) {
//			if(!Character.isLetterOrDigit(c)) {
//				return false;
//			}
//		}
//		
//		String[] firstSplit = email.split("\\.");
//		char[] back = firstSplit[firstSplit.length - 1].toCharArray();
//	
//		if (back.length != 3) {
//			return false;
//		}
//		
//		for (char c: back) {
//			if (!Character.isLetter(c)) {
//				return false;
//			}
//		}
//		
//		return true;
	}
	
	public boolean isPhoneNumberValid(String phoneNumber) {
		if (StringUtils.isEmpty(phoneNumber) || phoneNumber == null) {
			return false;
		}
		
		if (!StringUtils.containsOnly(phoneNumber, "0123456789-. ")) {
			return false;
		}
		
		String number = RegExUtils.replaceAll(phoneNumber, "\\D", ""); 
		
		if (number.length() != 9) {
			return false;
		}
		
		if (StringUtils.startsWith(phoneNumber, "555")) {
			return false;
		}
		
		return true;
	}
}
