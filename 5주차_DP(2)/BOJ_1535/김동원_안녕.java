package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플랫폼: 백준
 * 이름: 안녕 (1535)
 * */
public class DpHello {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int n = Integer.parseInt(br.readLine());

        int[] minusHealth = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++)
            minusHealth[i] = Integer.parseInt(st.nextToken());

        int[] plusHappy = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++)
            plusHappy[i] = Integer.parseInt(st.nextToken());

        // dp
        int[][] dp = new int[n+1][101];
        for(int i=1;i<=n;i++) {
            for(int w=1;w<=100;w++) {
                if (w-minusHealth[i] < 1) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(plusHappy[i] + dp[i-1][w-minusHealth[i]], dp[i-1][w]);
                }
            }
        }

        System.out.print(dp[n][100]);
    }
}
