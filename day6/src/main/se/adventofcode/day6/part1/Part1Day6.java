package se.adventofcode.day6.part1;

import java.lang.System.Logger;

public class Part1Day6 {

    private static final Logger LOGGER = System.getLogger(Part1Day6.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Logger.Level.INFO, "Starting " + Part1Day6.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        LOGGER.log(Logger.Level.INFO, "Result: " + solver.solve());
    }
}
