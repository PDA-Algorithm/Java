import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
    static ArrayList<Integer>[] listArray;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        listArray = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=0; i<n+1; i++){
            listArray[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            listArray[a].add(b);
            listArray[b].add(a);
        }

        visited[1] = true;
        dfs(1);

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int root){
        for(int i=0; i<listArray[root].size(); i++){
            int node = listArray[root].get(i);
            if(!visited[node]) {
                visited[node] = true;
                parent[node] = root;
                dfs(node);
            }
        }
    }
}
