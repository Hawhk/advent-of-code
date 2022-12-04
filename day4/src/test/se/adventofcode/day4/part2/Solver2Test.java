package se.adventofcode.day4.part2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solver2Test {

    Solver2 solver = new Solver2("test-input.txt");

    @Test
    public void solvePart2Test() {
        assertEquals(solver.getTestResult(), solver.solve());
    }
}