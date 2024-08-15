import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[] accumulation = new int[N];
        for(int i = 0 ; i<N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        accumulation[0]=nums[0];
        int sum = nums[0];
        for(int i=1;i<N;i++){
            accumulation[i] += accumulation[i-1] + nums[i];
            sum += accumulation[i];
        }

        System.out.println(sum);
    }}