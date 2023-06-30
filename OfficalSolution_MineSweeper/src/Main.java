import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
            Scanner input = new Scanner(System.in);

            if (args.length == 1) {
                //assuming if there is 1 argument on the command line
                // it is the name of a file to use for testing
                //input = new Scanner(new File(args[0]));
                input = new Scanner(new File(args[0]));
            }
            MineSweeper mineSweeper = new MineSweeper(input);
        }
}

