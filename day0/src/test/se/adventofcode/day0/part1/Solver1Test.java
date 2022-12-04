package se.adventofcode.day0.part1;

import org.junit.jupiter.api.Test;

import se.adventofcode.day0.part1.Solver1;
import se.adventofcode.day0.part2.Solver2;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solver1Test {

    Solver1 solver = new Solver1("test-input.txt");

    @Test
    public void solvePart1Test() {
        assertEquals(solver.getTestResult(), solver.solve());
    }
}