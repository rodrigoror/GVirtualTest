package br.com.rrlabs.guichevirtual;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

public class HelloWorld {

	@Inject
	private Logger logger;

	public void say() {
		//Questões Abertas

		//01 - How to replace...
		logger.info("01 - How to replace...");
		String a = "  aa bbbbb   ccc     d  ";
		String b;
		b =	replaceSpaces(a); 
		logger.info("Change from '"+a+"' to '"+b+"'"); //aa bbbbb ccc d
		
		//02 - Implement an algorithm ...
		logger.info("02 - Implement an algorithm ..."); 
		logger.info("isUnique(\"abc\")="+isUnique("abc")); //true
		logger.info("isUnique((\"abca\"))="+isUnique("abca"));//false
		
		//03 - Write a Method to decide...
		logger.info("03 - Write a Method to decide..."); 
		logger.info("isAnagram(\"sopa\",\"sapo\")="+isAnagram("sopa","sapo")); //true
		logger.info("isAnagram(\"abcc\",\"abcd\")="+isAnagram("abcc","abcd")); //false
		logger.info("isAnagram(\"america\",\"iracema\")="+isAnagram("america","iracema")); //true
		logger.info("isAnagram(\"soap\",\"apos\")="+isAnagram("soap","apos")); //true
		
		//04 - A program code will be writen only once...
		logger.info("04 - A program code will be writen only once..."); 
		logger.info("isValidEmail(\"rodrigoror@gmail.com\")="+isValidEmail("rodrigoror@gmail.com")); //true
		logger.info("isValidEmail(\"rodrigororAtgmail.com\")="+isValidEmail("rodrigororAtgmail.com")); //false
		logger.info("isValidEmail(\"rodrigoror@gmailcom\")="+isValidEmail("rodrigoror@gmailcom")); //false
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); //simple regex to email

	public static boolean isValidEmail(String emailStr) {
	        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
	        return matcher.find();
	}
	
	
	static boolean isAnagram(String s1, String s2)
    {
		boolean retorno = false;
		if (s1.length() == s2.length()) {
	        char[] s1AsChar = s1.toCharArray();
	        char[] s2AsChar = s2.toCharArray();
	        Arrays.sort(s1AsChar);
	        Arrays.sort(s2AsChar);
	        retorno = Arrays.equals(s1AsChar, s2AsChar);
	    } 
	    return retorno;
    }
	
	public static boolean isUnique(String str) {
	    if (str.length() > 256) {
	        return false;
	    }
	    int checker = 0;
	    for (int i = 0; i < str.length(); i++) {
	        int val = str.charAt(i) - 'a';
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	    }
	    return true;
	}
	
	private static String replaceSpaces(String a) {
		return StringUtils.normalizeSpace(a); //replace sequences of whitespaces
	}
}
