package com.codecool.acsbencetamas.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

        List<String> lines = new ArrayList<>();

        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        return String.join("\n",lines);
    }

    public String readLines() throws FileNotFoundException {
        int currentLine = 1;
        File file = new File(filePath);
        Scanner in = new Scanner(file);

        List<String> lines = new ArrayList<>();
        while (currentLine < fromLine) {
            if (in.hasNextLine()) {
                in.nextLine();
                currentLine ++;
            } else {
                break;
            }
        }
        while (currentLine <= toLine) {
            if (in.hasNextLine()) {
                lines.add(in.nextLine());
                currentLine ++;
            } else {
                break;
            }
        }
        return String.join("\n",lines);
    }
}
