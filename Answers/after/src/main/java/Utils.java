import java.util.Random;
import java.util.Scanner;
public class Utils {
    public void showGrids(Grid p1MainGrid , Grid p2MainGrid){
        System.out.println("Player 1's Main Grid:");
        p1MainGrid.showGrid();
        System.out.println("Player 2's Main Grid:");
        p2MainGrid.showGrid();
    }

    public void placeShip(Grid grid, Ship[] pShips, int lastIndex, coordinate c1) {
        Random randomNumber = new Random();
        Scanner Scanner = new Scanner(System.in);
        System.out.println("random filling:1");
        System.out.println("hand filling:2");
        int choice = Scanner.nextInt();
        switch (choice) {
            case 1 :{
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
            case 2:{
                int shipNumber;
                System.out.println("how many Ships you want add? between (1,6)");
                shipNumber = Scanner.nextInt();
                for (int h = 0; h <  shipNumber; h++) {
                   boolean isHorizontal;
                    System.out.println("give a boolean horizontal:1   vertical:2");
                    isHorizontal = Scanner.nextBoolean();
                    boolean again = false;
                    int size;
                    String firstCell;
                    char row;
                    char col;
                    do {
                     if (again)
                            System.out.println("invalid input or cannot place ship");
                        System.out.println("enter a size for your ship1");
                        size = Scanner.nextInt();
                        System.out.println("give String as first cell");
                        firstCell = Scanner.next().toUpperCase();
                        row = firstCell.charAt(0);
                        col = firstCell.charAt(1);
                        if(c1.isValidInput(firstCell)  || !c1.canPlace(grid,isHorizontal,row,col,size))
                            again = true;
                    }while (again);
                    for (int j = 0; j < size; j++) {
                        if (isHorizontal) {
                            grid.grid[row][col + j] = 'S';
                        } else {
                            grid.grid[row + j][col] = 'S';
                        }
                 }
                    Ship newShip = new Ship();
                    newShip.setSize(size);
                    newShip.polarization(isHorizontal);
                    String first = String.valueOf(row) + String.valueOf(col);
                    newShip.setPlace(first);
                    pShips[lastIndex] = newShip;
                    lastIndex++;
                }
            }
        }
    }


    public boolean isGameOver(Grid grid1 , Grid grid2) {
        return allShipsSunk(grid1.grid) || allShipsSunk(grid2.grid);
    }

    public boolean allShipsSunk(char[][] grid) {
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
