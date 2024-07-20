package com.home.whatever;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    @Override
    public String[] readStrings() {
        Scanner console = new Scanner(System.in);
        String[] strings = new String[6];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = console.nextLine();
        }
        return strings;
    }
}
