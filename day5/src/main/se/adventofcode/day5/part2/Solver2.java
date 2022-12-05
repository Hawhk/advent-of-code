package se.adventofcode.day5.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
    private static final String TEST_RESULT = "";

    private String fileName;

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
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
            LOGGER.log(Logger.Level.TRACE, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }
}