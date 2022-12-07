package se.adventofcode.day8.part1;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Part1Day8 {

    private static final Logger LOGGER = System.getLogger(Part1Day8.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Starting " + Part1Day8.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        LOGGER.log(Level.INFO, "Result: " + solver.solve());
    }
}
