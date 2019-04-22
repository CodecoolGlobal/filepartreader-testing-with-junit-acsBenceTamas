package com.codecool.acsbencetamas.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List getWordsOrderedAlphabetically () {
        List<String> list = null;
        try {
            list = new ArrayList<>(Arrays.asList(reader.readLines().split(" \n")));
            Collections.sort(list);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
