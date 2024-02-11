import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	static int[] max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		max = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			max[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= (i / 2); j++) {
				max[i] = Math.max(max[i], max[j] + max[i - j]);
			}
		}

		System.out.println(max[N]);
	}

}
