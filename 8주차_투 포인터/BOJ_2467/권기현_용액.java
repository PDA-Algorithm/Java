import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2467 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        long[] inputs = new long[N];
        inputs[0] = Long.parseLong(st.nextToken());
        long[] res = new long[2];
        long min = 2_000_000_000;
        for(int i=1; i<N; i++){
            long input = Long.parseLong(st.nextToken());
            long abs = Math.abs(input + inputs[i-1]);
            if(min>abs){
                min = abs;
                res[0] = inputs[i-1];
                res[1] = input;            }
            if(inputs[i-1] < 0 && input >= 0){
                start = i-1;
            }
            if(input >= 0){
                while(start > 0 && inputs[start] >= -input){
                    start--;
                }
                long abs1 = Math.abs(input + inputs[start]);
                long abs2 = Math.abs(input + inputs[start+1]);
                if(min > abs1){
                    min = abs1;
                    res[0] = inputs[start];
                    res[1] = input;
                }
                if(min > abs2 && inputs[start+1] < 0){
                    min = abs2;
                    res[0] = inputs[start+1];
                    res[1] = input;
                }
            }
            inputs[i] = input;
        }
        System.out.println(res[0]+" "+res[1]);
    }
}
