import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2531 {

    public static int[] inputs;
    public static int[] count;
    public static int start = 0;
    public static int end = 0;
    public static int max = 0;
    public static int temp = 0;
    public static int c;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        inputs = new int[N];
        count = new int[d+1];
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            addOnlyCount(input, i);
            if(i >= k-1){
                compareMax();
                addStartOne();
            }
        }
        while(start < N){
            addEndOne();
            compareMax();
            addStartOne();
        }
        System.out.println(max);
    }

    public static void addOnlyCount(int input, int index){
        if(count[input] == 0){
            temp++;
        }
        count[input]++;
        inputs[index] = input;

    }

    public static void compareMax(){
        if(count[c] == 0){
            if(temp+1 > max) max = temp+1;
        } else {
            if(temp > max) max = temp;
        }
    }

    public static void addStartOne(){
        if(count[inputs[start]] == 1){
            temp--;
        }
        count[inputs[start]]--;
        start++;
    }

    public static void addEndOne(){
        if(count[inputs[end]] == 0){
            temp++;
        }
        count[inputs[end]]++;
        end++;
    }
}
