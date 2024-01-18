
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String input = br.readLine();
		int result = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				stack.pop();
				if(input.charAt(i-1) == '(')
					result += stack.size();
				else {
					result++;
				}
			}
		}

		System.out.println(result);
	}

}
