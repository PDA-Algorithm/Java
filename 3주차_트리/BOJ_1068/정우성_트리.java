import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068 {
    static ArrayList<Integer>[] graph;
    static boolean isVisit[];
    static int parent[];
    static StringTokenizer st;
    static int delete;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        isVisit = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        int root = -1;

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            int p = Integer.parseInt(st.nextToken());

            if(p == -1){
                root = i;
            } else {
                graph[i].add(p);
                graph[p].add(i);
            }
        }
        delete = Integer.parseInt(br.readLine());

        if(delete == root){
            bw.write("0");
            bw.flush();
            return;
        } else{
            dfs(root);
        }
        bw.write(String.valueOf(ans));
        bw.flush();

        bw.close();
        br.close();
    }

    static void dfs(int v) {
        isVisit[v] = true;
        int nodes = 0;
        for (int i = 0; i < graph[v].size(); i++) {
            int cur = graph[v].get(i);
            if (cur != delete && !isVisit[cur]) {
                nodes++;
                dfs(cur);
            }
        }
        if (nodes == 0) {
            ans++;
        }
    }

}
