import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int num, len;
        public Node(int num, int len){
            this.num = num;
            this.len = len;
        }
    }
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new ArrayList[t+1];
        for(int i=1; i<t+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<t-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[from].add(new Node(to, len));
            arr[to].add(new Node(from, len));
        }

        answer = 0;
        for(int i=1; i<=t; i++){
            visited = new boolean[t+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int num, int length){
        for(Node node: arr[num]){
            if(!visited[node.num]){
                visited[node.num] = true;
                dfs(node.num, length + node.len);
            }
        }
        answer = Math.max(answer, length);
    }
}
