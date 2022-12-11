package se.adventofcode.day0.part1;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Part1Day0 {

    private static final Logger LOGGER = System.getLogger(Part1Day0.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Starting " + Part1Day0.class.getSimpleName());
        Solver solver = new Solver("input.txt");

        LOGGER.log(Level.INFO, "Result: " + solver.solve());
    }
}
