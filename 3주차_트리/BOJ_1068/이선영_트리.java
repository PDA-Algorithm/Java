import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> list[];
	static int result = 0, rm = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		int root = -1;

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == -1) {
				root = i;
				continue;
			} else {
				list[num].add(i);
			}
		}

		rm = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			if (list[i].contains(rm)) {
				list[i].remove(list[i].indexOf(rm));
				break;
			}
		}

		if (rm == root) {
			result = 0;
		} else {
			list[rm].clear();
			dfs(root);
		}

		System.out.println(result);

	}

	public static void dfs(int start) {
		if (list[start].size() == 0) {
			result++;
			return;
		}

		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			dfs(next);

		}
	}

}
