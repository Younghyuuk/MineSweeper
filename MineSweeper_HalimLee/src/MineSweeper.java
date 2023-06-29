/* Halim Lee
 * TCSS 360
 */
import java.util.Scanner;
import java.io.File;
import java.io.*;
public class MineSweeper {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        if (args.length == 1) {
            //assuming if there is 1 argument on the command line
            // it is the name of a file to use for testing
            //input = new Scanner(new File(args[0]));
            input = new Scanner(new File(args[0]));
        }
        createField(input);
    }
    public static void createField(final Scanner input) {
        int row = input.nextInt() + 2;
        int col = input.nextInt() + 2;
        int count = 1;
        while (row != 2) {

            int[][] ans = new int[row][col];
            for (int fieldRow = 1; fieldRow < row-1; fieldRow++) {
                String line = input.next();
                for (int fieldCol = 1; fieldCol < col-1; fieldCol++) {
                    if (line.charAt(fieldCol-1) == '*') {
                        ans[fieldRow][fieldCol] = 9;
                        for (int adjRow = fieldRow - 1; adjRow < fieldRow + 2; adjRow++) {
                            for (int adjCol = fieldCol - 1; adjCol < fieldCol + 2; adjCol++) {
                                if (ans[adjRow][adjCol] < 8)
                                ans[adjRow][adjCol] = ans[adjRow][adjCol]+1;
                            }
                        }
                    }
                }
            }
            System.out.println("Field #" + count++ + ":");
            for (int fieldRow = 1; fieldRow < row-1; fieldRow++) {
                for (int fieldCol = 1; fieldCol < col-1; fieldCol++) {
                    if (ans[fieldRow][fieldCol] == 9) {
                        System.out.print('*');
                    } else {
                        System.out.print(ans[fieldRow][fieldCol]);
                    }
                }
                System.out.println();
            }
            row = input.nextInt() + 2;
            col = input.nextInt() + 2;
            System.out.println("");
        }
        System.out.println("End of the program");
    }

}
