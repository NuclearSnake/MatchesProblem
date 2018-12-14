package com.neoproduction;

import java.util.Scanner;

public class InputManagerImpl extends InputManager {
    Scanner reader;
    public InputManagerImpl() {
        reader = new Scanner(System.in);
    }

    @Override
    String getInputRealization() {
        return reader.next();
    }

    @Override
    void print(String prompt) {
        System.out.print(prompt);
    }
}
