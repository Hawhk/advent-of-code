package se.adventofcode.day0.part2;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Part2Day0 {

    private static final Logger LOGGER = System.getLogger(Part2Day0.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Starting " + Part2Day0.class.getSimpleName());
        Solver solver = new Solver("input.txt");

        LOGGER.log(Level.INFO, "Result: " + solver.solve());
    }
}
