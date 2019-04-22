package com.codecool.acsbencetamas.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private static final String TEST_FILE_PATH = "tests/com/codecool/acsbencetamas/utils/simpleTestFile.txt";

    @Test
    public void testGettingWordsOrderedAlphabetically() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(TEST_FILE_PATH,1,10);

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

}