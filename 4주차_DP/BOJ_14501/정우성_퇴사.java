import java.io.*;
import java.util.StringTokenizer;

public class B14501{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = 0;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int [] P = new int[N+1];
        int []DP = new int [N+2];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <=N + 1; i++){
            DP[i] = Math.max(max, DP[i]);

            if(i <= N && (i + T[i] < N + 1)){
                DP[i + T[i]] = Math.max(DP[i] + P[i], DP[i + T[i]]);
            }

            max = Math.max(max, DP[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
