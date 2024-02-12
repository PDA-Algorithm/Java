import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());

			if (i + day <= N) {
				dp[i + day] = Math.max(dp[i + day], dp[i] + money);	//	
			}

			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
		}

		System.out.println(dp[N]);
	}

}
