package se.adventofcode.day0.part2;

import java.lang.System.Logger;

import se.adventofcode.day0.part1.Part1Day0;
import se.adventofcode.day0.part1.Solver1;

public class Part2Day0 {

    private static final Logger LOGGER = System.getLogger(Part2Day0.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Logger.Level.INFO, "Starting " + Part1Day0.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        LOGGER.log(Logger.Level.INFO, "Result: " + solver.solve());
    }
}
