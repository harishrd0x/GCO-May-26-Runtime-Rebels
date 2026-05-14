import java.util.*;

public class SecurityGrid {

    static int[][] matrix;
    static boolean[][] seen; // Track visited cells
    static int r, c;

    // DFS to mark all connected 1's in a group
    static void explore(int i, int j) {

        // Boundary check
        if (i < 0 || j < 0 || i >= r || j >= c)
            return;

        // Skip if 0 or already visited
        if (matrix[i][j] == 0 || seen[i][j])
            return;

        seen[i][j] = true;

        explore(i + 1, j);
        explore(i - 1, j);
        explore(i, j + 1);
        explore(i, j - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        // Handle empty grid
        if (r <= 0 || c <= 0) {
            System.out.println(0);
            return;
        }

        matrix = new int[r][c];
        seen = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Count connected groups of 1's
        int groups = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                // Start new group when finding unvisited 1
                if (matrix[i][j] == 1 && !seen[i][j]) {
                    explore(i, j);
                    groups++;
                }
            }
        }

        System.out.println(groups);
    }
}