package se.adventofcode.day0.part1;


public class Part1Day0 {
    public static void main(String[] args) {
        System.out.println(Part1Day0.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        System.out.println("Result: " + solver.solve());
    }
}