/**
 * MineSweeper class
 *
 * @author Andrew Chon
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MineSweeper {

    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File();
        Scanner scanner = new Scanner(System.in);
        int fieldNum = 1;
        if (args.length == 1) {
            scanner = new Scanner(new File(args[0]));
        }

        while (scanner.hasNextLine()) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();


            if (rows == 0 && cols == 0) {
                break;
            }

//            if (fieldNum > 1) {
//                System.out.println();
//            }


            char[][] field = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String line = scanner.next();
                field[i] = line.toCharArray();
            }
//            System.out.println();
            decodeField(field, fieldNum++);
        }
    }

    private static void decodeField(char[][] field, int fieldNum) {
        System.out.println("Field #" + fieldNum + ":");

        // vertically looking
        int rows = field.length;

        //looking more specifically into each row or each column specifically.
        int cols = field[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (field[i][j] == '.') {
                    int count = countAdjacentMines(field, i, j);
                    field[i][j] = (char) (count + '0');
                }
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static int countAdjacentMines(char[][] field, int row, int col) {
        int count = 0;

        //coordinates for adjacent
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[0].length &&
                    field[newRow][newCol] == '*') {
                count++;
            }
        }

        return count;
    }

}




