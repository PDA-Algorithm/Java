import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 이선영_10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int b = Integer.parseInt(br.readLine());
        String[] command = {};
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < b; i++) {
            command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    s.push(command[1]);
                    break;
                case "pop":
                    if (!s.empty())
                        // System.out.println(s.pop());
                        bw.write(s.pop() + "\n");
                    else
                        bw.write("-1\n");
                    // System.out.println(-1);
                    break;
                case "size":
                    bw.write(s.size() + "\n");
                    // System.out.println(s.size());
                    break;
                case "empty":
                    if (s.empty())
                        bw.write("1\n");
                    // System.out.println(1);
                    else
                        bw.write("0" + "\n");
                    // System.out.println(0);
                    break;
                case "top":
                    if (!s.empty())
                        bw.write(s.peek() + "\n");
                    else
                        bw.write("-1\n");
                    break;
            }

        }

        bw.flush();
    }
}
