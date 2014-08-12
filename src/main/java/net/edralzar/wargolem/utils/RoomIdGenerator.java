package net.edralzar.wargolem.utils;

import java.util.Random;

public class RoomIdGenerator {

    private static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u', 'y' };
    private static final char[] CONSONANTS = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' };

    public static String generateReadableID(int size) {
        Random rng = new Random();
        StringBuilder id = new StringBuilder();
        int vowelCount = 1;
        for (int i = 0 ; i < size ; i++) {
            if (vowelCount == 0) {
                //when previously added a consonant, always take a vowel (no double consonants)
                id.append(VOWELS[rng.nextInt(VOWELS.length)]);
                vowelCount++;
            } else if (vowelCount == 1) {
                //25% chance to double vowels, otherwise take a consonant
                if (rng.nextInt(100) > 25) {
                    id.append(CONSONANTS[rng.nextInt(CONSONANTS.length)]);
                    vowelCount = 0;
                } else {
                    id.append(VOWELS[rng.nextInt(VOWELS.length)]);
                    vowelCount++;
                }
            } else {
                //always append a consonant after two vowels
                id.append(CONSONANTS[rng.nextInt(CONSONANTS.length)]);
                vowelCount = 0;
            }
        }
        return id.toString();
    }



}
