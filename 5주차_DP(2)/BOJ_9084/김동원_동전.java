package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플랫폼: 백준
 * 이름: 동전 (9084)
 * */
public class Coin {
    private static int coinN;
    private static int[] coins;

    public static int coinDp(int amount) {
        int[] dp = new int[amount+1];

        /*
         * 문제 봤음
         * 컨셉: 하나의 코인으로 경우의 수를 먼저 구함 + 그 다음 코인과 dp배열을 바탕으로 구함
         * */

        for (int j=0;j<coinN;j++) {
            for (int i=coins[0];i<=amount;i++) {
                if (i-coins[j] == 0) {
                    dp[i] += 1;
                } else if (i - coins[j] > 0) {
                    dp[i] += dp[i-coins[j]];
                }
            }
        }

        return dp[amount];
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numOfTestCase;i++) {
            coinN = Integer.parseInt(br.readLine());
            coins = new int[coinN];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<coinN;j++)
                coins[j] = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(br.readLine());

            sb.append(coinDp(amount)).append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
