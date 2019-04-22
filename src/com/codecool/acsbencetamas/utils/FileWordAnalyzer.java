package com.codecool.acsbencetamas.utils;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        List<String> list = getWordListFromFile();
        Collections.sort(list);
        return list;
    }

    public List<String> getStringsWhichArePalindromes() {
        List<String> list = getWordListFromFile();
        return list.stream()
                .filter(FileWordAnalyzer::isPalindrome)
                .collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String subString ) {
        List<String> list = getWordListFromFile();
        return list.stream()
                .filter((word) -> word.toLowerCase().contains(subString.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<String> getWordListFromFile() {
        ArrayList<String> wordList = null;
        String[] words;
        try {
            words = reader.readLines().split("[.,;!? \n\t]");
            wordList = new ArrayList<>(Arrays.asList(words));
            wordList.removeIf((word) -> word.length() == 0); // This should not be necessary!
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    private static boolean isPalindrome(String word) {
        return word.equals(new StringBuffer(word).reverse().toString());
    }
}
