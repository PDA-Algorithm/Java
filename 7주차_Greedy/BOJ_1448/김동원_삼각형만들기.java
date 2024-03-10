package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeTriangle {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> straws = new ArrayList<>();
        for(int i=0;i<n;i++)
            straws.add(Integer.parseInt(br.readLine()));

        straws.sort(Collections.reverseOrder());

        // 삼각형의 기준: 두 변의 길이의 합이 나머지 한 변보다 커야함(나머지 한 변은 두 변보다 다 커야함)
        for(int i=0;i<n-2;i++) {
            if(straws.get(i) < straws.get(i+1)+straws.get(i+2)) {
                System.out.print(straws.get(i) +straws.get(i+1)+straws.get(i+2));
                return;
            }
        }

        System.out.print(-1);

    }
}
