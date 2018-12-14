package com.neoproduction;

import java.util.Scanner;

/**
 * Created by NuclearSnake 14.12.18 at 20:12
 *
 * Gets user input with via standard input/output streams
 */
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
