package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] distances = new int[n-1];
        int[] prices = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++)
            distances[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            prices[i] = Integer.parseInt(st.nextToken());

        int i = 0;
        int j;
        long distance = 0;
        long sum=0;
        for(j=1;j<n;j++) {
            if (prices[i] > prices[j]) {
                sum += (distance+distances[j-1])*prices[i];
                distance = 0;
                i=j;
                continue;
            }
            distance+=distances[j-1];
        }

        int p = prices[i];
        distance = 0;
        while(i<n-1)
            distance+=distances[i++];

        sum += p*distance;

        System.out.println(sum);
    }
}
