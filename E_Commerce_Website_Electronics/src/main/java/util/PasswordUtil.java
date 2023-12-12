package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;


public class PasswordUtil {
	public static String hashPassword(String password) {
        try {
            // Get SHA-1 message digest instance
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Update the digest with the password bytes
            md.update(password.getBytes());

            // Get the hashed password bytes
            byte[] hashedBytes = md.digest();

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception appropriately (e.g., log it or throw a runtime exception)
            throw new RuntimeException("Error hashing password", e);
        }
    }
	
}
