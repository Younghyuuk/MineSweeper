import java.util.Scanner;

/**
 * Object that represents a basic Minesweeper game board.
 *
 * @author Marrok Young
 * @version Summer 2023
 */
public class Minesweeper {
    /**
     * A 2D array to represent the minesweeper game board.
     */
    public char[][] myMineField;
    /**
     * The amount of rows a given field contains.
     */
    public int myRows;
    /**
     * The amount of columns a given field contains.
     */
    public int myColumns;
    /**
     * The number that represents each field in sequential order.
     */
    public int myFieldNumber;

    /**
     * Public constructor to construct minesweeper boards.
     *
     * @param theInputFile The input file to read into the program.
     */
    public Minesweeper(final Scanner theInputFile) {
        myFieldNumber = 1;
        outputFile(theInputFile);
    }

    /**
     * Reads in the input file, turns the fields into the proper outputs,
     * then writes that output to a new file.
     *
     * @param theInputFile The input file to read into the program.
     */
    private void outputFile(final Scanner theInputFile) {
        // Since we only go through the rows and cols that we see in the first
        // row of the input file, we want to use this while loop to go the next
        // line in the file after doing the first game board if there is anything else
        while (theInputFile.hasNextLine()) {
            // We can then get the values for our rows and cols
            myRows = theInputFile.nextInt() + 2;
            myColumns = theInputFile.nextInt() + 2;

            // BASE CASE: The game board is empty
            if (myRows == 0 && myColumns == 0) {
                break;
            }

            // Then we can set the capacity for our 2D array
            myMineField = new char[myRows][myColumns];
            // After getting the rows and columns we should get to the next line
            if (theInputFile.hasNextLine()) {
                theInputFile.nextLine();
            }

            // Now we will proceed to storing the elements of
            // the input file inside our buffered 2D array
            for (int i = 1; i < myRows - 1; i++) {
                String line = theInputFile.nextLine();
                for (int j = 1; j < myColumns - 1; j ++) {
                    myMineField[i][j] = line.charAt(j - 1);
                }
            }

            // Since we overwrite our in class array, we need to create
            // the new array to place into the output text file inside of this method
            findMineCount();
            // We finally need to first make sure that the game board is not empty
            // Basically, if the rows and cols are 2, that means the game board is 0x0
            // since we always add 2 to the rows and cols!
            if (!(myRows == 2 && myColumns == 2)) {
                // Then we will print out the corresponding field #
                System.out.println("Field #" + myFieldNumber + ":");
                // And print out every index of our 'myFieldNumber' array
                for (int i = 1; i < myRows - 1; i++) {
                    for (int j = 1; j < myColumns - 1; j++) {
                        System.out.print(myMineField[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                // We also want to increment this for every new field
                myFieldNumber++;
            }
        }
        // Finally, we need to close the scanner!
        theInputFile.close();
    }

    /**
     * Helper method that gets the mine count for every '.' character
     * and then turns that into a number corresponding to how many
     * mines are around it.
     */
    private void findMineCount() {
        // We need to iterate through our array
        for (int i = 1; i < myRows - 1; i++) {
            for (int j = 1; j < myColumns - 1; j++) {
                // If we are not on a mine space, we want to
                if (myMineField[i][j] == '.') {
                    // We want to get the amount of mines that show up around the spot
                    int mineCount = 0;
                    // Then we will go around checking the 8 adjacent tiles
                    // We start on -1 because we need to go a row up at first
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            // If we find any '*' we up the count
                            if (myMineField[i + dx][j + dy] == '*') {
                                mineCount++;
                            }
                        }
                    }
                    // After looping through every adjacent tile, we set
                    // the current '.' to the new number
                    myMineField[i][j] = (char) (mineCount + '0');
                }
            }
        }
    }
}
