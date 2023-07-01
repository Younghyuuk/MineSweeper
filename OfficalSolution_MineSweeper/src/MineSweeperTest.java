import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MineSweeperTest {
    private MineSweeper minesweeper;

    public MineSweeperTest() throws FileNotFoundException {
    }

    @BeforeEach
    public final void setup() throws FileNotFoundException {
        Scanner input = new Scanner(new File("generated_input.txt"));
        minesweeper = new MineSweeper(input);
    }

    @Test
    public void testDecodeField() {
        char[][] field = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        minesweeper.decodeField(field,1 );

        char[][] expectedField = {
                {'2', '*', '*', '2'},
                {'*', '5', '5', '*'},
                {'3', '*', '*', '3'},
                {'*', '3', '3', '*'}
        };

        Assertions.assertArrayEquals(expectedField, field);
    }

    @Test
    public void testCountAdjacentMines() {
        char[][] field = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        int count = minesweeper.countAdjacentMines(field, 1, 1);
        Assertions.assertEquals(5, count);

        count = minesweeper.countAdjacentMines(field, 0, 0);
        Assertions.assertEquals(2, count);

        count = minesweeper.countAdjacentMines(field, 3, 3);
        Assertions.assertEquals(1, count);
    }

    @Test
    public void testCreateField() {
        String input = "4 4\n" +
                ".**.\n" +
                "*..*\n" +
                ".**.\n" +
                "*..*";

        Scanner scanner = new Scanner(input);
        minesweeper.createField(scanner);

        char[][] expectedField = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        Assertions.assertArrayEquals(expectedField, minesweeper.myField);
    }

    @Test
    public void testStartEmpty() {
        // Test empty field
        String input = "0 0\n";
        Scanner scanner = new Scanner(input);
        minesweeper.start(scanner);
        Assertions.assertEquals(0, minesweeper.myRows);
        Assertions.assertEquals(0, minesweeper.myCols);
    }

    @Test
    public void testStartNotEmpty() {
        // Test non-empty field
        String input = "2 2\n" +
                        "..\n" +
                        "..\n";
        Scanner scanner = new Scanner(input);
        minesweeper.start(scanner);
        char[][] expectedField = {
                {'.', '.'},
                {'.', '.'}
        };
        Assertions.assertArrayEquals(expectedField, minesweeper.myField);
        Assertions.assertEquals(2, minesweeper.myRows);
        Assertions.assertEquals(2, minesweeper.myCols);
    }

    @Test
    public void testConstructor() {
        Assertions.assertNotNull(minesweeper.myField);
    }
}
