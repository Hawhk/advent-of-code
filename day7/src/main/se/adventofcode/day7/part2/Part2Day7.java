package se.adventofcode.day7.part2;

import java.lang.System.Logger;

public class Part2Day7 {

	private static final Logger LOGGER = System.getLogger(Part2Day7.class.getName());

    public static void main(String[] args) {
		LOGGER.log(Logger.Level.INFO, "Starting " + Part2Day7.class.getSimpleName());
        Solver2 solver = new Solver2("input.txt");

        LOGGER.log(Logger.Level.INFO, "Result: " + solver.solve());
    }
}
