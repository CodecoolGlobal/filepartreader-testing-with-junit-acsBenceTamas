package com.codecool.acsbencetamas.utils;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private static final String TEST_FILE_PATH = "tests/com/codecool/acsbencetamas/utils/simpleTestFile.txt";

    @Test
    public void testCanDoValidSetup() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,1,1);
    }

    @Test
    public void testFromLineLowerThanOneThrowsException() {
        FilePartReader fpr = new FilePartReader();

        assertThrows(IllegalArgumentException.class,() ->
                fpr.setup(TEST_FILE_PATH,0,1)
        );
    }

    @Test
    public void testToLineLowerThanFromLineThrowsException() {
        FilePartReader fpr = new FilePartReader();

        assertThrows(IllegalArgumentException.class,() ->
                fpr.setup(TEST_FILE_PATH,2,1)
        );
    }

    @Test
    public void testCanReadWholeFile() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,1,1);
        try {
            assertEquals("line one\n" +
                            "line two\n" +
                            "line three\n" +
                            "line four\n" +
                            "line five\n" +
                            "line six\n" +
                            "line seven\n" +
                            "line eight\n" +
                            "line nine\n" +
                            "line ten",
                    fpr.read()
                    );
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCanReadFirstLine() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,1,1);
        try {
            assertEquals("line one",
                    fpr.readLines());
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCanReadSingleLineInMiddle() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,5,5);
        try {
            assertEquals("line five",
                    fpr.readLines());
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCanReadPartsBeforeLastLine() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,2,5);
        try {
            assertEquals(
                    "line two\n" +
                            "line three\n" +
                            "line four\n" +
                            "line five",
                    fpr.readLines()
                    );
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCanReadPartsPastLastLine() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,8,15);
        try {
            assertEquals(
                    "line eight\n" +
                            "line nine\n" +
                            "line ten",
                    fpr.readLines()
                    );
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testReadingLinesAfterLastLineReturnsEmptyString() {
        FilePartReader fpr = new FilePartReader();

        fpr.setup(TEST_FILE_PATH,11,11);
        try {
            assertEquals("",
                    fpr.readLines());
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }
}