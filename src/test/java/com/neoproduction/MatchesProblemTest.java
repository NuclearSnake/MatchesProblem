package com.neoproduction;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchesProblemTest {
    @Test
    public void tryToParseInput_Text() {
        assertEquals(MatchesProblem.ERROR, new MatchesProblem(null, null).tryToParseInput("text"));
    }

    @Test
    public void tryToParseInput_Negative() {
        assertEquals(-1, new MatchesProblem(null, null).tryToParseInput("-1"));
    }

    @Test
    public void tryToParseInput_Positive() {
        assertEquals(42, new MatchesProblem(null, null).tryToParseInput("42"));
    }


    @Test
    public void isValidNumber_Negative() {
        assertFalse(new MatchesProblem(null, null).isValidNumber(-1));
    }
    @Test
    public void isValidNumber_Zero() {
        assertTrue(new MatchesProblem(null, null).isValidNumber(0));
    }
    @Test
    public void isValidNumber_Positive() {
        assertTrue(new MatchesProblem(null, null).isValidNumber(1));
    }

    @Test
    public void loop_ValidDataGivesSameResultAsMatchesProblem() {
        assertTrue(doesMatchesProblemResultEqualsMatchesCounterResult(0));
        assertTrue(doesMatchesProblemResultEqualsMatchesCounterResult(1));
        assertTrue(doesMatchesProblemResultEqualsMatchesCounterResult(3));
        assertTrue(doesMatchesProblemResultEqualsMatchesCounterResult(5));
        assertTrue(doesMatchesProblemResultEqualsMatchesCounterResult(32));
    }

    @Test
    public void loop_InvalidDataFails() {
        assertEquals(MatchesProblem.ERROR, getMatchesProblemLoopResult("-1"));
    }

    private boolean doesMatchesProblemResultEqualsMatchesCounterResult(int numberOfSquares){
        int matchesProblemResult = getMatchesProblemLoopResult(Integer.toString(numberOfSquares));
        int matchesCounterResult = new MatchesCounter(numberOfSquares).countMatches();

        return matchesProblemResult == matchesCounterResult;
    }

    private int getMatchesProblemLoopResult(String input){
        return new MatchesProblem(new InputManager() {
            @Override
            String getInputRealization() {
                return input;
            }
        }, new MatchesCounter()).loop();
    }
}