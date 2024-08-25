
import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;


    public Node(int x ,int y) {
        this.x= x;
        this.y=y;
    }
}
public class Main {
    enum Color{
        R,
        G,
        B,
    }
    static Color[][] graph;
    static int n;
    static int countVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());

        graph = new Color[n][n];
        visited = new boolean[n][n];

        for (int i =0; i <n ; i++){
            String line= br.readLine();
            for (int j =0; j <n ; j++){
                String color =String.valueOf(line.charAt(j));
                graph[i][j]=Color.valueOf(color);
            }
        }
        int count =0;
        for (int i =0; i <n ; i++){
            for (int j =0; j <n ; j++){
                if(!visited[i][j]) {
                    {
                        bfs(i, j);
                        count++;
                    }
                }
            }
        }
        for (int i =0; i <n ; i++){
            for (int j =0; j <n ; j++){
                if(graph[i][j]==Color.R){
                    graph[i][j] = Color.G;
                }
            }
        }
        int count2=0;
        visited = new boolean[n][n];
        for (int i =0; i <n ; i++){
            for (int j =0; j <n ; j++){
                if(!visited[i][j]) {
                    {
                        bfs(i, j);
                        count2++;
                    }
                }
            }
        }
        sb.append(count).append(" ").append(count2);
        System.out.println(sb);


    }

    static public void bfs(int x , int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y]=true;
        while (!queue.isEmpty()) {
            Node node =  queue.poll();
            Color current = graph[node.x][node.y];
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >=0 &&nx < n && ny < n && !visited[nx][ny] && graph[nx][ny]==current ){
                    queue.add(new Node(nx,ny));
                    visited[nx][ny]=true;
                }
            }
        }
    }
}