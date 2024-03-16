package javaapplication1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main (driving) class for simulation of a race involving the creatures.
 * It reads the weather conditions and creatures from a file and picks out the winner.
 */

class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

class InvalidCreatureTypeException extends Exception {
    public InvalidCreatureTypeException(String message){
        super(message);
    }
}
public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the file: ");
        
        String filename = scanner.nextLine();
        //BufferedReader fileReader0 = new BufferedReader(new FileReader(filename));

        try {
            List<Creature> racers = new ArrayList<>();
            String weather;
            try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
                String firstLine = fileReader.readLine();
                if (firstLine == null) {
                    throw new EmptyFileException("The file is empty.");
                }
                int count = Integer.parseInt(firstLine);

                /*int count = Integer.parseInt(fileReader.readLine());
                if (count == 0) {
                    throw new EmptyFileException("The file is empty.");
                }*/
                for(int i = 0; i < count; i++) {
                    String line = fileReader.readLine();
                    String[] input = line.split(" ");
                    
                    String name = input[0];
                    char type = input[1].charAt(0);
                    int initialWaterLevel = Integer.parseInt(input[2]);
                    
                    
                    Creature racer = newRacer(name, type, initialWaterLevel);
                    if(racer != null) {
                        racers.add(racer);
                    }
                    
                }   weather = fileReader.readLine();
            }

            int maxDistance = 0;
            Creature winner = null;

            for(char day: weather.toCharArray()) {
                for(Creature racer : racers) {
                    if(racer.isAlive()) {
                        if(day == 's') {
                            racer.sunny();
                        }
                        else if(day == 'c') {
                            racer.cloudy();
                        }
                        else if(day == 'r') {
                            racer.rainy();
                        }

                        if(racer.getDistance()>maxDistance) {
                            winner = racer;
                        }
                        else if (racer.currentWaterLevel > racer.maxWaterLevel)
                        { throw new IllegalArgumentException("The current water level exceeds the maximum water level."); }
                    }
                }
            } 

            if(winner != null) { System.out.println("Winner: " + winner.getName()); }
            else { System.out.println("No one won."); }
        } catch (EmptyFileException e) {
        System.err.println(e.getMessage());
        } catch (IOException error) { error.getMessage(); }
        finally { scanner.close(); }
        
        /*
        System.out.println("Below are the test cases");
        //test for sunny
        Sandrunner sandrunner = new Sandrunner("Sand", 5);
        sandrunner.sunny(); // Should decrease currentWaterLevel by 1 and increase distance by 3
        if (sandrunner.currentWaterLevel == 4 && sandrunner.distance == 3) { System.out.println("Test: Passed"); }
        else { System.out.println("Test: Failed"); }
        
        //test for cloudy
        Sponge sponge = new Sponge("Spon", 10);
        sponge.cloudy(); // Should decrease currentWaterLevel by 1 and increase distance by 3
        if (sponge.currentWaterLevel == 9 && sponge.distance == 1) { System.out.println("Test: Passed"); }
        else { System.out.println("Test: Failed"); }*/
        
    }

    /**
     * Creates and initializes a new creature with the name and initial water level.
     *
     * @param name The name of the creature.
     * @param type The type of the creature, represented by a character ('r', 's', or 'w').
     * @param initialWaterLevel The initial water level.
     * @return The Creature object.
     */
    private static Creature newRacer(String name, char type, int initialWaterLevel) {
        Creature racer = null;

        switch(type) {
            case 'r':
                racer = new Sandrunner(name, initialWaterLevel);
                break;
            case 's':
                racer = new Sponge(name,initialWaterLevel);
                break;
            case 'w':
                racer = new Walker(name, initialWaterLevel);
                break;
             /*default:
                throw new InvalidCreatureTypeException("No such Creature exists");*/
        }
        if (racer == null) {
            System.err.println("No such Creature exists");
        }
        return racer;
    }
    
}


