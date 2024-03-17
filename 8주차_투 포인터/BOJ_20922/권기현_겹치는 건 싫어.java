import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_20922 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] inputs = new int[N];
        int start = 0;
        int[] saveCount = new int[100001];
        int max = 1;
        for(int end=0; end<N; end++) {
            int input = Integer.parseInt(st.nextToken());
            if(saveCount[input] < K){
                saveCount[input]++;
            } else if(saveCount[input] == K){
                while(start<end){
                    if(inputs[start] != input){
                        saveCount[inputs[start]]--;
                        start++;
                    } else {
                        start++;
                        break;
                    }
                }
            }
            if(end-start+1 > max) max = end-start+1;
            inputs[end] = input;
        }
        System.out.println(max);
    }
}