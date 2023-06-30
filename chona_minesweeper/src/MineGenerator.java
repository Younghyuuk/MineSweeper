import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MineGenerator {
    public static void main(String[] args) {
        int numFields = 3; // Number of random fields to generate
        try {
            FileWriter writer = new FileWriter("mineSweep.txt");

            for (int i = 0; i < numFields; i++) {
                int rows = getRandomNumber(1, 10); // Random number of rows between 1 and 10
                int cols = getRandomNumber(1, 10); // Random number of columns between 1 and 10
                int minePercentage = getRandomNumber(0, 10); // Random mine percentage between 0 and 50

                writer.write(rows + " " + cols + "\n");

                char[][] field = generateRandomField(rows, cols, minePercentage);

                for (int r = 0; r < rows; r++) {
                    writer.write(new String(field[r]) + "\n");
                }
            }

            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char[][] generateRandomField(int rows, int cols, int minePercentage) {
        char[][] field = new char[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (random.nextInt(100) < minePercentage) {
                    field[i][j] = '*';
                } else {
                    field[i][j] = '.';
                }
            }
        }

        return field;
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

