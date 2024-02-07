import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 플랫폼: 백준
* 이름: 신나는 함수 실행(9184)
* */
public class Main {
    private static int[][][] dp = new int[21][21][21];
    public static int w(int a, int b, int c) {
       if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a>20 || b>20 || c>20) {
            dp[20][20][20] = w(20,20,20);
            return dp[20][20][20];
        }

       if (dp[a][b][c] != 0) return dp[a][b][c];

       if (a<b && b<c) {
           dp[a][b][c] = w(a,b,c-1) + w(a,b-1, c-1)-w(a,b-1,c);
           return dp[a][b][c];
       }

       dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
       return dp[a][b][c];
    }

    public static void solution() throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if ("-1 -1 -1".equals(input))
                break;

            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c , w(a,b,c)));
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
