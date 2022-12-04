package se.adventofcode.day0.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver1 {

    private static final Logger LOGGER = System.getLogger(Solver1.class.getName());
    private static final String testResult = "";

    private String fileName;

    public Solver1(String fileName) {
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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return input;
    }

    public String getTestResult() {
        return testResult;
    }
}