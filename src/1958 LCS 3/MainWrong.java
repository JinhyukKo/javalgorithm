import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainWrong {

    static char[] str1;
    static char[] str2;
    static char[] str3;
    static Integer[][] dp;
    static Stack<Character> stack;
    static char[] str1and2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        str3= br.readLine().toCharArray();


        dp = new Integer[str1.length+1][str2.length+1];
        stack = new Stack<>();
        lcs(str1.length, str2.length,str1,str2);
        lcsString(str1.length,str2.length);


        str1and2 = new char[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            str1and2[i++] = stack.pop();
        }
        dp =  new Integer[str1and2.length+1][str3.length+1];

        System.out.print(lcs(str1and2.length, str3.length,str1and2,str3));


    }
    public static int lcs(int a, int b,char[] s1, char[] s2) {

        if(a<=0||b<=0)
            return 0;

        if(dp[a][b]==null) {
            dp[a][b]=0;
            if(s1[a-1] == s2[b-1]){
                dp[a][b] = lcs(a-1, b-1,s1,s2)+1;
            }
            else
                dp[a][b] = Math.max(lcs(a-1,b,s1,s2), lcs(a,b-1,s1,s2));
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

