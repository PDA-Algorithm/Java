
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
	static Stack<Character> stack = new Stack<Character>();
	static int tmp = 1;
	static int result = 0;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push(c);
				tmp *= 2;
			} else if (c == '[') {
				stack.push(c);
				tmp *= 3;
			} else {
				if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = true;
						break;
					} else if (str.charAt(i - 1) == '(') {
						result += tmp;
					}
					stack.pop();
					tmp /= 2;
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = true;
						break;
					} else if (str.charAt(i - 1) == '[') {
						result += tmp;
					}
					stack.pop();
					tmp /= 3;
				}
			}

		}

		if (flag || !stack.isEmpty()) {
			result = 0;
		}
		System.out.println(result);
	}

}
