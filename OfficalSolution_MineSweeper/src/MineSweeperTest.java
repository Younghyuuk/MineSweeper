import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MineSweeperTest {
    private MineSweeper minesweeper;

    @BeforeEach
    public final void setup() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/team_minesweeper_input.txt"));
        minesweeper = new MineSweeper(input);
    }

    @Test
    public void testDecodeField_One(){
        char[][] oneByOne = {{'.'}};
            minesweeper.decodeField(oneByOne, minesweeper.myFieldNumber);

        char[][] expectedField = {{'0'}};

        Assertions.assertArrayEquals(expectedField, oneByOne);

    }

//*****************************************************************************************
    @Test
    public void testDecodeField_OneByOne_AllMines() {
        char[][] oneByOne = {
                {'*'}
        };
        minesweeper.decodeField(oneByOne, minesweeper.myFieldNumber);
        char[][] expectedField = {{'*'}};
        Assertions.assertArrayEquals(expectedField, oneByOne);
    }

    @Test
    public void testDecodeField_HundredByHundred_AllMines() {
        char[][] tenByTen = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tenByTen[i][j] = '*';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }
//
//    @Test
//    public void testDecodeField_OneByHundred_AllEmpty() {
//        char[][] field = new char[1][100];
//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; j < 100; j++) {
//                field[i][j] = '.';
//            }
//        }
//
//        String expectedOutput = "Field #1:\n" +
//                "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000\n\n";
//
//        MineSweeper mineSweeper = new MineSweeper(new Scanner(System.in));
//        assertEquals(expectedOutput, getFormattedOutput(() -> mineSweeper.decodeField(field, 1)));
//    }

//    @Test
//    public void testDecodeField_HundredByHundred_AllMines() {
//        char[][] field = new char[100][100];
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                field[i][j] = '*';
//            }
//        }
//    }
//********************************************************************************************************




    @Test
    public void testDecodeField() {
        char[][] field = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        minesweeper.decodeField(field,minesweeper.myFieldNumber);

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
        assertEquals(5, count);

        count = minesweeper.countAdjacentMines(field, 0, 0);
        assertEquals(2, count);

        count = minesweeper.countAdjacentMines(field, 3, 3);
        assertEquals(1, count);
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
        MineSweeper mineTest = new MineSweeper(scanner);
        assertEquals(0, mineTest.myRows);
        assertEquals(1, mineTest.myFieldNumber);

    }

}
