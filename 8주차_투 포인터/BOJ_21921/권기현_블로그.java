import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_21921 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        long[] sumList = new long[N+1];
        int n = 0;
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            if(i != 1){
                sumList[i] = sumList[i-1] + Long.parseLong(st.nextToken());
            } else {
                sumList[i] = Long.parseLong(st.nextToken());
            }
            if(i >= X){
                long temp = sumList[i] - sumList[i-X];
                if(temp > max){
                    max = temp;
                    n = 1;
                } else if(temp == max){
                    n++;
                }
            }
        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(n);
    }
}
