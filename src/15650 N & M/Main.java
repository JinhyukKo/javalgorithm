import java.io.*;
import java.util.*;


public class Main {

    static int n,m;
    static  int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         n  = Integer.parseInt(st.nextToken());
         m  = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        dfs(0);

    }
    static void dfs(int depth){
        if(depth==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }
        for(int i =0;i<n;i++){
            if(visited[i]) continue;
            visited[i]=true;
            arr[depth]=i+1;
            dfs(depth+1);
            visited[i]=false;
        }
    }

}