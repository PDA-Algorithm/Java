package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MakeBigger {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(String s: br.readLine().split("")) {
            int num = Integer.parseInt(s);
            while(!stack.isEmpty() && k>0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        while(k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        System.out.print(sb);
    }
}
