public class Grid{
   private char[11][11] grid;
   public Grid(){
        for(int i=1 ; i<=10 ; ){
           for(int j=1 ; j<=10 ; j++){
             grid[i][j] = '~'
         }
     }
    }

    public void showGrid(){
        System.out.print("  ");
        for(int i=1 ; i<=10 ; i++){
            if(i == 10){
                System.out.print(i);
            }else{
                System.out.print(i+" ");
            }
        }

        for(int i=1 ; i<=10 ; i++){
            System.out.print((char)(A + i - )1)
            for(int j=1 ; j<=10 ; j++){
                System.out.print(grid[i][j]);
            }
        }
    }
}