import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<number; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else{
                queue.add(n);
            }
        }
    }
}
