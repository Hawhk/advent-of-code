package se.adventofcode.day9.part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Solver {

    private static final Logger LOGGER = System.getLogger(Solver.class.getName());
	private static final String TEST_RESULT = "13";

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
    	
		Cordinates head = new Cordinates();
		Cordinates tail = new Cordinates();
		Set<String> positonVisited = new HashSet<>();
    	data.forEach(row -> {
			var tmp = row.split(" ");
			char dir = tmp[0].charAt(0);
			int steps = Integer.parseInt(tmp[1]);
			for (int i = 0; i < steps; i++) {
				switch (dir) {
				case 'D': {
					head.addX(-1);
					break;
				}
				case 'U': {
					head.addX(1);
					break;
				}
				case 'L': {
					head.addY(-1);
					break;
				}
				case 'R': {
					head.addY(1);
					break;
				}
				default: {
					break;
				}
				}

				int x = head.getX() - tail.getX();
				int y = head.getY() - tail.getY();

				int distx = (int) Math.sqrt((double) x * x);
				int disty = (int) Math.sqrt((double) y * y);

				int dirx = 0;
				int diry = 0;

				if (distx != 0) {
					dirx = x / distx;
				}
				if (disty != 0) {
					diry = y / disty;
				}
				
				if ((distx == 2 && disty == 1) || (disty == 2 && distx == 1)) {
					tail.addX(dirx);
					tail.addY(diry);
				} else if (distx == 2) {
					tail.addX(dirx);
				} else if (disty == 2) {
					tail.addY(diry);
				}
				positonVisited.add(tail.toString());
			}
		});

		return String.valueOf(positonVisited.size());
    }

	private class Cordinates {

		@Override
		public String toString() {
			return x + "," + y;
		}

		private int x = 0;
		private int y = 0;

		public void addX(int mx) {
			this.x += mx;
    	}

		public void addY(int my) {
			this.y += my;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
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