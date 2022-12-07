package se.adventofcode.day7.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;

public class Solver1 {

    private static final Logger LOGGER = System.getLogger(Solver1.class.getName());
	private static final String TEST_RESULT = "95437";

	private Directory treeNode = null;
	private Directory parent = null;

    private String fileName;

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();

        return solution(data);
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

		parent.getSize();
		return parent.flaten().stream().map(Directory::getSize).filter(a -> a <= 100000).reduce(0, Integer::sum)
				.toString();
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
            LOGGER.log(Logger.Level.TRACE, e);
        }

        return input;
    }

    public String getTestResult() {
        return TEST_RESULT;
    }

	private class Directory {
		@Override
		public String toString() {
			return "Directory [dirs=" + dirs.size() + ", files=" + files + ", size=" + size + ", parent="
					+ Optional.ofNullable(parent).map(Directory::getName).orElse(null)
					+ ", name="
					+ name + "]";
		}

		private final List<Directory> dirs = new ArrayList<>();
		private final List<FileWithSize> files = new ArrayList<>();
		
		private int size = 0;

		private Directory parent = null;
		private String name;
		
		public Directory(Directory parent, String name) {
			this.parent = parent;
			this.name = name;
		}

		public List<Directory> flaten() {
			List<Directory> flat = new ArrayList<>();

			dirs.stream().forEach(dir -> flat.addAll(dir.flaten()));
			flat.add(this);
			return flat;
		}

		public List<Directory> getDirs() {
			return dirs;
		}

		public int getSize() {
			if (size == 0) {
				int localSize = files.stream().map(FileWithSize::size).reduce(0, Integer::sum)
						+ dirs.stream().map(Directory::getSize).reduce(0, Integer::sum);
				size = localSize;
			}
			return size;
		}

		public String getName() {
			return name;
		}

		public Directory getParent() {
			return parent;
		}

		public void addDir(Directory dir) {
			dirs.add(dir);
		}

		public void addFiles(int size) {
			files.add(new FileWithSize(size));
		}
	}
	
	private record FileWithSize (int size) {
		
	}
}