package se.adventofcode.day0.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {

    private static final Logger LOGGER = System.getLogger(Solver.class.getName());
    private static final String TEST_RESULT = "";

    private String fileName;

    public Solver(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();
        long start = System.nanoTime();
        String result = solution(data);
        LOGGER.log(Level.INFO, "Took {0}ms", (System.nanoTime() - start) / 1_000_000);

        return result;
    }

    private String solution(List<String> data) {

        return null;
    }

    private List<String> getInput() {

        List<String> input = new ArrayList<>();

        try {
            File myObj = new File("input/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.TRACE, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }
}