import java.util.Random;

public class Main {
    private static final Random rand = new Random();
    private static final int NUMBER_OF_FIELDS = 30;
    private static final int ONE_HUNDRED = 100;
    private static final int ONE = 1;
    public static void main(String[] args) {
        // 1x1 all mines and no mines.
        createFields(ONE,ONE,true);
        createFields(ONE,ONE,false);
        // 100x100 all mines and no mines
        createFields(ONE_HUNDRED,ONE_HUNDRED,true);
        createFields(ONE_HUNDRED,ONE_HUNDRED,false);
        // 1x100 all mines and no mines.
        createFields(ONE,ONE_HUNDRED,true);
        createFields(ONE,ONE_HUNDRED,false);
        // 100x1 all mines and no mines.
        createFields(ONE_HUNDRED,ONE,true);
        createFields(ONE_HUNDRED,ONE,false);
        // 100x1 random number of mines.
        createRandomFields(ONE,ONE_HUNDRED);
        createRandomFields(ONE,ONE_HUNDRED);
        // 1x100 random number of mines.
        createFields(ONE_HUNDRED,ONE,true);
        createFields(ONE_HUNDRED,ONE,false);
        // 100x100 random number of mines.
        createRandomFields(ONE_HUNDRED,ONE_HUNDRED);

        // Random sized fields with random assertions of mines.
        for (int i = 0; i < NUMBER_OF_FIELDS; i++){
            final int rand_row = rand.nextInt(101) + 1;
            final int rand_col = rand.nextInt(101) + 1;
            createRandomFields(rand_row,rand_col);
        }
        System.out.println("0 0");
    }
    private static void createFields(final int row, final int col, boolean allMines) {
        System.out.println(row + " " + col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j <col; j++){
                if (allMines){
                    System.out.print(".");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
    private static void createRandomFields(final int row, final int col) {
        System.out.println(row + " " + col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j <col; j++){
                final int dotOrStar = rand.nextInt(2);
                if (dotOrStar == 0){
                    System.out.print(".");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
}