package com.neoproduction;

import static com.neoproduction.MatchesProblem.ERROR;

/**
 * Created by NuclearSnake 14.12.18 at 19:56
 *
 * The main class, starts and manages the application. Using {@link MatchesProblem}, initializing it with
 * instances of {@link InputManager} and {@link MatchesCounter}, gets the result of solving the simple math
 * problem and prints it to the user
 *
 * @see InputManager
 * @see MatchesCounter
 */
public class Main {
    public static void main(String[] args){
        System.out.println("This is a matches counter app. You enter the number of squares 1x1 you want, the program " +
                "responds with a minimum number of matches that can do.\n" +
                "[Matches can't be broken and can't be placed in 3D]\n" +
                "Print 'q' to quit\n");
        MatchesProblem matchesProblem = new MatchesProblem(new InputManagerImpl(), new MatchesCounter());
        do{
            int result = matchesProblem.loop();
            if(result == ERROR)
                continue;
            System.out.println(String.format("Minimum number of matches to build %d 1x1 squares in 2D is %d", matchesProblem.getNumberOfSquares(), result));
        } while (true);
    }
}
