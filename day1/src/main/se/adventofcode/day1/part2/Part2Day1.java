package se.adventofcode.day1.part2;

public class Part2Day1 {
    public static void main(String[] args) {
        System.out.println(Part2Day1.class.getSimpleName());
        Solver2 solver = new Solver2("input.txt");

        System.out.println("Result: " + solver.solve());
    }
}
