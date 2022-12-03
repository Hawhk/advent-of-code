package se.adventofcode.day2.part2;

public class Part2Day2 {
    public static void main(String[] args) {
        System.out.println(Part2Day2.class.getSimpleName());
        Solver2 solver = new Solver2("input.txt");

        System.out.println("Result: " + solver.solve());
    }
}
