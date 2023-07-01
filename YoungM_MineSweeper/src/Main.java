import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main method to take input from the console.
 *
 * @author Marrok Young
 * @version Summer 2023
 */
public class Main {
    /**
     * Main method to take input from the console of a file name
     * and then pass that into a 'Minesweeper' object
     *
     * @param args The String array that stores the inputs from the console.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // We need to allow input to be taken from the console
        Scanner input = new Scanner(System.in);

        // Then, since we just want 1 file name, we are just looking to see
        // if there is only 1 element stored in args since it's a String[]
        if (args.length == 1) {
            // And we create a new file based on the file name passed in
            input = new Scanner(new File(args[0]));
        }

        // Finally, we pass that into our Minesweeper object to do
        // the rest of our work for us
        Minesweeper minesweeper = new Minesweeper(input);
    }
}