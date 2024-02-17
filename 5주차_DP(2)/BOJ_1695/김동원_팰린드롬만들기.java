package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DpPalindrome {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(arr[i-1] == arr[n-j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // 최장공통부분수열 (순서는 상관 있음 / 인덱스는 맞지 않아도 됨)
        // n - 일반 수열과 반대 수열의 LCS 값: 팰린드롬은 양 옆이 뒤집어진 수 이기 때문에
        // 맞지 않은 곳만 넣어주는 것이 최소로 넣는 것

        System.out.print(n-dp[n][n]);
    }
}
