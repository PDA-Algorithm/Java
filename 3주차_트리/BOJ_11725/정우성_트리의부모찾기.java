import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parents;
    static boolean[] isVisited;  // New boolean array to keep track of visited nodes
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        isVisited = new boolean[N + 1];
        graph = new ArrayList[N + 1];f

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        solution();

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution() {
        DFS(1);
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
    }

    static void DFS(int x) {
        isVisited[x] = true;
        for (int i = 0; i < graph[x].size(); i++) {
            int y = graph[x].get(i);
            if (!isVisited[y]) {
                parents[y] = x;
                DFS(y);
            }
        }
    }
}