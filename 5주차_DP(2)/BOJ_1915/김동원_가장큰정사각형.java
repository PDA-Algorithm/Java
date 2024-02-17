package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플랫폼: 백준
 * 이름: 가장 큰 정사각형 (1915)
 * */
public class MaxSquare {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][m+1];
        String[] line;
        for(int i=1;i<=n;i++) {
            line = br.readLine().split("");
            for (int j=1;j<=m;j++) {
                if(Integer.parseInt(line[j-1]) == 1)
                    matrix[i][j] = 1;
            }
        }

        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if (matrix[i][j] == 1) {
                    int a = dp[i-1][j-1]; // 대각선
                    int b = dp[i][j-1]; // 좌측
                    int c = dp[i-1][j]; // 상단

                    dp[i][j] = getMin(a,b,c) + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.print(max*max);

        // 점화식 세웠던 가정
        /*
         * 1 번째
         * P[i,j] = {
         *   대각선, 좌측, 상단이 모든 같은 숫자이며 0이 아닐 때, -> +1
         *   대각선, 좌측, 상단이 같은 숫자는 아니지만 모두 1 이상일 때, 최솟값이 + 1
         * }
         *
         * 2 번째
         * square[i,j] = 1이면, 대각선, 좌측, 상단의 최솟값 + 1
         *
         * */
    }

    public static int getMin(int a, int b, int c) {
        return Math.min(a,Math.min(b,c));
    }
}
