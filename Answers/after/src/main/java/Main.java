public class Main {

    public static void main(String[] args) {

         Grid p1MainGrid = new Grid();
         Grid p2MainGrid = new Grid();
         Grid p1AttackGrid = new Grid();
         Grid p2AttackGrid = new Grid();

        Utils u1  = new Utils();
        coordinate c1 = new coordinate();
        Player p1 = new Player();
        Player p2 = new Player();

        p1.initializeGrids(p1MainGrid.grid,p1AttackGrid.grid);
        p2.initializeGrids(p2MainGrid.grid,p2AttackGrid.grid);


        u1.placeShip(p1MainGrid, p1.Ships, p1.lastIndex,c1);
        u1.placeShip(p2MainGrid, p2.Ships, p2.lastIndex,c1);

        u1.showGrids(p1MainGrid,p2MainGrid);
        while(!u1.isGameOver(p1MainGrid,p2MainGrid)) {

            boolean player1Turn = true;
            String p1g = "";
            String p2g = "";

            while (!u1.isGameOver(p1MainGrid, p2MainGrid)) {
                if (player1Turn) {
                    System.out.println("Player 1's turn:");
                    p1AttackGrid.showGrid();
                    p1.playerTurn(p2MainGrid, p1AttackGrid, p1g, 1, c1, u1);
                } else {
                    System.out.println("Player 2's turn:");
                    p2AttackGrid.showGrid();
                    p2.playerTurn(p1MainGrid, p2AttackGrid, p2g, 2, c1, u1);
                }
                player1Turn = !player1Turn;
            }

            System.out.println("Game Over!");
        }

    }

}
