package com.student.management.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Component
 */

public class PasswordDecryption {
	private static final Logger logger = LoggerFactory.getLogger(PasswordDecryption.class);
	private static SecretKeySpec secretKey;

	private static String passPhrase = "aoadpq=-o098009-09345gksdfmsd";

	private PasswordDecryption() {
		throw new UnsupportedOperationException();
	}

	public static void setKey(String myKey) {
		byte[] key;

		try {
			/**
			 * key = myKey.getBytes("UTF-8");
			 */
			key = myKey.getBytes(StandardCharsets.UTF_8);

			// Get the instance of MD5.
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Get the hashed bytes of password.
			key = md.digest(key);

			// padding the copy of same length
			key = Arrays.copyOf(key, 16);

			// key data and algorithm specific
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException nsal) {
			nsal.printStackTrace();
		}
	}

	public static String decrypt(String strToDecrypt) {
		try {
			setKey(passPhrase);
			/**
			 * Cipher cipher = Cipher.getInstance("AES");
			 */
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			// initialize the cipher
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			// encode the password using base
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			/**
			 * System.out.println("Error while decrypting: " + e.toString());
			 **/
			logger.error("Error while decrypting", e);
		}
		return null;
	}

}
