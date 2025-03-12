import java.util.Random;

public class Utils {
    private int code;

    public Utils(){
        code = 1;
    }
    static void showGrids(Grid p1MainGrid , Grid p2MainGrid){
        System.out.println("Player 1's Main Grid:");
        p1MainGrid.showGrid();
        System.out.println("Player 2's Main Grid:");
        p2MainGrid.showGrid();
    }

    static void placeShip(Grid grid, Ship[] pShips, int lastIndex, coordinate c1) {
        Random randomNumber = new Random();
        for (int i = 2; i <= 5; i++) {
            boolean isHorizontal = randomNumber.nextBoolean();
            int row, col;
            do {
                row = randomNumber.nextInt(1, 10);
                col = randomNumber.nextInt(1, 10);
            } while (!c1.canPlace(grid, isHorizontal, row, col, i));

            for (int j = 0; j < i; j++) {
                if (isHorizontal) {
                    grid.grid[row][col + j] = 'S';
                } else {
                    grid.grid[row + j][col] = 'S';
                }
            }
            Ship newShip = new Ship();
            newShip.setSize(i);
            newShip.polarization(isHorizontal);
            String first = String.valueOf(row) + String.valueOf(col);
            newShip.setPlace(first);
            pShips[lastIndex] = newShip;
            lastIndex++;
        }
    }


    static boolean isGameOver(Grid grid1 , Grid grid2) {
        return allShipsSunk(grid1.grid) || allShipsSunk(grid2.grid);
    }

    static boolean allShipsSunk(char[][] grid) {
        // done
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (grid[i][j] == 'S')
                    return false;
            }
        }
        return true;
    }
}
