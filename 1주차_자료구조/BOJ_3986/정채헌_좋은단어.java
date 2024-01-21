import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int testcase=0; testcase<t; testcase++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<s.length(); i++){
                Character target = s.charAt(i);

                if(stack.isEmpty()){
                    stack.push(target);
                }
                else{
                    if(stack.peek().equals(target)){
                        stack.pop();
                    }
                    else{
                        stack.push(target);
                    }
                }
            }

            if(stack.isEmpty()){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
