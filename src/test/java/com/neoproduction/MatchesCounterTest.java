package com.neoproduction;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchesCounterTest {

    @Test (expected = IllegalArgumentException.class)
    public void howManyMatchesDoINeedToBuildSquares_Negative() {
        new MatchesCounter(-1).countMatches();
    }

    @Test
    public void howManyMatchesDoINeedToBuildSquares_0() {
        assertEquals(0, new MatchesCounter(0).countMatches());
    }

    @Test
    public void howManyMatchesDoINeedToBuildSquares_1() {
        assertEquals(4, new MatchesCounter(1).countMatches());
    }

    @Test
    public void howManyMatchesDoINeedToBuildSquares_Small() {
        assertEquals(10, new MatchesCounter(3).countMatches());
    }

    @Test
    public void howManyMatchesDoINeedToBuildSquares_Medium() {
        assertEquals(15, new MatchesCounter(5).countMatches());
    }

    @Test
    public void howManyMatchesDoINeedToBuildSquares_Big() {
        assertEquals(76, new MatchesCounter(32).countMatches());
    }
}