public class coordinate {
    public boolean isValidInput(String input) {
        // done
        char ch0 = input.charAt(0);
        char ch1 = input.charAt(1);

        if (ch0 <= 74 && ch0 >= 65 && ch1 <= 59 && ch1 >= 50) {
            return true;
        }
        return false;
    }

    public boolean canPlace(Grid board, boolean isHorizontal, int row, int col, int size) {
        if (isHorizontal && row + size <= 10) {
            for (int i = 0; i < size; i++) {
                if (board.grid[row + i][col] != '~')
                    return false;
            }
            return true;
        }

        if (!isHorizontal && col + size <= 10) {
            for (int i = 0; i < size; i++) {
                if (board.grid[row][col + i] != '~')
                    return false;
            }
            return true;
        }
        return false;
    }
}
