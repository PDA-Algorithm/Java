import java.io.*;
import java.util.*;

public class B9372 {
    static int T;
    static ArrayList<ArrayList<Integer>> graph;	//입력되는 그래프 저장 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        //각 테스트 케이스 진행
        for(int i = 0;i < T; i++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //그래프 값 초기화
            for(int j = 0; j <= N; j++)
                graph.add(new ArrayList<>());
            //그래프 값 저장
            for(int j = 0;j < M; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            bw.write((N-1) + "\n");	// 국가의 수 - 1 값을 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}