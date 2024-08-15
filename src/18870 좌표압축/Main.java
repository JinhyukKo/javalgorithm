import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] nums =new int[N];
        int [] numsSort = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<N;i++){
            nums[i]= Integer.parseInt(st.nextToken());
            numsSort[i] = nums[i];
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(numsSort);
        int i = 0;
        for(int num :numsSort){
            if(!map.containsKey(num)){
                map.put(num,i++);
            }

        }
        for (int num : nums){
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb.toString());



    }

}




