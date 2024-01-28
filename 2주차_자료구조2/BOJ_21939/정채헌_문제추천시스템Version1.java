import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제추천시스템Version1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        int t = Integer.parseInt(br.readLine());
        for(int testcase = 0; testcase<t; testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(difficulty, k -> new TreeSet<>()).add(number);
        }

        int t2 = Integer.parseInt(br.readLine());
        for(int testcase = 0; testcase<t2; testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                map.computeIfAbsent(difficulty, k -> new TreeSet<>()).add(number);
            }
            else if(command.equals("recommend")){
                int dne = Integer.parseInt(st.nextToken());
                if(dne == 1){
                    System.out.println(map.lastEntry().getValue().last());
                }
                else if(dne == -1){
                    System.out.println(map.firstEntry().getValue().first());
                }
            }
            else if(command.equals("solved")){
                int number = Integer.parseInt(st.nextToken());
                List<Integer> toRemove = new ArrayList<>();
                map.forEach((difficulty, set) -> {
                    set.remove(number);
                    if (set.isEmpty()) {
                        toRemove.add(difficulty);
                    }
                });
                toRemove.forEach(map::remove);
            }
        }
    }
}
