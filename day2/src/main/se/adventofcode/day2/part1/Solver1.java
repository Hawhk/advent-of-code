package se.adventofcode.day2.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solver1 {

    private String fileName;

    private final String testResult = "15";

    public Solver1(String fileName) {
        this.fileName = fileName;
    }

    public String solve() {

        var data = getInput();
        
        return data.stream().map(RockPaperSissors::getPoints).reduce(0, Integer::sum).toString();
    }

    private List<RockPaperSissors> getInput() {
        List<RockPaperSissors> input = new ArrayList<>();

        try {
            File myObj = new File("input/" + fileName);
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                var a = data.split(" ");
                input.add(new RockPaperSissors(Enemy.valueOf(a[0]), Me.valueOf(a[1])));
                //code here!
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
    
    private record RockPaperSissors(Enemy e, Me m) {
    	public int getPoints() {
    		int points = m.ordinal() + 1;
    		
    		if (e.ordinal() == m.ordinal()) {
    			points += 3;
    		} else if ((e.ordinal() + 1)%3 == m.ordinal()) {
    			points += 6;
    		}
    		
    		return points;
    	}
    }
    
    private enum Enemy {
    	A,B,C;
    }
    private enum Me {
    	X,Y,Z;
    }
}