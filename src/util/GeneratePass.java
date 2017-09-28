package util;

import java.util.Random;

public class GeneratePass {

	public static String getSaltString() {
        String SALTCHARS = "0123456789abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMNOPQRSTVWXWZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
