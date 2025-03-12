public class Grid{
   public char[][] grid = new char[11][11];
   public Grid(){
        for(int i=1 ; i<=10 ; i++){
           for(int j=1 ; j<=10 ; j++){
             grid[i][j] = '~';
         }
     }
    }

    public void showGrid() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            System.out.print((char) ('A' + i - 1) + " ");
            for (int j = 1; j <= 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


}