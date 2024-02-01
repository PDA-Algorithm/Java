import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_2 {
	static int N;
	static List<Integer>[] node;
	static int[] parentNode;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // N 입력
		parentNode = new int[N + 1];
		node = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a].add(b);
			node[b].add(a);
		}

		boolean visited[] = new boolean[N + 1];
		visited[0] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);

		while (!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			
			for (int i = 0; i < node[now].size(); i++) {
				int next = node[now].get(i);
				if(!visited[next]) {
					parentNode[next] = now;
					q.offer(next);
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			sb.append(parentNode[i]).append("\n");
		}
		
		

		System.out.println(sb);
	}

}
