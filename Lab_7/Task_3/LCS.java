package Lab_7.Task_3;

public class LCS {
    public int lcs2(String x, String y) {
        if (x.length() < y.length()) {
            String temp = x;
            x = y;
            y = temp;
        }
        int m = x.length();
        int n = y.length();

        int[][] lcs = new int[2][m + 1];
        for (int j = 0; j <= n; j++) {
            lcs[0][j] = 0;
            lcs[1][j] = 0;
        }
        int prev[] = lcs[0];
        int cur[] = lcs[1];
        for (int i = 1; i <= m; i++) {
            cur[0] = 0;
            for (int j = 1; j <= n; j++) {
                prev[j] = cur[j];
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + 1;
                } else if (prev[j] >= cur[j - 1]) {
                    cur[j] = prev[j];
                } else {
                    cur[j] = cur[j - 1];
                }
            }
        }
        return cur[n];
    }
}
