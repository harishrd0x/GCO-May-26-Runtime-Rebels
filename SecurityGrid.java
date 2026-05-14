import java.util.*;

public class SecurityGrid {

    static int[][] matrix;
    static boolean[][] seen;
    static int r, c;

    static void explore(int i, int j) {

        if (i < 0 || j < 0 || i >= r || j >= c)
            return;

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

        matrix = new int[r][c];
        seen = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int groups = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (matrix[i][j] == 1 && !seen[i][j]) {
                    explore(i, j);
                    groups++;
                }
            }
        }

        System.out.println(groups);
    }
}