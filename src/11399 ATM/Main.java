import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        fact(dp,N);

    }
    public static void fact(int[] dp,int n){
        dp[0]=1;
        for(int i =1;i<n;i++){
            dp[i]= dp[i-1]*i;

        }
    }
    public static void comb(int n,int r){

    }
}





