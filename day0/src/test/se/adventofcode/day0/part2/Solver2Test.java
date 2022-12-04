package se.adventofcode.day0.part2;

import org.junit.jupiter.api.Test;

import se.adventofcode.day0.part1.Solver1;
import se.adventofcode.day0.part2.Solver2;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solver2Test {

    Solver2 solver = new Solver2("test-input.txt");

    @Test
    public void solvePart2Test() {
        assertEquals(solver.getTestResult(), solver.solve());
    }
}