package com.codecool.acsbencetamas.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "";
        fromLine = 0;
        toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1 || fromLine > toLine) throw new IllegalArgumentException("Lower bound can not be lower than 1 and upper bound can not be lower than lower bound");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws FileNotFoundException {
        File file = new File(filePath);
        Scanner in = new Scanner(file);

        StringBuilder sb = new StringBuilder();

        while (in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        return sb.toString();
    }

    public String readLines() throws FileNotFoundException {
        int currentLine = 1;
        File file = new File(filePath);
        Scanner in = new Scanner(file);

        StringBuilder sb = new StringBuilder();
        while (currentLine < fromLine) {
            if (in.hasNextLine()) {
                in.nextLine();
            } else {
                break;
            }
        }
        while (currentLine <= toLine) {
            if (in.hasNextLine()) {
                sb.append(in.nextLine());
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
