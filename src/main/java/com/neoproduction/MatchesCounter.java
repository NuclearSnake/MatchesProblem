package com.neoproduction;

/**
 * Created by NuclearSnake 14.12.18 at 20:14
 *
 * Counts matches needed for building n squares 1x1 in 2D
 */
public class MatchesCounter {
    private int squaresRequired = -1;
    private int currentMatches = 0;
    private int currentSquares = 0;

    public MatchesCounter() {}

    public MatchesCounter(int squaresRequired) {
        this.squaresRequired = squaresRequired;
    }

    /**
     * @param squaresRequired the value of squares in the problem
     */
    public void setSquaresRequired(int squaresRequired) {
        this.squaresRequired = squaresRequired;
    }

    /**
     * Counts matches for the task
     * @return number of matches
     */
    public int countMatches(){
        if(squaresRequired < 2){
            if(squaresRequired == 1)
                return 4;
            else if(squaresRequired == 0)
                return 0;
            else throw new IllegalArgumentException("numberOfSquares is negative or was not set");
        }

        currentMatches = 4;
        currentSquares = 1;
        for(int i = 0; currentSquares < squaresRequired; i++){
            addMatchesAndOneSquare(3);
            if(currentSquares == squaresRequired)
                return currentMatches;
            for(int j = 0; j < i; j++){
                addMatchesAndOneSquare(2);
                if(currentSquares == squaresRequired)
                    return currentMatches;
            }

            addMatchesAndOneSquare(3);
            if(currentSquares == squaresRequired)
                return currentMatches;
            for(int j = 0; j < i+1; j++){
                addMatchesAndOneSquare(2);
                if(currentSquares == squaresRequired)
                    return currentMatches;
            }
        }

        return currentMatches;
    }

    /**
     * Saves a bit of time understanding code that updates two values simultaneously
     * @param numberOfMatches that form that next square
     */
    private void addMatchesAndOneSquare(int numberOfMatches){
        currentMatches += numberOfMatches;
        currentSquares++;
    }
}
