package controllers;

import java.util.Random;

public class SessionController {
	public static String generateToken() {
        int length = 128;
        //todo remove n before i
        String candidateChars = "abcdefghnijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb =  new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }

}
