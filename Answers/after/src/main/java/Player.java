import java.util.Scanner;

public class Player {
    public Ship[] Ships = new Ship[4];
    public int lastIndex = 0;
    private Grid mainGrid = new Grid();
    private Grid AttackGrid = new Grid();

    public void initializeGrids(char[][] grid1, char [][] grid2){
        for (int i = 1; i <= 10 ; i++) {
            for (int j =1; j <= 10; j++) {
                mainGrid.grid[i][j] = grid1[i][j];
                mainGrid.grid[i][j] = grid2[i][j];
            }
        }
    }

    public void playerTurn(Grid pMainGrid, Grid pAttackGrid, String give, int player, coordinate c1 , Utils u1) {
        System.out.println("Enter a cell to fire at (e.g., A6):");
        boolean played = false;
        Scanner scanner = new Scanner(System.in);
        do {
            String cell = scanner.next().toUpperCase();
            if (c1.isValidInput(cell)) {
                int row = cell.charAt(0) - 64;
                int col = cell.charAt(1) - '0';
                if (pAttackGrid.grid[row][col] == '~') {
                    played = true;
                    if (pMainGrid.grid[row][col] == 'S') {
                        pAttackGrid.grid[row][col] = '*';
                        pMainGrid.grid[row][col] = '~';
                        System.out.println("Hit!");
                        if (u1.allShipsSunk(pMainGrid.grid)) {
                            System.out.println("Player " + player + " wins!");
                            return;
                        }
                    } else {
                        pAttackGrid.grid[row][col] = '!';
                        System.out.println("Miss!");
                    }
                } else {
                    System.out.println("This cell has already been attacked. Please enter another one!");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid cell (e.g., A5):");
            }
        } while (!played);
    }

}
