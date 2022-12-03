package se.adventofcode.day2.part1;


public class Part1Day2 {
    public static void main(String[] args) {
        System.out.println(Part1Day2.class.getSimpleName());
        Solver1 solver = new Solver1("input.txt");

        System.out.println("Result: " + solver.solve());
    }
}
