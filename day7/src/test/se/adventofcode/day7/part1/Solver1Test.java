package se.adventofcode.day7.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solver1Test {

    Solver1 solver = new Solver1("test-input.txt");

    @Test
    public void solvePart1Test() {
        assertEquals(solver.getTestResult(), solver.solve());
    }
}