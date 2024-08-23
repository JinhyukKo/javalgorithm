package hi;
import java.io.*;
import java.util.*;


public class Main {
    static int[][] graph;
    static boolean[] visited;
    static List<Integer> result;
    static int n, m,s;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n + 1];
        result = new LinkedList<>();

        for (int i =0; i <m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] =1 ;
            graph[b][a] =1;

        }

        dfs(s);

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        result.clear();
        visited = new boolean[n+1];
        bfs(s);
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static public void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        visited[s]= true;
        result.add(s);
        queue.add(s);
        while (!queue.isEmpty()) {
            int at = queue.poll();

            for(int i =1; i<=n;i++){
                    if(!visited[i]&&graph[at][i] ==1){
                        visited[i] = true;
                        result.add(i);
                        queue.add(i);
                }
            }

        }
    }
    static public void dfs(int s){
        visited[s]= true;
        result.add(s);
        for(int i =0; i<=n;i++){
            if(!visited[i]&&graph[s][i] ==1){
                dfs(i);
            }
        }
    }
}
