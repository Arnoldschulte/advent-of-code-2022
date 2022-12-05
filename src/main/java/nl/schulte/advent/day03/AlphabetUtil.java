package nl.schulte.advent.day03;

public class AlphabetUtil {

    private static final String ALPHABET_LOWER_UPPER_CASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int getPriority(char character) {
        return ALPHABET_LOWER_UPPER_CASE.indexOf(character) + 1;
    }
}
