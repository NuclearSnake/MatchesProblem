package com.neoproduction;

public abstract class InputManager {
    abstract String getInputRealization();
    void print(String prompt){}

    final public String getInput(String prompt){
        print(prompt);
        return getInputRealization();
    }
}
