package baekjoon.gold.level5;

public class Main {
    public static void main(String[] args) {

        int[][] diagonals = {{1, 1}, {2, 2}};
        int answer = countShortestPathsWithDiagonal(2, 2, diagonals);
        System.out.println(answer);
    }

    public static int countShortestPathsWithDiagonal(int width, int height, int[][] diagonals) {
        // initialize dp table
        int[][] dp = new int[width+1][height+1];
        dp[0][0] = 1;

        // initialize first row and column
        for (int i = 1; i <= width; i++) {
            if (!contains(diagonals, i-1, 0)) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j = 1; j <= height; j++) {
            if (!contains(diagonals, 0, j-1)) {
                dp[0][j] = dp[0][j-1];
            }
        }

        // fill dp table
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (!contains(diagonals, i-1, j) && !contains(diagonals, i, j-1)) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else if (contains(diagonals, i-1, j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[width][height];
    }

    private static boolean contains(int[][] diagonals, int x, int y) {
        for (int i = 0; i < diagonals.length; i++) {
            if (diagonals[i][0] == x && diagonals[i][1] == diagonals.length-y-1) {
                return true;
            }
        }
        return false;
    }


}
