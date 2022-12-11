package se.adventofcode.day8.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solver1 {

    private static final Logger LOGGER = System.getLogger(Solver1.class.getName());
    private static final String TEST_RESULT = "21";

    private String fileName;

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {

        List<List<Integer>> trees = new ArrayList<>();
        List<List<Boolean>> canBeSeen = new ArrayList<>();

        data.stream().forEach(row -> {
            canBeSeen.add(new ArrayList<>());
            trees.add(Arrays.asList(row.split("")).stream().map(tree -> {
                canBeSeen.get(canBeSeen.size() - 1).add(false);
                return Integer.parseInt(tree);
            }).toList());
        });

        LOGGER.log(Level.INFO, trees);

        findVisibleTrees(canBeSeen, trees, 1, false);
        findVisibleTrees(canBeSeen, trees, -1, false);
        findVisibleTrees(canBeSeen, trees, 1, true);
        findVisibleTrees(canBeSeen, trees, -1, true);

        return canBeSeen.stream().map(row -> row.stream().filter(val -> val).count()).reduce(0L, Long::sum)
                .toString();
    }

    private void findVisibleTrees(List<List<Boolean>> trueList, List<List<Integer>> trees, int direction,
            boolean vertical) {
        int x = 0;
        int y = trees.get(0).size();
        if (direction == -1) {
            x = trees.get(0).size() - 1;
            y = -1;
        }

        for (int i = 0; i < trees.get(0).size(); i++) {
            int highestTree = -1;
            for (int j = x; j != y; j += direction) {

                if (vertical) {
                    highestTree = checkTreeIsVisible(trueList, trees, j, i, highestTree);
                } else {
                    highestTree = checkTreeIsVisible(trueList, trees, i, j, highestTree);
                }
            }
        }
    }

    private int checkTreeIsVisible(List<List<Boolean>> trueList, List<List<Integer>> trees, int i,
            int j, int highestTree) {
        if (trees.get(i).get(j) > highestTree) {
            if (!trueList.get(i).get(j).booleanValue()) {
                trueList.get(i).set(j, true);
            }
            highestTree = trees.get(i).get(j);
        }

        return highestTree;
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
            LOGGER.log(Logger.Level.ERROR, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }
}