package se.adventofcode.day9.part2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solver2Test {

	Solver solver = new Solver("test-input-2.txt");

    @Test
    public void solvePart2Test() {
        assertEquals(solver.getTestResult(), solver.solve());
    }
}