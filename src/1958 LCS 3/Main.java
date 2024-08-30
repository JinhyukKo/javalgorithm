import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] str1;
    static char[] str2;
    static char[] str3;
    static Integer[][][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        str3 = br.readLine().toCharArray();
        dp = new Integer[str1.length][str2.length][str3.length];




        System.out.println(lcs(str1.length-1, str2.length-1,str3.length-1));

    }
    public static int lcs(int a, int b,int c) {

        if(a<0||b<0||c<0)
            return 0;

        if(dp[a][b][c]==null) {
            dp[a][b][c]=0;
            if(str1[a] == str2[b] && str2[b]== str3[c]){
                dp[a][b][c] = lcs(a-1, b-1,c-1)+1;
            }
            else
                dp[a][b][c] = Math.max(Math.max(lcs(a-1,b,c), lcs(a,b-1,c)),lcs(a,b,c-1));
        }

        return dp[a][b][c];
    }


}

