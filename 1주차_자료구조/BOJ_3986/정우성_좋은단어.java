import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < n; i++){

            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for(int j = 0; j < s.length(); j++){

                if(stack.empty()){
                    stack.push(s.charAt(j));
                }
                else if(stack.peek() == s.charAt(j)){
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(j));
                }
            }
            if(stack.empty()){
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

        br.close();
    }
}
