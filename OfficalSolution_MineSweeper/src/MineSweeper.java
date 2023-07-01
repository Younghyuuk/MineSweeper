import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MineSweeper {
    /**
     * A 2D array to represent the minesweeper game board.
     */
    char[][] myField;
    /**
     * The amount of rows a given field contains.
     */
    int myRows;
    /**
     * The amount of columns a given field contains.
     */
    int myCols;
    /**
     * The number that represents each field in sequential order.
     */
    private int myFieldNumber;

    /**
     * Public constructor to construct minesweeper boards.
     *
     * @param theInputFile The input file to read into the program.
     */

    public MineSweeper(final Scanner theInputFile) {
        myFieldNumber = 1;
        myRows = 1;
        start(theInputFile);
    }
    void start(final Scanner theInput) {

        while (theInput.hasNextLine()) {
            createField(theInput);
            if (myRows == 0 && myCols == 0){
                break;
            }
            decodeField(myField, myFieldNumber);
        }

    }
    /**
     * Creating the Field depending on its n by m size.
     * @param theInput the scanner we pass through to read the input file.
     * */
    void createField(final Scanner theInput) {
        final Scanner scanner = theInput;
        myRows = scanner.nextInt();
        myCols = scanner.nextInt();
        myField = new char[myRows][myCols];
        for (int i = 0; i < myRows; i++) {
            String line = scanner.next();
            myField[i] = line.toCharArray();
        }
    }
    void decodeField(final char[][] theField, final int theFieldNum) {
        System.out.println("Field #" + myFieldNumber++ + ":");
        // vertically looking
        int rows = theField.length;

        //looking more specifically into each row or each column specifically.
        int cols = theField[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (theField[i][j] == '.') {
                    int count = countAdjacentMines(theField, i, j);
                    theField[i][j] = (char) (count + '0');
                }
                System.out.print(theField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    int countAdjacentMines(final char[][] theField, final int theRow, final int theCol) {
        int count = 0;
        //coordinates for adjacent
        final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < dx.length; i++) {
            int newRow = theRow + dx[i];
            int newCol = theCol + dy[i];

            if (newRow >= 0 && newRow < theField.length && newCol >= 0 && newCol < theField[0].length &&
                    theField[newRow][newCol] == '*') {
                count++;
            }
        }
        return count;
    }
}
