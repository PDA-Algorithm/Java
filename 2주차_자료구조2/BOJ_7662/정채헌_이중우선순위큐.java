import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int t=0; t<testcase; t++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int number = Integer.parseInt(br.readLine());
            for(int i=0; i<number; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else if(command.equals("D")){
                    if(map.isEmpty()) continue;
                    int target = (n == 1) ? map.lastKey() : map.firstKey();
                    if(map.get(target) > 1) map.put(target, map.get(target)-1);
                    else map.remove(target);
                }
            }

            if(map.isEmpty()) System.out.println("EMPTY");
            else{
                int max = map.lastKey();
                int min = map.firstKey();
                System.out.println(max + " " + min);
            }
        }
    }
}
