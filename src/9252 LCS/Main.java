import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] str1;
    static char[] str2;
    static Integer[][] dp;
    static int max = Integer.MIN_VALUE;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length+1][str2.length+1];

        for(int i = 0 ; i <= str2.length;i++){
            dp[0][i] = 0;
        }
        for(int i = 0 ; i <= str1.length;i++){
            dp[i][0] = 0;
        }
        stack = new Stack<>();



        System.out.println(lcs(str1.length, str2.length));
        lcsString(str1.length, str2.length);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
    public static int lcs(int a, int b) {

        if(a<=0||b<=0)
            return 0;

        if(dp[a][b]==null) {
            dp[a][b]=0;
            if(str1[a-1] == str2[b-1]){
                dp[a][b] = lcs(a-1, b-1)+1;
            }
            else
                dp[a][b] = Math.max(lcs(a-1,b), lcs(a,b-1));
        }

        return dp[a][b];
    }
    public static void lcsString(int a, int b) {
        while(a>0&&b>0){
            if(dp[a][b].equals(dp[a-1][b])){
                a--;
            } else if (dp[a][b].equals(dp[a][b-1])){
                b--;
            } else{
                stack.push(str1[--a]);
                b--;
            }
        }




    }

}

