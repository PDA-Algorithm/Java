import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> member = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inOut = st.nextToken();

            if(inOut.equals("enter")){
                member.put(name, 0);
            } else if(inOut.equals("leave")){
                member.remove(name);
            }
        }

        ArrayList<String> memberKeys = new ArrayList<>(member.keySet());
        Collections.sort(memberKeys, Collections.reverseOrder());
        for(String name: memberKeys){
            System.out.println(name);
        }
    }
}
