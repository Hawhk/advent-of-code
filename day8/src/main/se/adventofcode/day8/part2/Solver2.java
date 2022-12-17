package se.adventofcode.day8.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
    private static final String TEST_RESULT = "8";

    private String fileName;

    public Solver2(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
    }

    private String solution(List<String> data) {

        List<List<Integer>> trees = new ArrayList<>();
		List<List<Integer>> canBeSeen = new ArrayList<>();

        data.stream().forEach(row -> {
			canBeSeen.add(new ArrayList<>());
            trees.add(Arrays.asList(row.split("")).stream().map(tree -> {
				canBeSeen.get(canBeSeen.size() - 1).add(1);
                return Integer.parseInt(tree);
            }).toList());
        });

        findVisibleTrees(canBeSeen, trees, 1, false);
		findVisibleTrees(canBeSeen, trees, -1, false);
		findVisibleTrees(canBeSeen, trees, 1, true);
		findVisibleTrees(canBeSeen, trees, -1, true);
		return canBeSeen.stream().map(row -> row.stream().max(Integer::compare).orElseThrow()).max(Integer::compare)
				.orElseThrow().toString();
    }

	private void findVisibleTrees(List<List<Integer>> viewList, List<List<Integer>> trees, int direction,
            boolean vertical) {
		int startIndex = 0;
		int endIndex = trees.get(0).size();
        if (direction == -1) {
			startIndex = trees.get(0).size() - 1;
			endIndex = -1;
        }

		for (int i = 0; i < trees.get(0).size(); i++) {
			int highestTree = -1;
			for (int j = startIndex; j != endIndex; j += direction) {

				int foundHighest;
				int lengthToStart;
				if (startIndex == 0) {
					lengthToStart = j;
				} else {
					lengthToStart = startIndex - j;
				}

                if (vertical) {
					foundHighest = checkTreeIsVisible(viewList, trees, j, i, highestTree, lengthToStart, direction,
							vertical);
                } else {
					foundHighest = checkTreeIsVisible(viewList, trees, i, j, highestTree, lengthToStart, direction,
							vertical);
                }

				if (foundHighest >= highestTree) {
					highestTree = foundHighest;
				}
            }
        }
    }

	private int checkTreeIsVisible(List<List<Integer>> viewList, List<List<Integer>> trees, int row, int column,
			int highestTree, int lengthToStart, int direction, boolean vertical) {

		if (row == trees.size() - 1 || row == 0 || column == trees.size() - 1 || column == 0) {
			return trees.get(row).get(column);
		}

		int treesSeen;
		if (trees.get(row).get(column) > highestTree) {
			treesSeen = lengthToStart;
		} else {
			int r = row;
			int c = column;
			treesSeen = 0;
			for (int i = 1; i <= lengthToStart; i++) {
				if (vertical) {
					r -= direction;
				} else {
					c -= direction;
				}
				treesSeen++;
				if (trees.get(r).get(c) >= trees.get(row).get(column)) {
					break;
				}
			}
			if (treesSeen == 0) {
				treesSeen = 1;
			}
        }
		viewList.get(row).set(column, viewList.get(row).get(column) * treesSeen);

		return trees.get(row).get(column);
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