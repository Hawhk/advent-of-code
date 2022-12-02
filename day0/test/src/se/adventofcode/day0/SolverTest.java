package src.se.adventofcode.day0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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