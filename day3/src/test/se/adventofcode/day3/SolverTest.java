package se.adventofcode.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import se.adventofcode.day3.part1.Solver1;
import se.adventofcode.day3.part2.Solver2;

class SolverTest {

    Solver1 solver1 = new Solver1("test-input.txt");
    Solver2 solver2 = new Solver2("test-input.txt");

    @Test
    public void solve1() {
        assertEquals(solver1.getTestResult(), solver1.solve());
    }

    @Test
    public void solve2() {
        assertEquals(solver2.getTestResult(), solver2.solve());
    }
}