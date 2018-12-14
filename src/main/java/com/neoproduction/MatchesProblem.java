package com.neoproduction;

/**
 * Created by NuclearSnake 14.12.18 at 20:45
 *
 * A class suited for a specific matches problem input-output management
 * @see InputManager
 * @see MatchesCounter
 */
public class MatchesProblem {
    static int ERROR = Integer.MIN_VALUE;

    private InputManager inputManager;
    private MatchesCounter matchesCounter;

    private int numberOfSquares = ERROR;

    public MatchesProblem(InputManager inputManager, MatchesCounter matchesCounter) {
        this.inputManager = inputManager;
        this.matchesCounter = matchesCounter;
    }

    /**
     * @return number of squares that was parsed from the latest user input
     */
    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    /**
     * main loop of the class, where it gets user input, processes it tries to get the result
     * @return the result of calculation or {@link MatchesProblem#ERROR}
     */
    public int loop(){
        String input;
        numberOfSquares = ERROR;

        input = inputManager.getInput("Number of squares: ");
        if("q".equals(input)) {
            System.out.println("\n\nBye!");
            System.exit(0);
        }

        numberOfSquares = tryToParseInput(input);
        if(numberOfSquares == ERROR)
            return ERROR;

        if(!isValidNumber(numberOfSquares)) {
            System.out.println("Invalid input :(");
            return ERROR;
        }

        matchesCounter.setSquaresRequired(numberOfSquares);
        return matchesCounter.countMatches();
    }

    /**
     * Parses integer from the input string
     * @param input from user
     * @return integer or {@link MatchesProblem#ERROR}
     */
    protected int tryToParseInput(String input){
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException nfe){
            System.out.println("Error! Input is not a number.");
            return ERROR;
        }
    }

    /**
     * Checks if the integer input is valid for the current task
     * @param input from user
     * @return true if the input is valid, false otherwise
     */
    protected boolean isValidNumber(int input){
        return input >= 0;
    }
}
