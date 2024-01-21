import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                if(s.charAt(i+1) != ')') {
                    count++;
                    answer++;
                }
            }
            else{
                if(s.charAt(i-1) == '('){
                    answer += count;
                }
                else{
                    count--;
                }
            }
        }

        System.out.println(answer);
    }
}
