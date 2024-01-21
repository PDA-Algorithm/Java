import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 정채헌_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int testcase=0; testcase<t; testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    int target = Integer.parseInt(st.nextToken());
                    stack.push(target);
                    break;
                case "pop":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}
