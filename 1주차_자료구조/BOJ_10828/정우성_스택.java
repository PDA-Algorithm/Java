import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        StringTokenizer st;

        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }

            else if(s.equals("pop")){
                if(stack.empty()){
                    sb.append(-1).append('\n');
                }
                else {
                    sb.append(stack.pop()).append('\n');
                }
            }

            else if(s.equals("empty")){
                if(stack.empty()){
                    sb.append(1).append('\n');
                }
                else {
                    sb.append(0).append('\n');
                }
            }
            else if(s.equals("size")){
                sb.append(stack.size()).append('\n');
            }

            else if(s.equals("top")){

                if(stack.empty()){
                    sb.append(-1).append('\n');
                }
                else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();

    }
}
