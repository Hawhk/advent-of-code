package se.adventofcode.day8.part2;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Part2Day8 {

    private static final Logger LOGGER = System.getLogger(Part2Day8.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Starting " + Part2Day8.class.getSimpleName());
        Solver2 solver = new Solver2("input.txt");

        LOGGER.log(Level.INFO, "Result: " + solver.solve());
    }
}
