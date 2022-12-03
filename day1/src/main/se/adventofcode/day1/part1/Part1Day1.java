package se.adventofcode.day1.part1;

public class Part1Day1 {
    public static void main(String[] args) {
        System.out.println(Part1Day1.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        System.out.println("Result: " + solver.solve());
    }
}
