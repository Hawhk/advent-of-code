package se.adventofcode.day7.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import se.adventofcode.day7.Directory;

public class Solver2 {

    private static final Logger LOGGER = System.getLogger(Solver2.class.getName());
	private static final String TEST_RESULT = "24933642";

	private Directory treeNode = null;
	private Directory parent = null;

    private String fileName;

	public Solver2(String fileName) {
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
		data.forEach(row -> {
			var cmd = row.split(" ");
			if (cmd[0].equals("$")) {
				if (cmd[1].equals("cd")) {
					treeNode = cd(treeNode, cmd[2]);
				}
			} else {
				add(treeNode, cmd);
			}
		});

		int neededSpace = 30_000_000 - (70_000_000 - parent.getSize());

		return parent.flaten().stream().map(Directory::getSize).filter(a -> a >= neededSpace).min(Integer::compare)
				.orElseThrow().toString();
	}

	private void add(Directory currentDir, String[] cmd) {

		if (cmd[0].equals("dir")) {
			currentDir.addDir(new Directory(currentDir, cmd[1]));
		} else {
			currentDir.addFiles(Integer.valueOf(cmd[0]));
		}

	}

	private Directory cd(Directory treeNode, String dir) {
		switch (dir) {
		case "/":
			if (parent == null) {
				parent = new Directory(treeNode, dir);
			}
			return parent;
		case "..":
			return treeNode.getParent();

		default:
			return treeNode.getDirs().stream().filter(cdDir -> cdDir.getName().equals(dir)).findFirst().orElseThrow();
		}

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