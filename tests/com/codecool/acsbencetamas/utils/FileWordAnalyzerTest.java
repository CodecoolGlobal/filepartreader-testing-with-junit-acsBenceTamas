package com.codecool.acsbencetamas.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private static final String SIMPLE_TEST_FILE_PATH = "tests/com/codecool/acsbencetamas/utils/simpleTestFile.txt";
    private static final String PALINDROME_TEST_FILE_PATH = "tests/com/codecool/acsbencetamas/utils/palindromeTestFile.txt";

    @Test
    public void testGettingWordsOrderedAlphabetically() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(SIMPLE_TEST_FILE_PATH,1,10);

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

        assertEquals(new ArrayList<>(
                Arrays.asList(
                            "eight",
                            "five",
                            "four",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "nine",
                            "one",
                            "seven",
                            "six",
                            "ten",
                            "three",
                            "two"
                        )),
                fwa.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGettingPalindromes() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(PALINDROME_TEST_FILE_PATH,1,3);

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

        assertEquals(new ArrayList<>(
                Arrays.asList(
                            "racecar",
                            "mom",
                            "dad"
                        )),
                fwa.getStringsWhichArePalindromes());
    }

    @Test
    public void testGettingWordsWithSubstrings() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(SIMPLE_TEST_FILE_PATH,1,10);

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

        assertEquals(new ArrayList<>(
                Arrays.asList(
                            "seven",
                            "ten"
                        )),
                fwa.getWordsContainingSubstring("en"));

        assertEquals(new ArrayList<>(
                Arrays.asList(
                            "line",
                            "one",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "line",
                            "nine",
                            "line"
                        )),
                fwa.getWordsContainingSubstring("ne"));
    }

}