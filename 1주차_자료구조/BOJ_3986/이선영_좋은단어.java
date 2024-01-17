import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3968 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<Character>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					if (stack.peek() == c) {
						stack.pop();
					} else {
						stack.push(c);
					}
				}
			}
			if(stack.isEmpty()) cnt++;
		}
		
		System.out.println(cnt);
	}

}
