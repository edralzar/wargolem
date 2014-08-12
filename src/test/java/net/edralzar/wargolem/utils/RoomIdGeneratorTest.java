package net.edralzar.wargolem.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.Test;

public class RoomIdGeneratorTest {

    private static Pattern THREE_MORE_VOWELS = Pattern.compile("[aeiouy]{3,}");
    private static Pattern TWO_MORE_CONSONANTS = Pattern.compile("[bcdfghjklmnpqrstvwxz]{2,}");

    @Test
    public void testGenerateReadableID() throws Exception {
        for(int i = 0 ; i < 1000 ; i++) {
            String id = RoomIdGenerator.generateReadableID(8);
            assertThat(THREE_MORE_VOWELS.matcher(id).find()).as("more than two vowels in a row in test id %s", id).isFalse();
            assertThat(TWO_MORE_CONSONANTS.matcher(id).find()).as("more than one consonant in a row in test id %s", id).isFalse();
        }
    }
}